
//Model.java
//version 1.0
import java.util.Arrays;

/**
 * This model class holds information about a connect four board
 * @author Hung Tran and Ravuth Long
 *
 */
public class Model
{
   //variables declaration
   private int[][] connect_4;
   private int winning;   
   private int winningSize;
   private int size;
   private int player;
   
   /**
    * The constructor for the connect 4 model
    * @param size The size of the square board
    * @param winningSize The number of connections required to win
    */
   public Model(int size, int winningSize)
   {
      this.connect_4 = new int[size][size];
      this.size = size;
      this.winningSize = winningSize;
      this.player = 1;
   }
   
   /**
    * A methods that checks whether a particular player is winning
    * Checks 3 win connections: horizontal, vertical, and diagonal
    * @param move The current place to check
    * @param player The current player's turn number
    * @param col The particular column number
    * @return 1 if there is a win condition, 0 otherwise
    */
   public int checkWinning(int move, int player, int col){
        int check = 0;
      
        //Check Vertically
        for(int j = 0; j < size;j++){
           if(connect_4[move][j] == player){
               check++;
               if(check == winningSize) return 1;
           } else check = 0;
       }
        check = 0; //Reset count for the next condition
       
       //Check Horizontally
       for(int j = 0; j < size;j++){
           if(connect_4[j][col] == player){
               check++;
               if(check == winningSize) return 1;
           } else check = 0;
       }
       check = 0; //Reset count for the next condition
       
       //check diagonally up/down
       for(int k = 0; k < size * 2; k++){ //check diagonally up
           for(int j = 0; j <= k; j++){
               int i = k-j;
               if(i < size && j < size){
                   if(connect_4[i][j] == player){
                       check++;
                       if(check == winningSize) return 1;
                   } else check = 0; //Reset count

               }
           }
           check = 0; //Reset count for the next condition
           for(int j = 0; j <= k; j++){ //check diagonally down
               int i = k-j;
               int x = size-1-i;
               if(i < size && j < size){
                   if(connect_4[x][j] == player){
                       check++;
                       if(check == winningSize) return 1;
                       
                   } else check = 0; //Reset count 

               }
           }
           check = 0; //Reset count for the next condition
       }
       return 0;
   }
   
   /**
    * A method that adds a player counter on the board
    * @param move The current column position
    * @param player The current player's turn counter
    * @return 0 if successful add, 1 if a player has a win condition, 2 if unable to add
    */
   public int insertBoard(int move, int player){
	   
      for(int i = 0; i < size;i++)
      {
         if(connect_4[move][i] == 0)
         {
            connect_4[move][i] = player;
            System.out.println("insert at index x pos: " + move + " and y pos: " + i);
            return checkWinning(move,player,i);
         } else if (connect_4[move][size - 1] != 0) {
        	 return 2; //Cannot choose row because it's full
         }
      }
      return 0;
   }
   
   /**
    * Checks to see whether the board is a draw
    * @return true if the board has a draw, false otherwise.
    */
   public boolean isDraw() {
       for (int i = 0; i < size; i++){
         if(connect_4[i][size-1] == 0) return false;
       }
       return true;
   }

   /**
    * A function that changes the current turn counter
    */
   public void turn()
   {
	   if (player == 1) player = 2;
	   else             player = 1;
   }
  
  /**
   * Gets the current board as a 2D array 
   * @return The board as a 2d array
   */
   public int[][] getTable() {return connect_4;}
   
   /**
    * Gets the current side dimensions of the board
    * @return The size dimensions of the board
    */
   public int getSize()      {return size;}
   
   /**
    * Gets the winning value if there is a win condition on the board
    * @return The winning number
    */
   public int getWinning()   {return winning;}
   
   /**
    * Gets the current player turn count
    * @return The number of the current player
    */
   public int getPlayer()    {return player;}
  
}