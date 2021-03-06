package ValutaStrategia;
import KoltsegStrategia.KoltsegStrategia;

public class Valuta_EUR extends Valutak
{
    BeszerzesiStrategia beszerzes;
    ArfolyamStrategia arfolyam;
    KoltsegStrategia koltseg;
    private String nev;

    public Valuta_EUR(BeszerzesiStrategia beszerzes, ArfolyamStrategia arfolyam,KoltsegStrategia koltseg, String nev)
    {
        this.beszerzes = beszerzes;
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
    public void Beszerzes() { beszerzes.Beszerzes(); }
    @Override
    public void ArfolyamNyereseg(){arfolyam.ArfolyamNyereseg();}
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
