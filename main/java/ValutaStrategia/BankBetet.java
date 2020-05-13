package ValutaStrategia;
import AllampapirStrategia.KamatozasiStrategia;
import KoltsegStrategia.KoltsegStrategia;

public class BankBetet
{
    BeszerzesiStrategia beszerzes;
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;
    private String nev;

    public BankBetet(BeszerzesiStrategia beszerzes, KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev)
    {
        this.beszerzes = beszerzes;
        this.kamat = kamat;
        this.koltseg = koltseg;
        this.nev = nev;
    }

    public void getNev()
    {
        System.out.println("Bankbetét neve: " + nev);
    }

    public void Beszerzes() {beszerzes.Beszerzes();}

    public void Kamatozas() {
        kamat.Kamatozas();
    }

    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
