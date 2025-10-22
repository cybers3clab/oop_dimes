package oop.geom.v4;

public class Test {

    public static void main(String[] args) {
        Point2D p1 = new CartesianPoint2D(3,4);
        CartesianPoint2D p2= new CartesianPoint2D(4,5);
        PolarPoint2D p3 = new PolarPoint2D(-3,4);
        double d=p3.distance(p2);

    }
}
