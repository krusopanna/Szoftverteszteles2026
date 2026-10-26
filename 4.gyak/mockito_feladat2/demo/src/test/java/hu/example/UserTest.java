package hu.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("1. Rész: Alapértelmezett állapotok és kivétel ellenőrzése")
    void testInitialUserState() {
        assertNotNull(user, "A user objektum nem null");
        assertNull(user.getUserName(), "A username értéke null");
        assertNull(user.getPassword(), "A password értéke null");
        assertEquals(0, user.getId(), "Az id értéke 0");
        assertEquals(0, user.getLoginCount(), "A loginCount értéke 0");

        assertThrows(UnsupportedOperationException.class, () -> user.updatePwd("newPass", true));
    }

    @Test
    @DisplayName("2. Rész: Kezdetben nincs bejelentkezve")
    void testInitiallyNotLoggedIn() {
        assertFalse(user.isLoggedIn());
    }

    @Test
    @DisplayName("3. Rész: Login állapot és loginCount növekedés")
    void testLoginFlow() {
        user.login();
        assertTrue(user.isLoggedIn());
        assertEquals(1, user.getLoginCount());

        user.login();
        assertEquals(2, user.getLoginCount());
    }

    @Test
    @DisplayName("4. Rész: Logout művelet ellenőrzése")
    void testLogout() {
        user.login();
        assertTrue(user.isLoggedIn());

        user.logout();
        assertFalse(user.isLoggedIn());
        assertEquals(1, user.getLoginCount(), "A kijelentkezés nem csökkenti a számlálót");
    }
}