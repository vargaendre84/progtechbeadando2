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

        final Portfolio myPortfolio = Portfolio.getInstance();

        int befektetes = 1000000;
        int futamIdo = 3;
        int kezdoEv = 2020;

     /* BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Adja meg milyen összeget akar befektetni: ");
        befektetes = Integer.parseInt(reader.readLine());
        System.out.println("Hány évre szeretné lekötni? (maximum 5év lehetséges) ");
        futamIdo = Integer.parseInt(reader.readLine());
        System.out.println("Melyik évben szeretné megvenni a papírt? ");
        kezdoEv = Integer.parseInt(reader.readLine());
    */
        AllamKotveny EMAP2021_18 = new Allampapir_EMAP(new Kamatozas_Normal(befektetes,futamIdo,0.025,false),"Egy éves magyar Állampapír 2021-18");
        AllamKotveny PMAP2025J = new Allampapir_PMAP(new Kamatozas_InflacioAlapu(befektetes,kezdoEv,futamIdo,0.014,false),"Prémium Magyar Állampapír 2025-J");
        AllamKotveny EMAPtemp = new Allampapir_EMAP(new Kamatozas_Normal(),"Template Állampapír");


        System.out.print("Állampapír neve: ");
        EMAP2021_18.getNev();
        System.out.print("Állampapír kamatozása: ");
        EMAP2021_18.Kamatozas();

        System.out.print("Állampapír neve: ");
        PMAP2025J.getNev();
        System.out.print("Állampapír kamatozása: ");
        PMAP2025J.Kamatozas();

        System.out.println("A portfólió összes névértéke= " + myPortfolio.getOsszesNevErtek());
        System.out.println("A portfólió összes kamata= " + myPortfolio.getOsszesKamat());
        System.out.println("A portfólió összes költsége= " + myPortfolio.getOsszesKoltseg());

        /*System.out.print("Állampapír neve: ");
        EMAPtemp.getNev();
        System.out.print("Állampapír kamatozása: ");
        EMAPtemp.Kamatozas();*/
    }

}
