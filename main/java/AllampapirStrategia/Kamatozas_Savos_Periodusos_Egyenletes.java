package AllampapirStrategia;

import Portfolio.Egyenleg;

public class Kamatozas_Savos_Periodusos_Egyenletes extends KamatozasiStrategia
{
    private long nevErtek;
    private int lejaratiIdo;
    private int futamIdo;
    private double alapKamat;
    private int periodusHossz;
    private double kamatValtozas;
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public Kamatozas_Savos_Periodusos_Egyenletes(long nevErtek, int lejaratiIdo, int futamIdo, double alapKamat, int periodusHossz, double kamatValtozas)
    {
        this.nevErtek = nevErtek;
        this.lejaratiIdo = lejaratiIdo;
        this.futamIdo = futamIdo;
        this.alapKamat = alapKamat;
        this.periodusHossz = periodusHossz;
        this.kamatValtozas = kamatValtozas;
    }

    @Override
    public void Kamatozas()
    {
        double aktualisKamatErtek = 0.0;
        double aktualisKamatLab = alapKamat;
        if( futamIdo > lejaratiIdo) futamIdo = lejaratiIdo;
        for(int i = 0; i < futamIdo; i++)
        {
            aktualisKamatErtek += nevErtek * aktualisKamatLab;
            if(i % periodusHossz == 0) aktualisKamatLab += kamatValtozas;
        }
        System.out.println("Kamatozás: " + aktualisKamatErtek) ;
        myEgyenleg.addKamat(aktualisKamatErtek);
    }
}
