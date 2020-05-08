public class Allamkincstar  //greedy
{
   private String nev = "Magyar Államkincstár";
   private static int cimlet = 100000;
   private long allamAdossag = 310400000 * cimlet;
   private double allamAdossagGDPArany =  0.664;    //forrás: magyarnemzet.hu/gazdasag/apadoban-az-allamadossag-7787951/  2020.02.18.
   private long kibocsatottPMAPAllomany;
   private long kibocsatottEMAPAllomany;
   private long kibocsatottMapPluszAllomany;
   private long ertekesitettPmapAllomany;
   private long ertekesitettEmapAllomany;
   private long ertekesitettMapPluszAllomany;

   private static final Allamkincstar instance = new Allamkincstar();
   private Allamkincstar() {}

   public static Allamkincstar getInstance()
        {
            return instance;
        }

   public void AllamPapirKibocsatas_PMAP(long osszeg) { kibocsatottPMAPAllomany += osszeg;}
   public void AllamPapirKibocsatas_EMAP(long osszeg) { kibocsatottEMAPAllomany += osszeg; }
   public void AllamPapirKibocsatas_MAPPlusz(long osszeg) { kibocsatottMapPluszAllomany += osszeg; }
   public void AllamPapirErtekesítes_PMAP(long osszeg) { ertekesitettPmapAllomany += osszeg; }
   public void AllamPapirErtekesítes_EMAP(long osszeg) { ertekesitettEmapAllomany += osszeg; }
   public void AllamPapirErtekesítes_MAPPlusz(long osszeg) { ertekesitettMapPluszAllomany += osszeg; }
   public void AllamPapirVisszaVasarlas_PMAP(long osszeg) { ertekesitettPmapAllomany -= osszeg; }
   public void AllamPapirVisszaVasarlas_EMAP(long osszeg) { ertekesitettEmapAllomany -= osszeg; }
   public void AllamPapirVisszaVasarlas_MAPPlusz(long osszeg) { ertekesitettMapPluszAllomany -= osszeg; }

   public long getKibocsatottPMAPAllomany(){return kibocsatottPMAPAllomany;}
   public long getKibocsatottEMAPAllomany(){return kibocsatottEMAPAllomany;}
   public long getKibocsatottMapPluszAllomany(){return kibocsatottMapPluszAllomany;}
   public long getErtekesitettPMAPAllomany(){return ertekesitettPmapAllomany;}
   public long getErtekesitettEMAPAllomany(){return ertekesitettEmapAllomany;}
   public long getErtekesitettMAPPluszAllomany(){return ertekesitettMapPluszAllomany;}
}

