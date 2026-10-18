package hu.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("2 + 3 eredménye 5")
    void additionWorks() {
        // Arrange
        // (A calculator példányosítását a setUp végzi)

        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void subtractionWorks() {
        assertEquals(7, calculator.subtract(10, 3));
    }

    @Test
    void multiplicationWorks() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void divisionByZeroThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10, 0)
        );

        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void simpleAssertions() {
        assertEquals(4, 2 + 2);
        assertTrue(10 > 5);
        assertFalse(3 > 10);

        String name = "Oliver";
        assertNotNull(name);
    }

    @Test
    void severalAssertions() {
        int result = 10;

        assertAll(
            () -> assertTrue(result > 0),
            () -> assertTrue(result < 100),
            () -> assertEquals(10, result)
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "3, 4, 7",
        "-1, 1, 0",
        "10, 20, 30"
    })
    void additionWorksParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 100})
    void positiveNumbersArePositive(int number) {
        assertTrue(number > 0);
    }

    @Test
    @Disabled("A funkció még nincs implementálva")
    void unfinishedTest() {
        // még nincs kész
    }
}