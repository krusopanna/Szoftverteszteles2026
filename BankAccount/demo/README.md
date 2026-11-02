# BankAccount Java osztály és JUnit 5 tesztek

Ez a projekt egy egyszerű bankszámlát modellező `BankAccount` Java osztályt és annak JUnit 5 egységtesztjeit tartalmazza.

## Megvalósított funkciók

* Kezdő egyenleg: `0.0`
* `deposit(double amount)`: Egyenleg növelése (csak pozitív összegekkel).
* `withdraw(double amount)`: Egyenleg csökkentése (csak pozitív összegekkel és a rendelkezésre álló egyenlegig).
* `getBalance()`: Aktuális egyenleg lekérdezése.
* Hibás műveletek (pl. negatív/nulla összeg, túlvétel) esetén `IllegalArgumentException` kivétel dobása.
* Sikertelen művelet esetén az egyenleg nem változik.

## Technológiák

* **Programozási nyelv:** Java 17+
* **Tesztkeretrendszer:** JUnit 5 (Jupiter)
* **Projektkezelő:** Maven

## Projektstruktúra

```text
├── src/
│   ├── main/
│   │   └── java/
│   │       └── hu/
│   │           └── example/
│   │               └── BankAccount.java       # A bankszámla üzleti logikája
│   └── test/
│       └── java/
│           └── hu/
│               └── example/
│                   └── BankAccountTest.java   # JUnit 5 egységtesztek
├── pom.xml                                    # Maven függőségek és konfiguráció
└── README.md                                  # Projekt dokumentáció
```

## Futtatás és Tesztelés

### Maven használatával:
```bash
mvn clean test
```