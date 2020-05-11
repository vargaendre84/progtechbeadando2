package AllampapirStrategia;
import Intezmenyek.Allamkincstar;
import Portfolio.Egyenleg;

public class Kamatozas_Normal extends KamatozasiStrategia
{
    private long nevErtek;
    private int futamIdo;
    private double kamat;
    private boolean tbsz;

    Kamatado kamatado = new Kamatado();
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public Kamatozas_Normal(long nevErtek, int futamIdo,  double kamat, boolean tbsz)
    {
        this.nevErtek = nevErtek;
        this.futamIdo = futamIdo;
        this.kamat = kamat;
        this.tbsz = tbsz;
    }

    @Override
    public void Kamatozas()
    {
        double aktualisKamat = (nevErtek * kamat * (1.0 - kamatado.getKamatado(tbsz))) * futamIdo;
        System.out.println("Kamatozás: " + aktualisKamat);
        myEgyenleg.addKamat(aktualisKamat);
    }
}
