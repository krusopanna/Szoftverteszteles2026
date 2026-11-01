# Arab -> Római szám konverter (TDD)

Ez a projekt egy JavaScript nyelven írt, TDD (Test Driven Development / Tesztvezérelt Fejlesztés) módszertannal megvalósított konverter, amely az arab számokat alakítja át római számokká az 1 és 3999 közötti tartományban.

## Technológiák

- **Programozási nyelv:** JavaScript
- **Tesztkeretrendszer:** QUnit
- **Verziókezelés:** Git & GitHub

## Funkciók és szabályok

- Az alapszimbólumok (I, V, X, L, C, D, M) és az összeadó szabályok kezelése.
- A kivonásos jelölések (IV, IX, XL, XC, CD, CM) támogatása.
- Érvénytelen bemenetek kezelése (hiba dobása):
- 1-nél kisebb vagy 3999-nél nagyobb számok (pl. 0, negatív értékek, 4000).
- Nem egész számok (pl. lebegőpontos értékek, szöveges típusok).

## Projektstruktúra

```text
├── converter.js    # A konverter logikáját tartalmazó JavaScript fájl
├── tests.js        # A QUnit teszteseteket tartalmazó JavaScript fájl
├── index.html      # A QUnit tesztfuttató HTML felület
└── README.md       # Projekt dokumentáció
```

## Használat és tesztelés

1. Klónozd a repository-t a saját gépedre:

   ```bash
   git clone <REPOSITORY_URL>
   ```
2. Nyisd meg az index.html fájlt egy tetszőleges webböngészőben.
3. A QUnit keretrendszer automatikusan lefuttatja a teszteket és megjeleníti az eredményeket.

## Fejlesztési folyamat (TDD)
A fejlesztés során szigorúan a TDD (Red-Green-Refactor) ciklust követtük:

1. Red: Sikertelen QUnit teszt megírása az adott funkcióhoz.
2. Green: A teszt sikeres teljesítéséhez szükséges minimális kód implementálása.
3. Refactor: A kód szerkezetének tisztázása és optimalizálása úgy, hogy a tesztek továbbra is sikeresek maradjanak.