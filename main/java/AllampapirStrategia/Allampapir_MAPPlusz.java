package AllampapirStrategia;

import KoltsegStrategia.KoltsegStrategia;

public class Allampapir_MAPPlusz extends AllamPapir
{
    VasarlasiStrategia vasarlas;
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;
    private String nev;

    public Allampapir_MAPPlusz(VasarlasiStrategia vasarlas, KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev)
    {
        this.vasarlas = vasarlas;
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
    public void Vasarlas() {vasarlas.Vasarlas();}
    @Override
    public void Kamatozas() {
        kamat.Kamatozas();
    }
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
