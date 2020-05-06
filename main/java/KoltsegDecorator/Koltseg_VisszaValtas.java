package Decorator;

public class Koltseg_VisszaValtas extends KoltsegDecorator
{
    public Koltseg_VisszaValtas(IKoltseg alapKoltseg) {super(alapKoltseg);}
    private double visszaValtasiKoltseg = 0.02;

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " + visszaváltás járuléka ";
    }

    @Override
    public double getKoltseg(int nevErtek, int lejaratiIdo, int futamIdo, boolean befektetesiAlap, boolean ertekpapirSzamla)
    {
        if(lejaratiIdo > futamIdo)
            return alapKoltseg.getKoltseg(nevErtek,lejaratiIdo,futamIdo,befektetesiAlap, ertekpapirSzamla) + nevErtek*visszaValtasiKoltseg;
        else
            return alapKoltseg.getKoltseg(nevErtek,lejaratiIdo,futamIdo,befektetesiAlap, ertekpapirSzamla);
    }
}
