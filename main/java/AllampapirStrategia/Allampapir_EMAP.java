package Strategy;

public class Allampapir_EMAP extends AllamPapir
{
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;
    private String nev;

    public Allampapir_EMAP(KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev)
    {
        this.kamat = kamat;
        this.koltseg = koltseg;
        this.nev = nev;
    }

    @Override
    public void getNev()
    {
        System.out.println("Állampapír neve: " + nev);
    }

    @Override
    public void Kamatozas() {
        kamat.Kamatozas();
    }

    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
