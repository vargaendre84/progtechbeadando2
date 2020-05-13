package ValutaStrategia;
import Intezmenyek.EthereumBlokklanc;
import Portfolio.Egyenleg;

public class Beszerzes_BanyaszatiJovairas extends BeszerzesiStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    EthereumBlokklanc blokklanc = EthereumBlokklanc.getInstance();
    private long nevErtek;
    public Beszerzes_BanyaszatiJovairas(long nevErtek) { this.nevErtek = nevErtek; }

    @Override
    public void Beszerzes()
    {
        myEgyenleg.addNevertek(nevErtek);
        blokklanc.ujBanyaszottMennyisegHozzaadasa(nevErtek);
        System.out.println("Bányászott Ether Állomány= " + nevErtek);
    }

}
