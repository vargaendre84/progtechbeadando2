# Beadandó feladat Programozási technológiák gy tárgyból
Állampapírok, és egyéb pénzügyi eszközök nyilvántartása
hozamok számolása

! 
Az AllampapirStrategia package egy régebbi struktúra része. 
A program jobb átláthatósága érdekében az AllampapirStrategia
package fajljai szét lettek szortírozva a KamatozasiVasarlasi es Koltsegstategia
valamint PenzugyiEszkozok package-ekbe.
!

Megvalósítás:
Java alkalmazás, parancssorral 


Működés:
Az alkalmazás állampapírokat tart nyilván, azok adataival, kamataival, futamidejével, visszaváltási költségével, vételi és eladási árfolyamaival. 
Az alkalmazás fő fókusza a Prémium Állampapír, a Magyar Állampapír Plusz, Kincstárjegy. 
A programba beírható lesz milyen összeget kívánunk állampapírba fektetni, és ez milyen hozamot tud elérni és milyen költségeket kell kifizetni. Ezt összehasonlítja, a készpénzben tartás, a bankbetét, illetve külföldi valutában tartás hozamait, és költségeit. 
Az alkalmazás figyelembe veszi az árfolyamváltozásokat, és az infláció okozta értékcsökkentést.
A program a megadott beállításoknak megfelelően megjeleníti a legjobb hozamot előrejelző befektetési formát.
Megéri-e megvenni, vagy eladni az adott állampapírt, összehasonlítva más pénzügyi eszközökkel.



Tervezési minták:

Stratégia: 
- Állampapírok csoportja: 
Az állampapírok különbözőképp kamatoznak, különböző az eladási, vételi árfolyamuk, és költségük
Kamatozási Stratégia
Költség Stratégia

- Bankszámlák 
Kamatozási Stratégia

- valuták: 
Költség Stratégia
ÁrfolyamStratégia



Decorator: 
- állampapírok költsége: visszaváltás, jutalék, számlavezetés, stb
- valuták tárolási és biztosítási költsége


lazy singleton: mnb:  
greedy singleton: államkincstár: 
Jegybank és Államkincstár is egy van a magyar pénzrendszerben. A jegybank általában késve avatkozik be az árfolyam romlása esetén. A jegybank viszont hamar tud változtatni az új állampapír sorozatok kiadásával.


greedy singleton: egyenleg
összegzi az összes megvett állampapír névértékét és realizált kamatát, és költségét


(greedy singleton: értékbevitel gui-ról, értékmegjelenítés GUI-ra)


prototype: kriptovaluták bányászata, új mennyiség létrehozása ethereumból


observer: árfolyamok frissítése: 
A valuta árfolyamokértéke rendszeresen frissül. Ezeket kérik le az EUR és USD árfolyam osztályok




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
EMAPKamatozasEsKoltsegTest
PMAPKamatozasEsKoltsegTest
MapPluszKamatozasEsKoltsegTest

2) 
EUR és USD valuták árfolyamérték és árfolyamnyereség teszt
USDArfolyamNyeresegtest
EURArfolyamNyeresegtest
ETHArfolyamNyeresegtest


3)
inflációs értékek tesztelése + infláció osztály tdd fejlesztése
InflacioTest


4) 
kamatadó metódus tesztelése + kamatadó osztály tdd fejlesztése:
KamatAdotest

5) 
Árfolyam Observer működésének tesztelése
ArfolyamTest

6) 
Bankszámla kamatozás és költségteszt
BankszamlaKamatozasEsKoltseg

7) 
Kriptopénz bányászati menyniség, költség és árfolyam teszt
BanyaszatMennyisegKoltseg
