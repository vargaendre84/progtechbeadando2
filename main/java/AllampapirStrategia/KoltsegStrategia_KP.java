package AllampapirStrategia;
import KoltsegDecorator.*;
import Portfolio.Egyenleg;

public class KoltsegStrategia_KP extends KoltsegStrategia
{
    private long nevErtek;
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public KoltsegStrategia_KP(long nevErtek) { this.nevErtek = nevErtek; }

    @Override
    public void KoltsegSzamitas()
    {
        if(!myEgyenleg.getOtthoniTrezorKialakitva())
        {
            IKoltseg koltseg = new Koltseg_Biztositas(new Koltseg_Riaszto(new Koltseg_Szef(new Koltseg_Alap())));
            System.out.println(koltseg.getKoltsegNem());
            double aktualisKoltseg = koltseg.getKoltseg(nevErtek);
            myEgyenleg.addKoltseg(aktualisKoltseg);
            myEgyenleg.setOtthoniTrezorKialakitva(true);
            System.out.println("Költség: " + aktualisKoltseg);
        }
        else
            System.out.println("Otthoni trezor rendszer már ki van alakítva, nem szükséges újra kifizetni az árát");
    }
}
