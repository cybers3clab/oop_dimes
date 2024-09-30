package oop.geom.v3;
import static java.lang.Math.*;

public class CartesianPoint2D implements Point2D{

    private double x;
    private double y;

    public CartesianPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public CartesianPoint2D(){}

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getMod() {
        return sqrt(x*x+y*y);
    }

    @Override
    public double getPhase() {
        return atan2(y,x);
    }

    @Override
    public double distance(Point2D p) {
        double dx=getX()-p.getX();
        double dy=getY()-p.getY();
        return sqrt(dx*dx+dy*dy);
    }
}
