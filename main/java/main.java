import Observer.*;
import Decorator.*;
import Strategy.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {

    public static void main(String[] args) throws IOException
    {
        final Jegybank jegybank = Jegybank.getInstance();
        jegybank.nev = "Magyar Nemzeti Bank";
        jegybank.alapkamat = 0.009;  //2020.03.25.  mnb.hu
        jegybank.keszpenzallomany = 6620; //milliárd ft,  2020.01.20. mnb.hu
        final Allamkincstar allamkincstar = Allamkincstar.getInstance();
        allamkincstar.allamkincstar = "Magyar Államkincstár";

        final Egyenleg myEgyenleg = Egyenleg.getInstance();

        int befektetes = 1000000;
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

     /*   System.out.print("Adja meg az aktuális EUR vételi árfolyamot: ");
        aktualisEURArfolyam = Double.parseDouble(reader.readLine());
        System.out.print("Adja meg az aktuális USD vételi árfolyamot: ");
        aktualisUSDArfolyam = Double.parseDouble(reader.readLine());
        penzvalto.ArfolyamBeallitas(aktualisEURArfolyam,aktualisUSDArfolyam);
    */
        System.out.println("Aktuális EUR és USD árfolyam frissítve: ");
        euroValuta.Display();
        dollarValuta.Display();

        AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Kamatozas_Normal(befektetes,1,futamIdo,0.025,false),
                new KoltsegStrategia(befektetes,1,futamIdo,false,true),
                "Egy éves magyar Állampapír 2021-18");

        AllamPapir PMAP2025J = new Allampapir_PMAP(new Kamatozas_InflacioAlapu(befektetes,5,futamIdo,0.014,false),
                new KoltsegStrategia(befektetes,5,futamIdo,true,false),
                "Prémium Magyar Állampapír 2025-J");

        myEgyenleg.addNevertek(befektetes);

        EMAP2021_18.getNev();
        EMAP2021_18.Kamatozas();
        EMAP2021_18.KoltsegSzamitas();

        PMAP2025J.getNev();
        PMAP2025J.Kamatozas();
        PMAP2025J.KoltsegSzamitas();

        System.out.println("A portfólió összes névértéke= " + myEgyenleg.getOsszesNevErtek());
        System.out.println("A portfólió összes kamata= " + myEgyenleg.getOsszesKamat());
        System.out.println("A portfólió összes költsége= " + myEgyenleg.getOsszesKoltseg());
        System.out.println("A portfólió mérlege= " + myEgyenleg.getMerleg());

        /*System.out.print("Állampapír neve: ");
        EMAPtemp.getNev();
        System.out.print("Állampapír kamatozása: ");
        EMAPtemp.Kamatozas();*/
    }
}
