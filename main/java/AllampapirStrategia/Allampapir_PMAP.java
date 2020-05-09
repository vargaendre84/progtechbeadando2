package AllampapirStrategia;

public class Allampapir_PMAP extends AllamPapir
{
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;
    private String nev;
    private long nevErtek;

    public Allampapir_PMAP(KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev)
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
        Allampapir_PMAP uj = new Allampapir_PMAP(kamat,koltseg,nev);
        uj.nev = nev;
        return uj;
    }
}
