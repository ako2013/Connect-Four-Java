public class Model
{
   private int[][] connect_4;
   private int player;
   private int move;
   private int winning;
   
   public Model(int size)
   {
      this.connect_4 = new int[size][size];
   }
   
   public int[][] getSize() {return connect_4;}
   public int getPlayer() {return player;}
   public int getMove(){return move;}
   public int getWinning(){return winning;}
   
}