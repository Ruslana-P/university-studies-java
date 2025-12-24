import java.util.Comparator;

interface Drawable {
    void draw();
}

abstract class Shape implements Drawable {
    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public String getShapeColor() {
        return shapeColor;
    }

    @Override
    public String toString() {
        return String.format("%s: color=%s, area=%.2f", 
                getClass().getSimpleName(), shapeColor, calcArea());
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + this.toString());
    }
}

// Конкретні реалізації
class Rectangle extends Shape {
    private double width, height;
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    @Override
    public double calcArea() { return width * height; }
}

class Triangle extends Shape {
    private double base, height;
    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }
    @Override
    public double calcArea() { return 0.5 * base * height; }
}

class Circle extends Shape {
    private double radius;
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    @Override
    public double calcArea() { return Math.PI * radius * radius; }
}