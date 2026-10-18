package hu.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    @Test
    @DisplayName("Terület és kerület helyes számítása")
    void testAreaAndPerimeter() {
        Table table = new Table(80, 120, 75);
        assertEquals(9600, table.area());
        assertEquals(400, table.getPerimeter());
    }

    @Test
    @DisplayName("Kapacitás számítása (60 cm-enként 1 személy)")
    void testCapacity() {
        Table table = new Table(60, 120, 75);
        assertEquals(6, table.getCapacity());
    }

    @Test
    @DisplayName("Állítható asztal magasságának érvényes módosítása")
    void testSetHeightValid() {
        Table table = new Table(80, 120, 75, 75);
        table.setHeight(110);
        assertEquals(110, table.getCurrentHeight());
    }

    @Test
    @DisplayName("Nem állítható asztal magasságának állítása kivételt dob")
    void testSetHeightOnNonAdjustableThrowsException() {
        Table table = new Table(80, 120, 75);
        assertThrows(IllegalStateException.class, () -> table.setHeight(90));
    }

    @Test
    @DisplayName("Magasság tartományon [0, 200] kívüli állítása kivételt dob")
    void testSetHeightOutOfRangeThrowsException() {
        Table table = new Table(80, 120, 75, 75);
        assertThrows(IllegalArgumentException.class, () -> table.setHeight(-5));
        assertThrows(IllegalArgumentException.class, () -> table.setHeight(205));
    }

    @Test
    @DisplayName("Szín módosítása, stabilitás és összehajthatóság tesztelése")
    void testExtraAttributes() {
        Table table = new Table(80, 120, 75, 75);
        table.repaint("white");
        assertEquals("white", table.getColor());

        assertTrue(table.isStable());
        assertTrue(table.isFoldable());

        table.setNumberOfLegs(2);
        assertFalse(table.isStable());
        assertFalse(table.isFoldable());
    }
}