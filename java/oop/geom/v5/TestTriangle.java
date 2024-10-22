package oop.geom.v5;

public class TestTriangle {
    public static void main(String[] args) {
        BadCartesianPoint2D p1= new BadCartesianPoint2D(0,0);
        Point2D p2= new BadCartesianPoint2D(1,0);
        Point2D p3= new BadCartesianPoint2D(0,1);

        Triangle t= new Triangle(p1,p2,p3);
        System.out.println(t.area());

        p1.setX(4.0);
        System.out.println(t.area());

        ((BadCartesianPoint2D)t.getP1()).setX(4.0);

        System.out.println(t.area());

    }
}
