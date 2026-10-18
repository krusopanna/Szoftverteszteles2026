package hu.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    @DisplayName("Egyenlő szárú háromszög ellenőrzése")
    void testIsosceles() {
        Triangle t = new Triangle(3, 6, 6);
        assertTrue(t.isIsosceles());
        assertFalse(t.isEquilateral());
    }

    @Test
    @DisplayName("Egyenlő oldalú háromszög ellenőrzése")
    void testEquilateral() {
        Triangle t = new Triangle(5, 5, 5);
        assertTrue(t.isEquilateral());
        assertTrue(t.isIsosceles());
    }

    @Test
    @DisplayName("Kerület és terület (Hérón-képlet) tesztelése")
    void testPerimeterAndArea() {
        Triangle t = new Triangle(3, 4, 5);
        assertEquals(12.0, t.getPerimeter(), 1e-6);
        assertEquals(6.0, t.getArea(), 1e-6);
        assertTrue(t.isRightAngled());
    }

    @Test
    @DisplayName("Nem szerkeszthető háromszög kivételt dob")
    void testInvalidTriangleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 10));
    }

    // 3. részfeladat: Adatvezérelt tesztelés Stream forrásból a dia mintaadataival
    @ParameterizedTest(name = "{0} tesztelése")
    @MethodSource("testData")
    void testTriangleWithMethodSource(String type, double a, double b, double c,
            boolean expectedIsosceles, boolean expectedEquilateral, boolean expectedRightAngled) {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals(expectedIsosceles, triangle.isIsosceles());
        assertEquals(expectedEquilateral, triangle.isEquilateral());
        assertEquals(expectedRightAngled, triangle.isRightAngled());
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of("generic", 3.0, 4.0, 6.0, false, false, false),
            Arguments.of("isosceles", 3.0, 6.0, 6.0, true, false, false),
            Arguments.of("equilateral", 8.0, 8.0, 8.0, true, true, false),
            Arguments.of("right-angled", 3.0, 4.0, 5.0, false, false, true)
        );
    }
}