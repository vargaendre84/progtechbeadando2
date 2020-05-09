package AllampapirStrategia;

import KoltsegDecorator.IKoltseg;
import KoltsegDecorator.Koltseg_Alap;
import KoltsegDecorator.Koltseg_BankSzamla;

public class KoltsegStrategia_Bank extends KoltsegStrategia
{
    private int nevErtek;
    private int futamIdo;

    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public KoltsegStrategia_Bank(int nevErtek, int futamIdo)
    {
        this.nevErtek = nevErtek;
        this.futamIdo = futamIdo;
    }

    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_BankSzamla(new Koltseg_Alap());
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek) * futamIdo;
        System.out.println("Költség: " + aktualisKoltseg);
    }
}
