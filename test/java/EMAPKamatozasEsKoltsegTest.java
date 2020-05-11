import AllampapirStrategia.*;
import Portfolio.Egyenleg;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class EMAPKamatozasEsKoltsegTest
{
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    int befektetes = 1000000;
    int futamIdo = 3;

    AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Vasarlas_EMAP(befektetes), new Kamatozas_Normal(befektetes,futamIdo,0.025,false),
            new KoltsegStrategia_Allampapir_EPSZ(befektetes,1,futamIdo),
            "Egy éves magyar Állampapír 2021-18");
    double expected1 = 1000000 * 0.025 * (1-0.15) * 3;

    @Test
    public void EMAPKamatTest() throws Exception
    {
        Assert.assertTrue(true);
        EMAP2021_18.Kamatozas();
        assertEquals(expected1, myEgyenleg.getOsszesKamat(),0.0);
    }

    double expected3 = 1000000 * 0.0022 *3 ;
    @Test
    public void EMAPKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        EMAP2021_18.KoltsegSzamitas();
        assertEquals(expected3, myEgyenleg.getOsszesKoltseg() ,0.0);
    }

    @Test
    public void ZgetMerlegTest() throws Exception
    {
        Assert.assertTrue(true);
        assertEquals(expected1 - expected3, myEgyenleg.getMerleg(),0.0);
    }
}
