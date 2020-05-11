package Portfolio;
import Intezmenyek.Allamkincstar;

public class Kereskedes   //lazy singleton
{
    Allamkincstar allamkincstar = Allamkincstar.getInstance();
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    private String nev = "Állampapír Kereskedés";
    private static volatile Kereskedes instance = null;

    private Kereskedes() {}
    public static Kereskedes getInstance()
    {
        if(instance == null) { instance = new Kereskedes(); }
        return instance;
    }

    private long vasaroltEMAPAllomany;
    private long vasaroltPMAPAllomany;
    private long vasaroltMAPPluszAllomany;
    public long getVasaroltEMAPAllomany(){return vasaroltEMAPAllomany;}
    public long getVasaroltPMAPAllomany(){return vasaroltPMAPAllomany;}
    public long getVasaroltMAPPluszAllomany(){return vasaroltMAPPluszAllomany;}

    long tranzakciosAllomany;
    public void VasarlasEMAP(long nevErtek)
    {
        tranzakciosAllomany = allamkincstar.getEladoEMAPAllomany();
        if(nevErtek > tranzakciosAllomany) { nevErtek = tranzakciosAllomany; }
        vasaroltEMAPAllomany += nevErtek;
        myEgyenleg.addNevertek(nevErtek);
        allamkincstar.AllamPapirErtekesítes_EMAP(nevErtek);
        System.out.println("Ennyi EMAP állampapírt tudott venni: " + nevErtek);
    }
    public void VasarlasPMAP(long nevErtek)
    {
        tranzakciosAllomany = allamkincstar.getEladoPMAPAllomany();
        if(nevErtek > tranzakciosAllomany) { nevErtek = tranzakciosAllomany; }
        vasaroltPMAPAllomany += nevErtek;
        myEgyenleg.addNevertek(nevErtek);
        allamkincstar.AllamPapirErtekesítes_PMAP(nevErtek);
        System.out.println("Ennyi PMAP állampapírt tudott venni: " + nevErtek);
    }
    public void VasarlasMAPPlusz(long nevErtek)
    {
        tranzakciosAllomany = allamkincstar.getEladoMAPPluszAllomany();
        if(nevErtek > tranzakciosAllomany) { nevErtek = tranzakciosAllomany; }
        vasaroltMAPPluszAllomany += nevErtek;
        myEgyenleg.addNevertek(nevErtek);
        allamkincstar.AllamPapirErtekesítes_MAPPlusz(nevErtek);
        System.out.println("Ennyi MAP Plusz állampapírt tudott venni: " + nevErtek);
    }

    public void EladasEMAP(long nevErtek)
    {
        if(nevErtek > vasaroltEMAPAllomany) { nevErtek = vasaroltEMAPAllomany; }
        myEgyenleg.addNevertek(-nevErtek);
        allamkincstar.AllamPapirErtekesítes_EMAP(-nevErtek);
        System.out.println("Ennyi EMAP állampapírt tudott eladni: " + nevErtek);
    }
    public void EladasPMAP(long nevErtek)
    {
        if(nevErtek > vasaroltPMAPAllomany) { nevErtek = vasaroltPMAPAllomany; }
        myEgyenleg.addNevertek(-nevErtek);
        allamkincstar.AllamPapirErtekesítes_PMAP(-nevErtek);
        System.out.println("Ennyi PMAP állampapírt tudott eladni: " + nevErtek);
    }
    public void EladasMAPPlusz(long nevErtek)
    {
        if(nevErtek > vasaroltMAPPluszAllomany) { nevErtek = vasaroltMAPPluszAllomany; }
        myEgyenleg.addNevertek(-nevErtek);
        allamkincstar.AllamPapirErtekesítes_MAPPlusz(-nevErtek);
        System.out.println("Ennyi MAP Plusz állampapírt tudott eladni: " + nevErtek);
    }
}
