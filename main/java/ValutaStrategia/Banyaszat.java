package ValutaStrategia;
import ArfolyamObserver.Arfolyam_Kripto_Ethereum;

public class Banyaszat
{
    private double maximumValutaMennyiseg = 1000000000;

    public KriptoValuta[] kibocsatas(KriptoValuta ethereum, String nev, int cimletekSzama)
    {
        KriptoValuta[] temp = new KriptoValuta[cimletekSzama];
        for (int i = 0; i < cimletekSzama; i++)
        {
            temp[i] = (KriptoValuta)ethereum.Clone();
            temp[i].setNev(nev);
        }
        System.out.println(temp.length + " egységnyi " + nev + " lett kibányászva: ");
        return temp;
    }
}
