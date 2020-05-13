package ValutaStrategia;
import Portfolio.Egyenleg;

public class ArfolyamStrategia_Kripto_Ethereum extends ArfolyamStrategia
{
    private double nevErtek;
    private double veteliArfolyam;
    private double aktualisArfolyam;
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public ArfolyamStrategia_Kripto_Ethereum(double nevErtek, double veteliArfolyam, double aktualisArfolyam)
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
        System.out.println("Az Ethereumban tartott összeg árfolyamnyeresége: " + arfolyamNyereseg);
    }
}
