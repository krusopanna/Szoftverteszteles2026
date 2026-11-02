package hu.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

class BankServiceTest {

    @Test
    @DisplayName("Sikeres befizetés növeli az egyenleget és értesítést küld")
    void depositSendsNotificationOnSuccess() {
        NotificationService notificationService = mock(NotificationService.class);
        BankService bankService = new BankService(notificationService);
        BankAccount account = new BankAccount();

        bankService.deposit(account, 1000.0);

        assertEquals(1000.0, account.getBalance());
        verify(notificationService).send("Deposit successful");
    }

    @Test
    @DisplayName("Sikertelen befizetés esetén nem történik értesítés")
    void failedDepositDoesNotSendNotification() {
        NotificationService notificationService = mock(NotificationService.class);
        BankService bankService = new BankService(notificationService);
        BankAccount account = new BankAccount();

        assertThrows(IllegalArgumentException.class, () -> bankService.deposit(account, -500.0));

        assertEquals(0.0, account.getBalance());

        verify(notificationService, never()).send("Deposit successful");
        verifyNoInteractions(notificationService);
    }
}