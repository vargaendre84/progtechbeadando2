public class Allampapir_PMAP extends AllamKotveny
{
    Strategia_Kamatozasi kamat;
    private String nev;

    public Allampapir_PMAP(Strategia_Kamatozasi kamat, String nev)
    {
        this.kamat = kamat;
        this.nev = nev;
    }

    @Override
    public void getNev()
    {
        System.out.println(nev);
    }

    @Override
    public void Kamatozas() {
        kamat.Kamatozas();
    }

    @Override
    public void Koltsegek() {
    }
}
