import ArfolyamObserver.Arfolyam_Euro;
import ArfolyamObserver.Arfolyam_USD;
import ArfolyamObserver.Penzvalto;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class ArfolyamTest
{
    Penzvalto penzvalto = new Penzvalto();
    Arfolyam_Euro euroValuta = new Arfolyam_Euro(penzvalto);
    Arfolyam_USD dollarValuta = new Arfolyam_USD(penzvalto);
    double tesztEURArfolyam = 360.0;
    double tesztUSDArfolyam = 321.0;

    @Test
    public void getEURArfolyam() throws Exception
    {
        penzvalto.ArfolyamBeallitas(tesztEURArfolyam,tesztUSDArfolyam);
        Assert.assertTrue(true);
        double expected = tesztEURArfolyam;
        assertEquals(expected,euroValuta.getArfolyam(),0.01);
    }

    @Test
    public void getUSDArfolyam() throws Exception
    {
        penzvalto.ArfolyamBeallitas(tesztEURArfolyam,tesztUSDArfolyam);
        Assert.assertTrue(true);
        double expected = tesztUSDArfolyam;
        assertEquals(expected, dollarValuta.getArfolyam(),0.01);;
    }
}
