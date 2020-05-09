package KoltsegDecorator;

public class Koltseg_BankSzamla extends KoltsegDecorator
{
    public Koltseg_BankSzamla(IKoltseg alapKoltseg) {super(alapKoltseg);}
    private int bankSzamlaDij = 20000;  //OTP abn kszámla díj

    @Override
    public String getKoltsegNem()
    {
        return alapKoltseg.getKoltsegNem() + " + bankszámla éves díja ";
    }

    @Override
    public double getKoltseg(int nevErtek)
    {
        return alapKoltseg.getKoltseg(nevErtek) + bankSzamlaDij;
    }
}
