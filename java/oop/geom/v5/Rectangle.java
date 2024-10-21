package oop.geom.v5;

public class Rectangle implements Figure2D{
    private final double base;
    private final double height;

    public Rectangle(double base, double height) {

        //che succede se sono negativi?
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }



    public double getHeight() {
        return height;
    }



    @Override
    public double area() {
        return base*height;
    }

    @Override
    public double perimeter() {
        return 2*(base+height);
    }
}
