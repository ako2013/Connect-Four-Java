public class winningCondition
{
   private int winning;
   private int num;
   private int player;
   private int col;
   private int[][] connect_4;
   
   public winningCondition(int num, int player, int col,int connect_4[][])
   {
      this.num = num;
      this.player = player;
      this.col = col;
      this.connect_4 = connect_4;
      this.winning = checkWinning();
   }
   
   public int checkWinning()
   {
        int check = 0;
      
        //check horizontally
        for(int j = 0; j < 6;j++){
           if(connect_4[num][j] == player){
               check++;
           }else
               check = 0; //reset the count
           if(check == 4)
               return 1;
       }check = 0; //reset the count for next condition
       
       //check vertically
       for(int j = 0; j < 7;j++){
           if(connect_4[j][col] == player){
               check++;
               if(check == 4)
                   return 1;
           }else check = 0;
       }check =0; //reset the count for next condition
       
       //check diagonally up/down
       for(int k = 0; k < 7*2;k++){          //check diagonally up
           for(int j = 0; j <= k; j++){
               int i = k-j;
               //int x = 6-i;
               if(i < 7 && j < 6){
                   if(connect_4[i][j] == player){
                       check++;
                       if(check == 4) return 1;
                   }else check = 0; //reset count
               }
           }check = 0; //reset the count for next condition
           for(int j = 0; j <= k; j++){     //check diagonally down
               int i = k-j;
               int x = 6-i;
               if(i < 7 && j < 6){
                   if(connect_4[x][j] == player){
                       check++;
                       if(check == 4) return 1;
                   }else check = 0;
               }
           }check = 0;
       }return 0;
   }
   public int getWinningCondition() { return winning;}
}