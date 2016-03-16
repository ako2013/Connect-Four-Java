public class Controller
{
   private int size;
   public Controller(int size)
   {
      this.size = size;
   }  
   public static void main (String[]args)
   {
      Model model = new Model(6);
      CLIView view = new CLIView(model);
   }
}