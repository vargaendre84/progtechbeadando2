package KoltsegDecorator;

public class Koltseg_VisszaValtas extends KoltsegDecorator
{
    public Koltseg_VisszaValtas(IKoltseg alapKoltseg) {super(alapKoltseg);}
    private double visszaValtasiKoltseg = 0.02;

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " + visszaváltás járuléka ";
    }

    @Override
    public double getKoltseg(long nevErtek)
    {
        return alapKoltseg.getKoltseg(nevErtek) + nevErtek*visszaValtasiKoltseg;
    }
}
