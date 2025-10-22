package oop.geom.v5;

public class Rectangle implements Figure2D{
    private  double base;
    private  double height;

    public Rectangle(double base, double height) {

        //che succede se sono negativi?
        if(base<=0||height<=0)throw new IllegalArgumentException();
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if(base <=0)throw new IllegalArgumentException();
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height<=0) throw new IllegalArgumentException();
        this.height = height;
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
