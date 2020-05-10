package ValutaStrategia;
import AllampapirStrategia.KoltsegStrategia;

public class Valuta_EUR extends Valutak
{
    ArfolyamStrategia arfolyam;
    KoltsegStrategia koltseg;
    private String nev;

    public Valuta_EUR(ArfolyamStrategia arfolyam,KoltsegStrategia koltseg, String nev)
    {
        this.arfolyam = arfolyam;
        this.koltseg = koltseg;
        this.nev = nev;
    }
    @Override
    public void getNev()
    {
        System.out.println(nev);
    }

    @Override
    public void ArfolyamNyereseg(){arfolyam.ArfolyamNyereseg();}

    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
