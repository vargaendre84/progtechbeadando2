import AllampapirStrategia.AllamPapir;

public class AllampapirKibocsato
{
    private static int cimletekMaxSzama = Cimlet.getCimletekMaxSzama();

    public AllamPapir[] kibocsatas(AllamPapir allampapir, String nev, int cimletekSzama)
    {
        if (cimletekSzama > cimletekMaxSzama)  cimletekSzama = cimletekMaxSzama;
        AllamPapir[] temp = new AllamPapir[cimletekSzama];
        for (int i = 0; i < cimletekSzama; i++)
        {
            temp[i] = (AllamPapir)allampapir.Clone();
            temp[i].setNev(nev);
        }
        int mennyiseg = temp.length;
        System.out.println(mennyiseg + " címletnyi " + nev + " állampapír lett kibocsájtva: " + mennyiseg /10 + " millió Ft értékben");
        return temp;
    }
}
