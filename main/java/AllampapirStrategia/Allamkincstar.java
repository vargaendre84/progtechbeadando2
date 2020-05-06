public class Allamkincstar  //greedy
{
   public String allamkincstar;
   private static final Allamkincstar instance = new Allamkincstar();

   private Allamkincstar() {}

   public static Allamkincstar getInstance()
        {
            return instance;
        }
}
