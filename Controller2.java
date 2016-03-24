
public class Controller2 
{
	public static void main(String[] args)
	{
		try 
		{
			int size = Integer.parseInt(args[0]);
			int winSize = Integer.parseInt(args[3]);
			if (size > 10 || size < 0)
			{
				System.out.println("Please input a size greater than 10");				
			}
			else if (winSize < 0)
			{
				System.out.println("Please ensure that the win size is greater than zero");
			}
			else if (winSize > size)
			{
				System.out.println("Please ensure that the win size is less than the board size");
			}
			new ViewSwing(size , winSize);
			
		} 
		catch (NumberFormatException e) 
		{
			System.out.println("Please input two integers");
		}
		
	}
}
