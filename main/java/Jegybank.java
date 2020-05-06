public class Jegybank  //very greedy
{
    //long: 2^63 = 9*10^18
    //magyaro 2018-as gdp: 4,2*10^13
    //https://www.ksh.hu/docs/hun/xstadat/xstadat_eves/i_qpt015.html

    public String nev;
    public double alapkamat;
    public long keszpenzallomany;

    private static final Jegybank instance = new Jegybank();

    private Jegybank() {}

    public static Jegybank getInstance()
    {
        return instance;
    }
}
