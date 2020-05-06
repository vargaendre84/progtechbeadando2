import Strategy.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NevErtekTest
{
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    int befektetes = 1000000;
    int futamIdo = 3;
    int kezdoEv = 2020;

    AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Kamatozas_Normal(befektetes,1,futamIdo,0.025,false),
            new KoltsegStrategia(befektetes,1,futamIdo,false,false),
            "Egy éves magyar Állampapír 2021-18");


    @Test
    public void EMAPNevertekTest() throws Exception
    {
        Assert.assertTrue(true);
        double expected = befektetes;
        EMAP2021_18.Kamatozas();
        assertEquals(expected, myEgyenleg.getOsszesNevErtek(),0.0);
    }
}
