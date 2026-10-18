package hu.example;

public class Table {
    private int width;
    private int length;
    private int height;
    private int currentHeight;
    private boolean isAdjustable;
    private String color;
    private int numberOfLegs;

    public Table(int width, int length, int height) {
        this(width, length, height, height);
        this.isAdjustable = false;
    }

    public Table(int width, int length, int height, int currentHeight) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.currentHeight = currentHeight;
        this.isAdjustable = true;
        this.numberOfLegs = 4;
        this.color = "brown";
    }

    public void setHeight(int newHeight) {
        if (!isAdjustable) {
            throw new IllegalStateException("A magasság csak állítható asztalnál módosítható!");
        }
        if (newHeight < 0 || newHeight > 200) {
            throw new IllegalArgumentException("A magasságnak [0, 200] cm között kell lennie!");
        }
        this.currentHeight = newHeight;
    }

    public int area() {
        return width * length;
    }

    public int getCapacity() {
        return (2 * (width + length)) / 60;
    }

    public void repaint(String color) {
        this.color = color;
    }

    public boolean isStable() {
        return numberOfLegs >= 3;
    }

    public boolean isFoldable() {
        return isAdjustable && numberOfLegs >= 4;
    }

    public int getPerimeter() {
        return 2 * (width + length);
    }

    public int getWidth() { return width; }
    public int getLength() { return length; }
    public int getHeight() { return height; }
    public int getCurrentHeight() { return currentHeight; }
    public boolean isAdjustable() { return isAdjustable; }
    public String getColor() { return color; }
    public int getNumberOfLegs() { return numberOfLegs; }
    public void setNumberOfLegs(int numberOfLegs) { this.numberOfLegs = numberOfLegs; }
}