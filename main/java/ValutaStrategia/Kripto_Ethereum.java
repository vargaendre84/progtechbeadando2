package ValutaStrategia;
import KoltsegStrategia.KoltsegStrategia;

public class Kripto_Ethereum extends KriptoValuta
{
    BeszerzesiStrategia beszerzes;
    ArfolyamStrategia arfolyam;
    KoltsegStrategia koltseg;
    private String nev;

    public Kripto_Ethereum(BeszerzesiStrategia beszerzes, ArfolyamStrategia arfolyam,KoltsegStrategia koltseg, String nev)
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
    public void setNev(String nev) { this.nev = nev;}
    @Override
    public void Beszerzes() { beszerzes.Beszerzes(); }
    @Override
    public void ArfolyamNyereseg(){arfolyam.ArfolyamNyereseg();}
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}

    @Override
    public Object Clone()
    {
        Kripto_Ethereum uj = new Kripto_Ethereum(beszerzes,arfolyam,koltseg,nev);
        uj.nev = nev;
        return uj;
    }
}
