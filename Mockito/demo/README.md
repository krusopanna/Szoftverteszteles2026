# BankAccount Mockito Tesztek (4. feladat)

A projekt a korábban elkészített `BankAccount` osztályt egészíti ki külső értesítési és árfolyam-szolgáltatásokkal, amelyeket Mockito tesztkeretrendszer segítségével mockolunk és tesztelünk.

## Projektstruktúra

```text
├── src/
│   ├── main/
│   │   └── java/
│   │       └── hu/
│   │           └── example/
│   │               ├── BankAccount.java           # Bankszámla üzleti logika
│   │               ├── BankService.java           # Banki szolgáltatások (Dependency Injection)
│   │               ├── ExchangeRateService.java   # Árfolyam-szolgáltatás interfész
│   │               └── NotificationService.java   # Értesítési szolgáltatás interfész
│   └── test/
│       └── java/
│           └── hu/
│               └── example/
│                   ├── BankServiceTest.java         # Mockito tesztek (verify, never)
│                   └── ExchangeRateServiceTest.java # Mockito tesztek (when..thenReturn)
├── pom.xml                                          # Maven konfiguráció
└── README.md                                        # Projekt leírás
```

## Le-tesztelt esetek

* Sikeres befizetés: Növeli az egyenleget és meghívja a NotificationService.send() metódust (verify).

* Sikertelen befizetés: Kivételt dob, és nem küld értesítést (verifyNoInteractions / never).

* Árfolyam lekérdezés: A when().thenReturn() segítségével beállított előre meghatározott árfolyamérték ellenőrzése.

## Tesztek futtatása
### Parancssorból (Maven)
```bash
mvn clean test
```