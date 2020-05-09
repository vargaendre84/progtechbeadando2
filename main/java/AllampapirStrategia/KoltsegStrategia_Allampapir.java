package AllampapirStrategia;
import KoltsegDecorator.*;

public class KoltsegStrategia_Allampapir extends KoltsegStrategia
{
    private int nevErtek;
    private int lejaratiIdo;
    private int futamIdo;
    private boolean befektetesiAlap;
    private boolean ertekpapirSzamla;

    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public KoltsegStrategia_Allampapir(int nevErtek, int lejaratiIdo, int futamIdo, boolean befektetesiAlap, boolean ertekpapirSzamla)
    {
        this.nevErtek = nevErtek;
        this.lejaratiIdo = lejaratiIdo;
        this.futamIdo = futamIdo;
        this.befektetesiAlap = befektetesiAlap;
        this.ertekpapirSzamla = ertekpapirSzamla;
    }

    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_Alap();
        if((lejaratiIdo > futamIdo) && befektetesiAlap && ertekpapirSzamla)
            koltseg = new Koltseg_VisszaValtas(new Koltseg_Jutalek(new Koltseg_ErtekPapirSzamla(new Koltseg_Alap())));
        if((lejaratiIdo > futamIdo) && !befektetesiAlap && ertekpapirSzamla)
            koltseg = new Koltseg_VisszaValtas(new Koltseg_ErtekPapirSzamla(new Koltseg_Alap()));
        if((lejaratiIdo > futamIdo) && befektetesiAlap && !ertekpapirSzamla)
            koltseg = new Koltseg_VisszaValtas(new Koltseg_Jutalek(new Koltseg_Alap()));
        if((lejaratiIdo > futamIdo) && !befektetesiAlap && !ertekpapirSzamla)
            koltseg = new Koltseg_VisszaValtas(new Koltseg_Alap());
        if(!(lejaratiIdo > futamIdo) && befektetesiAlap && ertekpapirSzamla)
            koltseg = new Koltseg_Jutalek(new Koltseg_ErtekPapirSzamla(new Koltseg_Alap()));
        if(!(lejaratiIdo > futamIdo) && !(befektetesiAlap) && ertekpapirSzamla)
            koltseg = new Koltseg_ErtekPapirSzamla(new Koltseg_Alap());
        if(!(lejaratiIdo > futamIdo) && !(befektetesiAlap) && !(ertekpapirSzamla))
            koltseg = new Koltseg_Alap();
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek);
        System.out.println("Költség: " + aktualisKoltseg);
        myEgyenleg.addKoltseg(aktualisKoltseg);
    }
}
