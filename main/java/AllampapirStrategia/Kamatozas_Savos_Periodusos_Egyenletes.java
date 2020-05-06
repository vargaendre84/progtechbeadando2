public class Kamatozas_Savos_Periodusos_Egyenletes extends KamatozasiStrategia
{
    private int periodusSzam;
    private int periodusHossz;
    private double kamatValtozas;
    private boolean tbsz;

    public Kamatozas_Savos_Periodusos_Egyenletes(int periodusSzam, int periodusHossz, double kamatValtozas)
    {
        this.periodusSzam = periodusSzam;
        this.periodusHossz = periodusHossz;
        this.kamatValtozas = kamatValtozas;
    }


    @Override
    public void Kamatozas()
    {
        System.out.println();
    }
}
