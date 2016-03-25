import java.util.Scanner;

public class Controller2 
{
	public static void main(String[] args)
	{
		try 
		{
			int size = Integer.parseInt(args[0]);
			int winSize = Integer.parseInt(args[3]);
			if (size > 10 || size < 4)
			{
				System.out.println("Please input a size smaller than 10 and greater than 4");				
			}
			else if (winSize < 3 || winSize > 9 )
			{
				System.out.println("Please ensure that the win size is greater than 3 and smaller than 9");
			}
			else if (winSize >= size)
			{
				System.out.println("Please ensure that the win size is less than the board size");
			}
			new ViewSwing(size , winSize);
			
		} 
		catch (NumberFormatException e) 
		{
			System.out.println("Please input two integers");
		}
		
		System.out.println("Welcome to connect 4");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the board size: ");
		int boardSize = input.nextInt();
		System.out.println("Enter the connection size: ");
		int winningSize = input.nextInt();
		ViewSwing tmp = new ViewSwing(boardSize, winningSize);
	}
}
