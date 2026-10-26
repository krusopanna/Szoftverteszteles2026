package hu.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserMockTest {

    @Mock
    private User mockUser;

    @Mock
    private UserDatabase mockDatabase;

    @Test
    @DisplayName("Mocked user returns data and calls are verified")
    void testMockedUser() {
        when(mockUser.getUserName()).thenReturn("TesztElek");
        when(mockUser.getPassword()).thenReturn("TOPSECRET");
        when(mockUser.isLoggedIn()).thenReturn(true);
        when(mockUser.getId()).thenReturn(123);

        assertEquals("TesztElek", mockUser.getUserName());
        assertEquals("TOPSECRET", mockUser.getPassword());
        assertTrue(mockUser.isLoggedIn());
        assertEquals(123, mockUser.getId());

        verify(mockUser).getUserName();
        verify(mockUser).getPassword();
        verify(mockUser).isLoggedIn();
        verify(mockUser, times(1)).getId();
        verify(mockUser, never()).logout();
    }

    @Test
    @DisplayName("updatePwd calls the database when logged in")
    void testUpdatePwd() {
        User user = new User(mockDatabase);

        boolean result = user.updatePwd("newPass", true);

        assertTrue(result);
        assertEquals("newPass", user.getPassword());
        verify(mockDatabase).setPassword(0, "newPass");
    }

    @Test
    @DisplayName("updatePwd does not call the database when not logged in")
    void testUpdatePwdNotLoggedIn() {
        User user = new User(mockDatabase);

        assertFalse(user.updatePwd("newPass", false));

        verify(mockDatabase, never()).setPassword(anyInt(), anyString());
    }

    @Test
    @DisplayName("updatePwd propagates the database exception")
    void testUpdatePwdException() {
        User user = new User(mockDatabase);
        doThrow(new UnsupportedOperationException())
                .when(mockDatabase).setPassword(anyInt(), anyString());

        assertThrows(UnsupportedOperationException.class,
                () -> user.updatePwd("newPass", true));
    }
}