package AllampapirStrategia;
import KoltsegDecorator.*;

public class KoltsegStrategia_KP extends KoltsegStrategia
{
    private int nevErtek;
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public KoltsegStrategia_KP(int nevErtek) { this.nevErtek = nevErtek; }

    @Override
    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_Biztositas(new Koltseg_Riaszto(new Koltseg_Szef(new Koltseg_Alap())));
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek);
        System.out.println("Költség: " + aktualisKoltseg);
    }
}
