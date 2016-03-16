import java.util.*;

public class CLIView
{
   private Model model;
   private int move;
   private int[][] connect_4;
   
   public CLIView(Model model)
   {      
      this.model = model;
      this.connect_4 = model.getTable();
      
      Scanner input = new Scanner(System.in);
      
      System.out.println("Welcome to conect 4");
      do
      {
         printBoard();
         System.out.println("Please choose a number (1->6)");
         this.move = input.nextInt();
         model.setMove(move-1,1);
         if(model.getWinning() == 1)
         {
            printBoard();
            System.out.println("Player have won");
            break;
         }
      }while(move != 9);
   }
   public void printBoard()
   {
      System.out.println("1 2 3 4 5 6");
      System.out.println("-----------");
      for(int i = model.getSize()-1; i >= 0;i--)
      {
         for(int j = 0; j < model.getSize();j++)
         {
            System.out.print(connect_4[j][i] + " ");
         }
         System.out.println();
      }
   }
}