import Strategy.AllamPapir;

public class AllampapirKibocsato
{
    private static int cimlet = 100000;  //
    private static int allamPapironkentiLimit = 1000000;

    public AllamPapir[] kibocsatas(AllamPapir allampapir, String nev, int cimletekSzama)
    {
        if (cimletekSzama > allamPapironkentiLimit)  cimletekSzama = allamPapironkentiLimit;
        AllamPapir[] temp = new AllamPapir[cimletekSzama];
        for (int i = 0; i < cimletekSzama; i++)
        {
            temp[i] = (AllamPapir)allampapir.Clone();
            temp[i].setNev(nev);
        }
        System.out.println(cimletekSzama + " címletnyi állampapír lett kibocsájtva: " + cimletekSzama /10 + " millió Ft értékben");
        return temp;
    }
}
