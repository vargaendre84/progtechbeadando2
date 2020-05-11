import ArfolyamObserver.*;
import AllampapirStrategia.*;
import Intezmenyek.Allamkincstar;
import Intezmenyek.Jegybank;
import Portfolio.Egyenleg;
import Portfolio.Kereskedes;
import ValutaStrategia.Valuta_EUR;
import ValutaStrategia.Valuta_HUF;
import ValutaStrategia.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException
    {
        Jegybank jegybank = Jegybank.getInstance();
        Allamkincstar allamkincstar = Allamkincstar.getInstance();
        Egyenleg myEgyenleg = Egyenleg.getInstance();
        Kereskedes kereskedes = Kereskedes.getInstance();

        long befektetes1 = 10000000;
        long befektetes2 = 30000000;
        int futamIdo = 3;
        int lejaratiIdo1 = 1;
        int lejaratiIdo5 = 5;
        double alapkamat25 = 0.025;
        double alapkamat35 = 0.035;
        double kamatpremium = 0.014;
        double bankikamat = 0.0001;
        double kamatvaltozas = 0.005;
        double veteliEURArfolyam = 335.0;
        double veteliUSDArfolyam = 328;
        double veteliETHArfolyam = 65570;
        double aktualisEURArfolyam = 360.0;
        double aktualisUSDArfolyam = 321.0;
        double aktualisETHArfolyam = 67539.85;
        int banyaszandoKriptoValuta = 1000;
        int cimletErtek = allamkincstar.getCimletErtek();
        int cimletekMaxSzama = allamkincstar.getCimletekMaxSzama();

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
        System.out.println("");
        Penzvalto penzvalto = new Penzvalto();
        Arfolyam_Euro euroValuta = new Arfolyam_Euro(penzvalto);
        Arfolyam_USD dollarValuta = new Arfolyam_USD(penzvalto);
        Arfolyam_Kripto_Ethereum ethValuta = new Arfolyam_Kripto_Ethereum(penzvalto);

        /*System.out.print("Adja meg az aktuális EUR vételi árfolyamot: ");
        aktualisEURArfolyam = Double.parseDouble(reader.readLine());
        System.out.print("Adja meg az aktuális USD vételi árfolyamot: ");
        aktualisUSDArfolyam = Double.parseDouble(reader.readLine());*/
        penzvalto.ArfolyamBeallitas(aktualisEURArfolyam,aktualisUSDArfolyam,aktualisETHArfolyam);

        System.out.println("Aktuális EUR, USD és ETH árfolyam frissítve: ");
        euroValuta.Display();
        dollarValuta.Display();
        ethValuta.Display();

        allamkincstar.AllamPapirKibocsatas_PMAP(cimletErtek * cimletekMaxSzama);
        allamkincstar.AllamPapirKibocsatas_EMAP(cimletErtek * cimletekMaxSzama);
        allamkincstar.AllamPapirKibocsatas_MAPPlusz(cimletErtek * cimletekMaxSzama / 2);

        System.out.println("");
        AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Vasarlas_EMAP(befektetes1), new Kamatozas_Normal(befektetes1,futamIdo,alapkamat25,false),
                new KoltsegStrategia_Allampapir_JutalekEPSZ(befektetes1,lejaratiIdo1,futamIdo),
                "EMAP 2021-18");
        AllamPapir PMAP2025J = new Allampapir_PMAP(new Vasarlas_PMAP(befektetes2), new Kamatozas_InflacioAlapu(befektetes2,lejaratiIdo5,futamIdo,kamatpremium,false),
                new KoltsegStrategia_Allampapir_Jutalek(befektetes2,lejaratiIdo5,futamIdo),
                "PMAP 2025-J");
        AllamPapir MAPPluszN2025_19 = new Allampapir_MAPPlusz(new Vasarlas_MAPPlusz(befektetes2), new Kamatozas_Savos_Periodusos_Egyenletes(befektetes2,lejaratiIdo5,futamIdo,alapkamat35,lejaratiIdo1,kamatvaltozas),
                new KoltsegStrategia_Allampapir_Jutalek(befektetes2,lejaratiIdo5,futamIdo),
                "MAP Plusz N2025/19");

        BankBetet otpBankBetet = new BankBetet(new Kamatozas_Normal(befektetes1,futamIdo,bankikamat,false),
                new KoltsegStrategia_Bank(befektetes1,futamIdo),
                "OTP BankBetét 2020 Április");
        Valutak otthonitrezor = new Valuta_HUF(new KoltsegStrategia_KP(befektetes1), "Otthoni trezor");
        Valutak otthonitrezorEur = new Valuta_EUR(new ArfolyamStrategia_EUR(befektetes2/(long)veteliEURArfolyam,veteliEURArfolyam,aktualisEURArfolyam),
                new KoltsegStrategia_KP(befektetes2),
                "Euró beszerzés 2020.02.20.");
        Valutak otthonitrezorUSD = new Valuta_USD(new ArfolyamStrategia_USD(befektetes2/(long)veteliUSDArfolyam,veteliUSDArfolyam,aktualisUSDArfolyam),
                new KoltsegStrategia_KP(befektetes2),
                "USD beszerzés 2020.04.21.");

        KriptoValuta ethereum2020 = new Kripto_Ethereum(new ArfolyamStrategia_Kripto_Ethereum(befektetes1/(long)veteliETHArfolyam,veteliETHArfolyam,aktualisETHArfolyam),
                new KoltsegStrategia_Allampapir_EPSZ(befektetes1,lejaratiIdo1,futamIdo),"Ethereum befektetés 2020");
        Banyaszat banyagep1 = new Banyaszat();
        KriptoValuta[] ethSorozat = banyagep1.kibocsatas(ethereum2020,"Ethereum kriptovaluta",banyaszandoKriptoValuta);
        System.out.println(ethSorozat.length + " egységnyi Ether létrehozva");

        System.out.println("");
        EMAP2021_18.getNev();
        EMAP2021_18.Vasarlas();
        EMAP2021_18.Kamatozas();
        EMAP2021_18.KoltsegSzamitas();
        PMAP2025J.getNev();
        PMAP2025J.Vasarlas();
        PMAP2025J.Kamatozas();
        PMAP2025J.KoltsegSzamitas();
        MAPPluszN2025_19.getNev();
        MAPPluszN2025_19.Vasarlas();
        MAPPluszN2025_19.Kamatozas();
        MAPPluszN2025_19.KoltsegSzamitas();

        System.out.println("");
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

        System.out.println("");
        ethereum2020.getNev();
        ethereum2020.ArfolyamNyereseg();
        ethereum2020.KoltsegSzamitas();

        System.out.println("");
        System.out.println("A portfólió összes névértéke= " + myEgyenleg.getOsszesNevErtek());
        System.out.println("A portfólió összes kamata= " + myEgyenleg.getOsszesKamat());
        System.out.println("A portfólió összes költsége= " + myEgyenleg.getOsszesKoltseg());
        System.out.println("A portfólió egyenlege= " + myEgyenleg.getMerleg());
    }
}