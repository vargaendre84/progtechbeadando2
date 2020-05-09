import AllampapirStrategia.*;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class KamatozasEsKoltsegTest
{
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    int befektetes = 1000000;
    int futamIdo = 3;
    int kezdoEv = 2020;

    AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Kamatozas_Normal(befektetes,1,futamIdo,0.025,false),
            new KoltsegStrategia_Allampapir(befektetes,1,futamIdo,true,true),
            "Egy éves magyar Állampapír 2021-18");

    AllamPapir PMAP2025J = new Allampapir_PMAP(new Kamatozas_InflacioAlapu(befektetes,5,futamIdo,0.014,false),
            new KoltsegStrategia_Allampapir(befektetes,5,futamIdo,true,false),
            "Prémium Magyar Állampapír 2025-J");;

    double expected1 = 1000000 * 0.025 * (1-0.15) * 3;
    double expected2 =  1000000 * (0.014 + 0.039) * (1 - 0.15) +
                        1000000 * (0.014 + 0.055) * (1 - 0.15) +
                        1000000 * (0.014 + 0.048) * (1 - 0.15);

    @Test
    public void EMAPKamatTest() throws Exception
    {
        Assert.assertTrue(true);
        EMAP2021_18.Kamatozas();
        assertEquals(expected1, myEgyenleg.getOsszesKamat(),0.0);
    }
    @Test
    public void PMAPKamatTest() throws Exception
    {
        Assert.assertTrue(true);
        PMAP2025J.Kamatozas();
        assertEquals(expected2 + expected1, myEgyenleg.getOsszesKamat(),0.0);
    }

    double expected3 = 1000000 * 0.01 + 1000000 * 0.0022;
    double expected4 = 1000000 * 0.01 + 1000000 * 0.02;

   @Test
    public void PMAPKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        PMAP2025J.KoltsegSzamitas();
        assertEquals(expected4, myEgyenleg.getOsszesKoltseg(),0.0);
    }
    @Test
    public void EMAPKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        EMAP2021_18.KoltsegSzamitas();
        assertEquals(expected3+expected4, myEgyenleg.getOsszesKoltseg() ,0.0);
    }

    @Test
    public void ZgetMerlegTest() throws Exception
    {
        Assert.assertTrue(true);
        assertEquals(expected1 + expected2 - expected3 - expected4, myEgyenleg.getMerleg(),0.0);
    }

}
