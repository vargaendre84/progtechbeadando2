package Strategy;

public class Allampapir_MAPPlusz extends AllamPapir
{
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;
    private String nev;
    private long nevErtek;

    public Allampapir_MAPPlusz(KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev)
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
    public void setNev(String ujnev) { this.nev = ujnev; }

    @Override
    public void Kamatozas() {
        kamat.Kamatozas();
    }
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}

    @Override
    public Object Clone()
    {
        Allampapir_MAPPlusz uj = new Allampapir_MAPPlusz(kamat,koltseg,nev);
        uj.nev = nev;
        return uj;
    }
}
