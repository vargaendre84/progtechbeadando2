import AllampapirStrategia.KamatozasiStrategia;
import AllampapirStrategia.KoltsegStrategia;

public class Valuta_HUF
{
    KoltsegStrategia koltseg;
    private String nev;

    public Valuta_HUF(KoltsegStrategia koltseg, String nev)
    {
        this.koltseg = koltseg;
        this.nev = nev;
    }
    public void getNev()
    {
        System.out.println(nev);
    }
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
