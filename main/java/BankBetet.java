import AllampapirStrategia.KamatozasiStrategia;
import AllampapirStrategia.KoltsegStrategia;

public class BankBetet
{
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;
    private String nev;

    public BankBetet(KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev)
    {
        this.kamat = kamat;
        this.koltseg = koltseg;
        this.nev = nev;
    }

    public void getNev()
    {
        System.out.println("Bankbetét neve: " + nev);
    }

    public void Kamatozas() {
        kamat.Kamatozas();
    }

    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
