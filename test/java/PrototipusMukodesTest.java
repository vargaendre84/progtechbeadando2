import AllampapirStrategia.*;
import Intezmenyek.Allamkincstar;
import Intezmenyek.AllampapirKibocsato;
import Portfolio.Egyenleg;
import Portfolio.Kereskedes;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PrototipusMukodesTest
{
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    Kereskedes kereskedes = Kereskedes.getInstance();
    Allamkincstar allamkincstar = Allamkincstar.getInstance();
    long befektetes = 1000000;
    int futamIdo = 3;

    AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Kamatozas_Normal(befektetes,1,futamIdo,0.025,false),
            new KoltsegStrategia_Allampapir_Alap(befektetes,1,futamIdo),
            "Egy éves magyar Állampapír 2021-18");

    AllampapirKibocsato akk = new AllampapirKibocsato();
    AllamPapir[] emapSorozat = akk.kibocsatas(EMAP2021_18,"EMAP 2021-18",1000000);;
    @Test
    public void EMAPKibocsatottErtekTest() throws Exception
    {
        Assert.assertTrue(true);
        long expected = 1000000;
        allamkincstar.AllamPapirKibocsatas_EMAP((long)(emapSorozat.length * 100000));
        assertEquals(expected, allamkincstar.getKibocsatottEmapAllomany(),0.0);
    }

    @Test
    public void EMAPVasaroltErtekTest() throws Exception
    {
        Assert.assertTrue(true);
        long expected = 3000000;
        kereskedes.VasarlasEMAP(3000000);
        assertEquals(expected,allamkincstar.getErtekesitettEMAPAllomany(),0.0);
    }

    @Test
    public void ZEgyenlegNevertekTest() throws Exception
    {
        Assert.assertTrue(true);
        long expected = 3000000;
        allamkincstar.AllamPapirKibocsatas_EMAP((long)(emapSorozat.length * 1000000));
        assertEquals(expected,myEgyenleg.getOsszesNevErtek(),0.0);
    }
}
