import Observer.*;
import Strategy.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException
    {
        final Jegybank jegybank = Jegybank.getInstance();
        final Allamkincstar allamkincstar = Allamkincstar.getInstance();
        final Egyenleg myEgyenleg = Egyenleg.getInstance();

        int cimlet = 100000;
        int cimletekSzama = 1000000;
        int befektetes1 = 2300000;
        int befektetes2 = 1900000;
        int futamIdo = 3;
        double aktualisEURArfolyam = 360.0;
        double aktualisUSDArfolyam = 321.0;

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
      /*
        System.out.println("Adja meg milyen összeget akar befektetni: ");
        befektetes = Integer.parseInt(reader.readLine());
        System.out.println("Hány évre szeretné lekötni? (maximum 5év lehetséges) ");
        futamIdo = Integer.parseInt(reader.readLine());
        System.out.println("Melyik évben szeretné megvenni a papírt? ");
        kezdoEv = Integer.parseInt(reader.readLine());
    */
        Penzvalto penzvalto = new Penzvalto();
        Arfolyam_Euro euroValuta = new Arfolyam_Euro(penzvalto);
        Arfolyam_USD dollarValuta = new Arfolyam_USD(penzvalto);

        /*System.out.print("Adja meg az aktuális EUR vételi árfolyamot: ");
        aktualisEURArfolyam = Double.parseDouble(reader.readLine());
        System.out.print("Adja meg az aktuális USD vételi árfolyamot: ");
        aktualisUSDArfolyam = Double.parseDouble(reader.readLine());*/
        penzvalto.ArfolyamBeallitas(aktualisEURArfolyam,aktualisUSDArfolyam);

        System.out.println("Aktuális EUR és USD árfolyam frissítve: ");
        euroValuta.Display();
        dollarValuta.Display();

        AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Kamatozas_Normal(befektetes1,1,futamIdo,0.025,false),
                new KoltsegStrategia(befektetes1,1,futamIdo,false,true),
                "EMAP 2021-18");
        AllamPapir PMAP2025J = new Allampapir_PMAP(new Kamatozas_InflacioAlapu(befektetes2,5,futamIdo,0.014,false),
                new KoltsegStrategia(befektetes2,5,futamIdo,true,false),
                "PMAP 2025-J");

        AllampapirKibocsato akk = new AllampapirKibocsato();
        AllamPapir[] emapsorozat = akk.kibocsatas(EMAP2021_18,"EMAP 2021-18",cimletekSzama);
        AllamPapir[] pmapsorozat = akk.kibocsatas(PMAP2025J,"PMAP 2025-J",cimletekSzama);

        allamkincstar.AllamPapirKibocsatas_EMAP(cimletekSzama*cimlet);
        allamkincstar.AllamPapirKibocsatas_PMAP(cimletekSzama*cimlet);
        allamkincstar.AllamPapirErtekesítes_EMAP(befektetes1);
        allamkincstar.AllamPapirErtekesítes_PMAP(befektetes2);
        System.out.println("Kibocsátott PMÁP állomány:" + allamkincstar.getKibocsatottPMAPAllomany()/1000 + " ezer Ft");
        System.out.println("Kibocsátott EMÁP állomány:" + allamkincstar.getKibocsatottEMAPAllomany()/1000 + " ezer Ft");
        System.out.println("Kibocsátott MÁPPlusz állomány:" + allamkincstar.getKibocsatottMapPluszAllomany()/1000 + " ezer Ft");
        System.out.println("Értékesített PMÁP állomány:" + allamkincstar.getErtekesitettPMAPAllomany());
        System.out.println("Értékesített EMÁP állomány:" + allamkincstar.getErtekesitettEMAPAllomany());

        myEgyenleg.addNevertek(befektetes1+befektetes2);

        EMAP2021_18.getNev();
        EMAP2021_18.Kamatozas();
        EMAP2021_18.KoltsegSzamitas();

        PMAP2025J.getNev();
        PMAP2025J.Kamatozas();
        PMAP2025J.KoltsegSzamitas();

        System.out.println("A portfólió összes névértéke= " + myEgyenleg.getOsszesNevErtek());
        System.out.println("A portfólió összes kamata= " + myEgyenleg.getOsszesKamat());
        System.out.println("A portfólió összes költsége= " + myEgyenleg.getOsszesKoltseg());
        System.out.println("A portfólió egyenlege= " + myEgyenleg.getMerleg());

    }
}