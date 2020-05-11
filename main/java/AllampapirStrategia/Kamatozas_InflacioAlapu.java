package AllampapirStrategia;
import Portfolio.Egyenleg;

public class Kamatozas_InflacioAlapu extends KamatozasiStrategia
{
    private long nevErtek;
    private int lejaratiIdo;
    private int futamIdo;
    private double kamatPremium;
    private boolean tbsz;

    Kamatado kamatado = new Kamatado();
    Inflacio inflacio = new Inflacio();
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public Kamatozas_InflacioAlapu(long nevErtek, int lejaratiIdo, int futamIdo, double kamatPremium, boolean tbsz)
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
        int aktualisEv = 2020;
        if( futamIdo > lejaratiIdo) futamIdo = lejaratiIdo;
        for(int i = 0; i < futamIdo; i++)
        {
            aktualisKamat += nevErtek * (kamatPremium + inflacio.getEvesInflacio(aktualisEv)) * (1.0 - kamatado.getKamatado(tbsz));
            aktualisEv++;
        }
        System.out.println("Kamatozás: " + aktualisKamat) ;
        myEgyenleg.addKamat(aktualisKamat);
    }
}
