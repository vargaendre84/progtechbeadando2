package ValutaStrategia;
import KoltsegStrategia.KoltsegStrategia;

public class Valuta_HUF extends Valutak
{
    BeszerzesiStrategia beszerzes;
    KoltsegStrategia koltseg;
    private String nev;

    public Valuta_HUF(BeszerzesiStrategia beszerzes, KoltsegStrategia koltseg, String nev)
    {
        this.beszerzes = beszerzes;
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
    public void ArfolyamNyereseg(){}
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
