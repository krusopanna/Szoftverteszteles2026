package hu.example;

public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Nem szerkeszthető háromszög!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isIsosceles() {
        return a == b || a == c || b == c;
    }

    public boolean isEquilateral() {
        return a == b && b == c;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    // 4. részfeladat: Derékszögű-e (Pitagorasz-tétel)
    public boolean isRightAngled() {
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        return Math.abs(Math.pow(sides[0], 2) + Math.pow(sides[1], 2) - Math.pow(sides[2], 2)) < 1e-6;
    }

    // 4. részfeladat: Terület Hérón-képlettel
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}