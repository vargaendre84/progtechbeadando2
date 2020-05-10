import AllampapirStrategia.Kamatozas_Normal;
import AllampapirStrategia.KoltsegStrategia_Bank;
import Portfolio.Egyenleg;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankszamlaKamatozasEsKoltseg
{
    long befektetes1 = 3000000;
    int futamIdo = 3;
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    BankBetet otpBankBetet = new BankBetet(new Kamatozas_Normal(befektetes1,1,futamIdo,0.0001,false),
            new KoltsegStrategia_Bank(befektetes1,futamIdo),
            "OTP BankBetét 2020 Április");
    double expected = 3000000 * 0.0001 * 3 * 0.85;

    @Test
    public void BankSzamlaKamatTest() throws Exception
    {
        Assert.assertTrue(true);
        otpBankBetet.Kamatozas();
        assertEquals(expected, myEgyenleg.getOsszesKamat(),0.0);
    }

    double expected1 = 0;
    @Test
    public void BankSzamlaKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        otpBankBetet.KoltsegSzamitas();

        assertEquals(expected1, myEgyenleg.getOsszesKoltseg(),0.0);
    }
}
