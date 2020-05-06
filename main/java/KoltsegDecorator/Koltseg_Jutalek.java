package Decorator;

public class Koltseg_Jutalek extends KoltsegDecorator
{
    private static double alapJutalek = 0.01;
    public Koltseg_Jutalek(IKoltseg alapKoltseg) {super(alapKoltseg);}

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " +jutalék ";
    }

    @Override
    public double getKoltseg(int nevErtek, int lejaratiIdo, int futamIdo, boolean befektetesiAlap, boolean ertekpapirSzamla)
    {
        if(befektetesiAlap)
            return alapKoltseg.getKoltseg(nevErtek,lejaratiIdo,futamIdo, befektetesiAlap, ertekpapirSzamla) + nevErtek*alapJutalek;
        else
            return alapKoltseg.getKoltseg(nevErtek,lejaratiIdo,futamIdo, befektetesiAlap, ertekpapirSzamla);
    }
}
