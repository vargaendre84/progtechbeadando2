package ValutaStrategia;
import Portfolio.Egyenleg;

public class ArfolyamStrategia_EUR extends ArfolyamStrategia
{
    private long nevErtek;
    private double veteliArfolyam;
    private double aktualisArfolyam;
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public ArfolyamStrategia_EUR(long nevErtek, double veteliArfolyam, double aktualisArfolyam)
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
        System.out.println("Az Euróban tartott összeg árfolyamnyeresége: " + arfolyamNyereseg);
    }
}
