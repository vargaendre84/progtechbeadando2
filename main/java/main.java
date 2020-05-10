import ArfolyamObserver.*;
import AllampapirStrategia.*;
import Portfolio.Egyenleg;
import ValutaStrategia.Valuta_EUR;
import ValutaStrategia.Valuta_HUF;
import ValutaStrategia.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException
    {
        final Jegybank jegybank = Jegybank.getInstance();
        final Allamkincstar allamkincstar = Allamkincstar.getInstance();
        final Egyenleg myEgyenleg = Egyenleg.getInstance();

        long befektetes1 = 10000000;
        long befektetes2 = 3000000;
        int futamIdo = 3;
        double aktualisEURArfolyam = 360.0;
        double aktualisUSDArfolyam = 321.0;
        int cimletErtek = Cimlet.getCimletErtek();
        int cimletekMaxSzama = Cimlet.getCimletekMaxSzama();

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
                new KoltsegStrategia_Allampapir(befektetes1,1,futamIdo,false,true),
                "EMAP 2021-18");
        AllamPapir PMAP2025J = new Allampapir_PMAP(new Kamatozas_InflacioAlapu(befektetes2,5,futamIdo,0.014,false),
                new KoltsegStrategia_Allampapir(befektetes2,5,futamIdo,true,false),
                "PMAP 2025-J");

        BankBetet otpBankBetet = new BankBetet(new Kamatozas_Normal(befektetes1,1,futamIdo,0.0001,false),
                new KoltsegStrategia_Bank(befektetes1,futamIdo),
                "OTP BankBetét 2020 Április");
        Valutak otthonitrezor = new Valuta_HUF(new KoltsegStrategia_KP(befektetes2), "Otthoni trezor");
        Valutak otthonitrezorEur = new Valuta_EUR(new ArfolyamStrategia_EUR(befektetes1/330,330.0,aktualisEURArfolyam),
                new KoltsegStrategia_KP(befektetes1),
                "Euró beszerzés 2020.02.20.");
        Valutak otthonitrezorUSD = new Valuta_USD(new ArfolyamStrategia_USD(befektetes2/335,335.0,aktualisUSDArfolyam),
                new KoltsegStrategia_KP(befektetes2),
                "USD beszerzés 2020.04.21.");

        AllampapirKibocsato akk = new AllampapirKibocsato();
        AllamPapir[] emapsorozat = akk.kibocsatas(EMAP2021_18,"EMAP 2021-18",cimletekMaxSzama);
        AllamPapir[] pmapsorozat = akk.kibocsatas(PMAP2025J,"PMAP 2025-J",cimletekMaxSzama);

        allamkincstar.AllamPapirKibocsatas_EMAP((long)cimletekMaxSzama*cimletErtek);
        allamkincstar.AllamPapirKibocsatas_PMAP((long)cimletekMaxSzama*cimletErtek);
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

        otpBankBetet.getNev();
        otpBankBetet.Kamatozas();
        otpBankBetet.KoltsegSzamitas();

        otthonitrezor.getNev();
        otthonitrezor.KoltsegSzamitas();
        otthonitrezorEur.getNev();
        otthonitrezorEur.ArfolyamNyereseg();
        otthonitrezorEur.KoltsegSzamitas();
        otthonitrezorUSD.getNev();
        otthonitrezorUSD.ArfolyamNyereseg();
        otthonitrezorUSD.KoltsegSzamitas();

        System.out.println("A portfólió összes névértéke= " + myEgyenleg.getOsszesNevErtek());
        System.out.println("A portfólió összes kamata= " + myEgyenleg.getOsszesKamat());
        System.out.println("A portfólió összes költsége= " + myEgyenleg.getOsszesKoltseg());
        System.out.println("A portfólió egyenlege= " + myEgyenleg.getMerleg());

    }
}