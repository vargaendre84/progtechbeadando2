public class Portfolio
{
    public String portfolio;
    private static final Portfolio instance = new Portfolio();

    private Portfolio() {}

    public static Portfolio getInstance()
    {
        return instance;
    }


    private int osszesNevErtek;
    private double osszesKamat;
    private double osszesKoltseg;

    public Portfolio(int osszesNevErtek, double osszesKamat,double osszesKoltseg)
    {
        this.osszesNevErtek = osszesNevErtek;
        this.osszesKamat = osszesKamat;
        this.osszesKoltseg = osszesKoltseg;
    }

    public double getOsszesNevErtek() { return osszesNevErtek; }
    public void addNevertek(int novekmeny) { osszesNevErtek += novekmeny; }

    public double getOsszesKamat() { return osszesKamat; }
    public void addKamat(double novekmeny) { osszesKamat += novekmeny; }

    public double getOsszesKoltseg() { return osszesKoltseg; }
    public void addKoltseg(double novekmeny) { osszesKoltseg += novekmeny; }
}
