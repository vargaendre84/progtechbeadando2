package Decorator;

public class Koltseg_Alap implements IKoltseg
{
    @Override
    public String getKoltsegNem() { return "Pénzügyi eszköz költsége: "; }

    @Override
    public double getKoltseg(int nevErtek){ return 0; }
}
