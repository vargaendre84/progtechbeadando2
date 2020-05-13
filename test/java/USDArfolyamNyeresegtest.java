import KoltsegStrategia.KoltsegStrategia_KP;
import Portfolio.Egyenleg;
import ValutaStrategia.ArfolyamStrategia_USD;
import ValutaStrategia.Beszerzes_KP;
import ValutaStrategia.Valuta_USD;
import ValutaStrategia.Valutak;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class USDArfolyamNyeresegtest
{
    long befektetes2 = 3000000;
    double aktualisUSDArfolyam = 321.0;
    final Egyenleg myEgyenleg = Egyenleg.getInstance();

    Valutak otthonitrezorUSD = new Valuta_USD(new Beszerzes_KP(befektetes2/335),
            new ArfolyamStrategia_USD(befektetes2/335,335.0,aktualisUSDArfolyam),
            new KoltsegStrategia_KP(befektetes2),
            "USD beszerzés 2020.04.21.");
    double expected2 = (3000000/335) * (321-335);

    @Test
    public void USDArfolyamNyeresegTest() throws Exception
    {
        Assert.assertTrue(true);
        otthonitrezorUSD.ArfolyamNyereseg();
        assertEquals(expected2, myEgyenleg.getUtolsoArfolyamNyereseg(),0.0);
    }
}
