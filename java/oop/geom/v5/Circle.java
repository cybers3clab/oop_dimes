package oop.geom.v5;

public class Circle implements Figure2D {
    private final double radius;

    public Circle(double r) {

        if (r < 0) throw new NegativeRadiusException("negative radius");
        radius = r;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2.0 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}
