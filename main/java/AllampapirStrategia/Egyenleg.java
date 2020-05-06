package Strategy;

public class Egyenleg
{
    public String portfolio;
    private static final Egyenleg instance = new Egyenleg();

    private Egyenleg() {}
    public static Egyenleg getInstance()
    {
        return instance;
    }

    private int osszesNevErtek;
    private double osszesKamat;
    private double osszesKoltseg;

    public Egyenleg(int osszesNevErtek, double osszesKamat, double osszesKoltseg)
    {
        this.osszesNevErtek = osszesNevErtek;
        this.osszesKamat = osszesKamat;
        this.osszesKoltseg = osszesKoltseg;
    }

    public int getOsszesNevErtek() { return osszesNevErtek; }
    public void addNevertek(int novekmeny) { osszesNevErtek += novekmeny; }
    public double getOsszesKamat() { return osszesKamat; }
    public void addKamat(double novekmeny) { osszesKamat += novekmeny; }
    public double getOsszesKoltseg() { return osszesKoltseg; }
    public void addKoltseg(double novekmeny) { osszesKoltseg += novekmeny; }

    public double getMerleg() {return (osszesKamat - osszesKoltseg);}
}
