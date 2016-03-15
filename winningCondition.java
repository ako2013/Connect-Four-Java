//this class returns 1 if a player win
//return 0 if not

public class winningCondition
{
   private Model model;
   private int winning;       //return 1 if a player win
   private int num;           
   private int player;        //player #: 1 or 2
   private int col;           //column that player input
   private int[][] connect_4; //store the table
   private int row;           //store the size of the table (row * row) e.g 6x6
   
   public winningCondition(Model model)
   {
      this.model = model;
      //this.num = num;
      this.player = model.getPlayer();
      //this.col = col;
      this.connect_4 = model.getSize();
      this.winning = model.getWinning();
      this.row = model.getRow();
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