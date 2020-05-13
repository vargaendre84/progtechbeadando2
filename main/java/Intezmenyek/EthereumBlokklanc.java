package Intezmenyek;

public class EthereumBlokklanc
{
    private String nev = "Ethereum Blokklánc";
    private long forgalombanLevoMennyiseg = 101135552;  //Kriptopénz ABC könyv 229.oldal

    private static volatile EthereumBlokklanc instance = null;

    private EthereumBlokklanc() {}

    public static EthereumBlokklanc getInstance()
    {
        if(instance == null)
        {
            instance = new EthereumBlokklanc();
        }
        return instance;
    }

    public void ujBanyaszottMennyisegHozzaadasa(long ertek) {forgalombanLevoMennyiseg+=ertek;}

}
