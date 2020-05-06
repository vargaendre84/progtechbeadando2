public class KoltsegStrategia
{
    private int nevErtek;
    private int lejaratiIdo;
    private int futamIdo;
    private double kamat;
    private boolean tbsz;

    Portfolio myPortfolio = Portfolio.getInstance();

    public KoltsegStrategia(int nevErtek, int lejaratiIdo, int futamIdo, double kamat, boolean tbsz)
    {
        this.nevErtek = nevErtek;
        this.lejaratiIdo = lejaratiIdo;
        this.futamIdo = futamIdo;
        this.kamat = kamat;
        this.tbsz = tbsz;
    }

    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_VisszaValtas(new Koltseg_Jutalek(new Koltseg_ErtekPapirSzamla(new Koltseg_Alap())));
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek,lejaratiIdo,futamIdo);
        System.out.println(aktualisKoltseg);
        myPortfolio.addKoltseg(aktualisKoltseg);
    }
}
