//example for board size 6x6
//not implant A.I yet
//version 1.0

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
      int checkFullRow;
      
      System.out.println("Welcome to connect 4");
      do
      {	  
         do {
        	 printBoard();
             System.out.println("Player 1: Please choose a number (1->6)");
             this.move = input.nextInt();
        	 checkFullRow = model.setMove(move-1,1);
         } while (checkFullRow == 2);
         
         if(model.getWinning() == 1)
         {
            printBoard();
            System.out.println("Player have 1 won");
            break;
         } else if (model.isDraw(connect_4)) {
        	 System.out.println("DRAW GAME!");
        	 break;
         }
         
         do {
        	 printBoard();
             System.out.println("Player 2: Please choose a number (1->6)");
             this.move = input.nextInt();
        	 checkFullRow = model.setMove(move-1,2);
         } while (checkFullRow == 2);
         
         if(model.getWinning() == 1)
         {
            printBoard();
            System.out.println("Player have 2 won");
            break;
         } else if (model.isDraw(connect_4)) {
        	 System.out.println("DRAW GAME!");
        	 break;
         }
      }while(move != 9);
   }
   //rotated the board for easy access 2D array
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