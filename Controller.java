public class Controller
{
   public Controller()
   {
      //winningCondition WC = new winningCondition(this);
   }  
   public static void main (String[]args)
   {
      Model model = new Model(6);
      CLIView view = new CLIView(model);
   }
}