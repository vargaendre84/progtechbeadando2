import java.rmi.dgc.Lease;

public class Kamatozas_InflacioAlapu extends KamatozasiStrategia
{
    private int nevErtek;
    private int lejaratiIdo;
    private int futamIdo;
    private double kamatPremium;
    private boolean tbsz;

    Kamatado kamatado = new Kamatado();
    Inflacio inflacio = new Inflacio();
    Portfolio myPortfolio = Portfolio.getInstance();

    public Kamatozas_InflacioAlapu(int nevErtek, int lejaratiIdo, int futamIdo, double kamatPremium, boolean tbsz)
    {
        this.nevErtek = nevErtek;
        this.lejaratiIdo = lejaratiIdo;
        this.futamIdo = futamIdo;
        this.kamatPremium = kamatPremium;
        this.tbsz = tbsz;
    }

    @Override
    public void Kamatozas()
    {
        double aktualisKamat = 0.0;
        int aktualisEv = lejaratiIdo;
        if( futamIdo > lejaratiIdo) futamIdo = lejaratiIdo;
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
