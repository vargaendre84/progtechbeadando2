package Portfolio;

public class Egyenleg    //greedy singleton
{
    public String portfolio;
    private static final Egyenleg instance = new Egyenleg();
    private Egyenleg() {}
    public static Egyenleg getInstance()
    {
        return instance;
    }

    private long osszesNevErtek;
    private double osszesKamat;
    private double osszesKoltseg;
    private double osszesArfolyamNyereseg;
    private boolean otthoniTrezorKialakitva;

    public Egyenleg(int osszesNevErtek, double osszesKamat, double osszesKoltseg, double osszesArfolyamNyereseg, boolean otthoniTrezorKialakitva)
    {
        this.osszesNevErtek = osszesNevErtek;
        this.osszesKamat = osszesKamat;
        this.osszesKoltseg = osszesKoltseg;
        this.osszesArfolyamNyereseg = osszesArfolyamNyereseg;
        this.otthoniTrezorKialakitva = otthoniTrezorKialakitva;
    }

    public long getOsszesNevErtek() { return osszesNevErtek; }
    public void addNevertek(long novekmeny) { osszesNevErtek += novekmeny; }
    public double getOsszesKamat() { return osszesKamat; }
    public void addKamat(double novekmeny) { osszesKamat += novekmeny; }
    public double getOsszesKoltseg() { return osszesKoltseg; }
    public void addKoltseg(double novekmeny) { osszesKoltseg += novekmeny; }
    public void addArfolyamNyereseg(double novekmeny) {osszesArfolyamNyereseg += novekmeny;}
    public double getOsszesArfolyamNyereseg() { return osszesArfolyamNyereseg; }
    public double getMerleg() {return (osszesKamat - osszesKoltseg);}
    public boolean getOtthoniTrezorKialakitva() {return otthoniTrezorKialakitva;}
    public void setOtthoniTrezorKialakitva(boolean ertek) { otthoniTrezorKialakitva = ertek;}
}