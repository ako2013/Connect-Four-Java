import java.util.Scanner;

public class Controller
{
   private int size;
   public Controller(int size)
   {
      this.size = size;
   }  
   public static void main (String[]args)
   {
	  System.out.println("Welcome to connect 4");
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter the board size: ");
	  int boardSize = input.nextInt();
	  System.out.println("Enter the connection size: ");
	  int winningSize = input.nextInt();
      Model model = new Model(boardSize, winningSize);
      CLIView view = new CLIView(model);
   }
}