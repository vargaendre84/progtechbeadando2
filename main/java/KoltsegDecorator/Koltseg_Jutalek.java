package KoltsegDecorator;

public class Koltseg_Jutalek extends KoltsegDecorator
{
    private static double alapJutalek = 0.01;
    public Koltseg_Jutalek(IKoltseg alapKoltseg) {super(alapKoltseg);}

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " + jutalék ";
    }

    @Override
    public double getKoltseg(int nevErtek)
    {
        return alapKoltseg.getKoltseg(nevErtek) + nevErtek*alapJutalek;
    }
}
