package ValutaStrategia;
import Portfolio.Egyenleg;

public class ArfolyamStrategia_USD extends ArfolyamStrategia
{
    private long nevErtek;
    private double veteliArfolyam;
    double aktualisArfolyam;
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public ArfolyamStrategia_USD(long nevErtek, double veteliArfolyam, double aktualisArfolyam)
    {
        this.nevErtek = nevErtek;
        this.veteliArfolyam = veteliArfolyam;
        this.aktualisArfolyam = aktualisArfolyam;
    }

    @Override
    public void ArfolyamNyereseg()
    {
        double arfolyamNyereseg = nevErtek * (aktualisArfolyam - veteliArfolyam);
        myEgyenleg.addArfolyamNyereseg(arfolyamNyereseg);
        System.out.println("Az amerikai Dollárban tartott összeg árfolyamnyeresége: " + arfolyamNyereseg);
    }
}