public class Model
{
   private int[][] connect_4;
   private int row;
   private int winning;   
   private int winningSize;
   private int size;
   
   public Model(int size)
   {
      this.connect_4 = new int[size][size];
      this.size = size;
      this.winningSize = 4;
   }
   
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
   
   public int insertBoard(int move, int player){
      for(int i = 0; i < size;i++)
      {
         if(connect_4[move][i] == 0)
         {
            connect_4[move][i] = player;
            return checkWinning(move,player,i);
         } else if (connect_4[move][size - 1] != 0) {
        	 return 2; //Cannot choose row because it's full
         }
      }
      return 0;
   }
   
   public boolean isDraw(int[][] board) {
       for (int i = 0; i < board.length; i++)
           for (int j = 0; j < board[i].length; j++)
               if (board[i][j] == 0)
                   return false;
       return true; // Cells are all now occupied
   }
   
   //Insert to board and also return the winning condition 
   public int setMove(int move, int player){
      return this.winning = insertBoard(move,player);
   }
   
   public int[][] getTable() {return connect_4;}
   public int getSize()     {return size;}
   public int getWinning()  {return winning;}
   public int getRow()      {return row;} 
  
}