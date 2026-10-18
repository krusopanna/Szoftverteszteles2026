package hu.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    @DisplayName("1. Új számla egyenlege 0")
    void newAccountBalanceIsZero() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("2. deposit(1000) után az egyenleg 1000")
    void depositIncreasesBalance() {
        account.deposit(1000.0);
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    @DisplayName("3. Több befizetés helyesen összeadódik")
    void multipleDepositsAddUp() {
        account.deposit(500.0);
        account.deposit(1500.0);
        assertEquals(2000.0, account.getBalance());
    }

    @Test
    @DisplayName("4. Befizetés után a withdraw() helyesen csökkenti az egyenleget")
    void withdrawDecreasesBalance() {
        account.deposit(1000.0);
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    @DisplayName("5. A teljes egyenleg felvehető")
    void withdrawEntireBalance() {
        account.deposit(1000.0);
        account.withdraw(1000.0);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("6. Túl nagy összeg felvétele IllegalArgumentException kivételt dob")
    void withdrawMoreThanBalanceThrowsException() {
        account.deposit(500.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600.0));
    }

    @Test
    @DisplayName("7. Negatív befizetés kivételt dob")
    void negativeDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }

    @Test
    @DisplayName("8. 0 összegű befizetés kivételt dob")
    void zeroDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }

    @Test
    @DisplayName("9. Negatív pénzfelvétel kivételt dob")
    void negativeWithdrawThrowsException() {
        account.deposit(500.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    @Test
    @DisplayName("10. 0 összegű pénzfelvétel kivételt dob")
    void zeroWithdrawThrowsException() {
        account.deposit(500.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }
}