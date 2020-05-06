public class Kamatozas_InflacioAlapu extends Strategia_Kamatozasi
{
    private int nevErtek;
    private int jegyzesDatum;
    private int futamIdo;
    private double kamatPremium;
    private boolean tbsz;

    Kamatado kamatado = new Kamatado();
    Inflacio inflacio = new Inflacio();
    Portfolio myPortfolio = Portfolio.getInstance();

    public Kamatozas_InflacioAlapu(int nevErtek, int jegyzesDatum, int futamIdo, double kamatPremium, boolean tbsz)
    {
        this.nevErtek = nevErtek;
        this.jegyzesDatum = jegyzesDatum;
        this.futamIdo = futamIdo;
        this.kamatPremium = kamatPremium;
        this.tbsz = tbsz;
    }

    @Override
    public void Kamatozas()
    {
        double aktualisKamat = 0.0;
        int aktualisEv = jegyzesDatum;
        for(int i = 0; i < futamIdo; i++)
        {
            aktualisKamat += nevErtek * (kamatPremium + inflacio.getEvesInflacio(aktualisEv)) * (1.0 - kamatado.getKamatado(tbsz));
            aktualisEv++;
        }
        System.out.println(aktualisKamat) ;
        myPortfolio.addNevertek(nevErtek);
        myPortfolio.addKamat(aktualisKamat);
    }

}
