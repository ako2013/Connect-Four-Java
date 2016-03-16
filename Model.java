public class Model
{
   private int[][] connect_4;
   //private int player;
   //private int move;
   private int row;
   //private int col;
   private int winning;   
   private int winningSize;
   private int size;
   
   public Model(int size)
   {
      this.connect_4 = new int[size][size];
      //this.row = size;
      this.size = size;
      this.winningSize = 4;
      //this.move = move;
   }
   
   public int checkWinning(int move, int player, int col){
        int check = 0;
      
        //check horizontally
        for(int j = 0; j < size;j++){
           if(connect_4[row][j] == player){
               check++;
           }else
               check = 0; //reset the count
           if(check == winningSize)
               return 1;
       }check = 0; //reset the count for next condition
       
       //check vertically
       for(int j = 0; j < size;j++){
           if(connect_4[j][col] == player){
               check++;
               if(check == winningSize)
                   return 1;
           }else check = 0;
       }check =0; //reset the count for next condition
       
       //check diagonally up/down
       for(int k = 0; k < size*2;k++){          //check diagonally up
           for(int j = 0; j <= k; j++){
               int i = k-j;
               if(i < size && j < size){
                   if(connect_4[i][j] == player){
                       check++;
                       if(check == winningSize) return 1;
                   }else check = 0; //reset count
               }
           }check = 0; //reset the count for next condition
           for(int j = 0; j <= k; j++){     //check diagonally down
               int i = k-j;
               int x = size-1-i;
               if(i < size && j < size){
                   if(connect_4[x][j] == player){
                       check++;
                       if(check == winningSize) return 1;
                   }else check = 0;
               }
           }check = 0;
       }return 0;
   }
   
   public int insertBoard(int move, int player){
      for(int i = 0; i < size;i++)
      {
         if(connect_4[move][i] == 0)
         {
            connect_4[move][i] = player;
            return checkWinning(move,player,i);
         }
      }
      return 0;
   }
   
   public int[][] getTable() {return connect_4;}
   public int getSize()     {return size;}
   //public int getPlayer()   {return player;}
   //public int getMove()     {return move;}
   public int getWinning()  {return winning;}
   public int getRow()      {return row;} 
   
   //also return the winning condition 
   public int setMove(int move, int player){
      return this.winning = insertBoard(move,player);
   }
   
}