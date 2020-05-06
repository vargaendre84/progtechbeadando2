# progtechbeadando2
Progtech beadandó

Állampapírok, és egyéb pénzügyi eszközök nyilvántartása
hozamok számolása


Megvalósítás:
Java alkalmazás, parancssorral (esetleg egyszerű Swing felhasználói felülettel)


Működés:
Az alkalmazás állampapírokat tart nyilván, azok adataival, kamataival, futamidejével, visszaváltási költségével, vételi és eladási árfolyamaival. Az alkalmazás fő fókusza a Prémium Állampapír, a Magyar Állampapír Plusz, Kincstárjegy. 
A programba beírható lesz milyen összeget kívánunk állampapírba fektetni, és ez milyen hozamot tud elérni és milyen költségeket kell kifizetni. Ezt összehasonlítja, a készpénzben tartás, a bankbetét, illetve külföldi valutában tartás hozamait, és költségeit. 
Az alkalmazás figyelembe veszi az árfolyamváltozásokat, és az infláció okozta értékcsökkentést.
A program a megadott beállításoknak megfelelően megjeleníti a legjobb hozamot előrejelző befektetési formát.
Megéri-e megvenni, vagy eladni az adott állampapírt, összehasonlítva más pénzügyi eszközökkel.


Tervezési minták:

Stratégia:: Állampapírok csoportja: 
Az állampapírok különbözőképp kamatoznak, különböző az eladási, vételi árfolyamuk, 


Decorator: pénzügyi eszközök portfóliójánk a hozama, költsége : 
Több pénzügyi eszköz kiválsaztása esetén a hozamok és költségek kiszámítása


lazy singleton: mnb:  greedy singleton: államkincstár: 
Jegybank és Államkincstár is egy van a magyar pénzrendszerben. A jegybank általában késve avatkozik be az árfolyam romlása esetén. A jegybank viszont hamar tud változtatni az új állampapír sorozatok kiadásával.


prototype(vagy factory): új állampapír létrehozása:  
Új állampapír létrehozásánál kamatozási módok, költségek, és működési módokból új állampapír példány legyártása.


observer: árfolyamok, infláció frissítése: 
A valuta árfolyamok és infláció értéke folyamatosan frissül a állampapír futamideje alatt. Ezeket kérik le az egyes hozam és költség számoló metódusok.



Design principles:
OCP:
A meglévő tesztelt metódusokat nem változtatom meg, írok új metódust a bővítéshez.
Csak abstract vagy virtual metódusokat override-olok.


GOF1:
A legősibb lehetséges osztályt kell alkalmazni deklarációkor
pl:
PMAP PMAP2025_2 = new PMAP(); helyett
Allampapir PMAP2025_2 = new PMAP();
A metódusokat úgy kell hívni, hogy a művelet eredménye ne függjön a hívandó osztály megvalósításától, azaz na adjon más eredményt ha változik a hívandó osztály implementációja.


GOF2:
Öröklések helyett objektumösszetételt használok. Pl Az egyes állampapírokat nem örököltetem az állampapírokból, hanem a különböző osztályokban definiált obkjektumok összetételével oldom meg.


SRP:
minden osztálynak egy felelősséget adok, tehát külön osztályokba teszem az egymástól független metódusokat.


LSP: 
A Allampapir helyére a leszármazott PMAP osztályt is behelyettesíthetjük. A leszármazott osztályokban nem viselkedhetnek másképp a metódusok.




Unit tests:
1) 
A különböző állampapírok hozamainak és költségeinek ellenőrzése manuális számításos unit teszttel

2) 
Vételi és eladási árfolyamok tesztelése manuális számításos unit teszttel

3)
inflációs értékcsökkenések ellenőrzése manuális számításos unit teszttel

