package AllampapirStrategia;

public class Kamatozas_Normal extends KamatozasiStrategia
{
    private int nevErtek;
    private int lejaratiIdo;
    private int futamIdo;
    private double kamat;
    private boolean tbsz;

    Kamatado kamatado = new Kamatado();
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public Kamatozas_Normal(int nevErtek, int lejaratiIdo, int futamIdo,  double kamat, boolean tbsz)
    {
        this.nevErtek = nevErtek;
        this.lejaratiIdo = lejaratiIdo;
        this.futamIdo = futamIdo;
        this.kamat = kamat;
        this.tbsz = tbsz;
    }
    public Kamatozas_Normal()
    {
        this.nevErtek = 1000000;
        this.futamIdo = 3;
        this.kamat = 0.01;
        this.tbsz = true;
    }

    @Override
    public void Kamatozas()
    {
        double aktualisKamat = (nevErtek * kamat * (1.0 - kamatado.getKamatado(tbsz))) * futamIdo;
        System.out.println("Kamatozás: " + aktualisKamat);
        myEgyenleg.addKamat(aktualisKamat);
    }

}
