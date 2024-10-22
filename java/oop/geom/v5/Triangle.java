package oop.geom.v5;

public class Triangle implements Figure2D {
    private final Point2D p1;
    private final Point2D p2;
    private final Point2D p3;


    public Triangle(Point2D p1, Point2D p2, Point2D p3) {
        if(Point2DUtil.aligned(p1,p2,p3))
            throw  new IllegalArgumentException();
        this.p1 = new CartesianPoint2D(p1.getX(),p1.getY());
        this.p2 = new CartesianPoint2D(p2.getX(),p2.getY());;
        this.p3 = new CartesianPoint2D(p3.getX(),p3.getY());;
    }


    public double area() {
        double l1 = p1.distance(p2);

        double l2 = p2.distance(p3);
        double l3 = p3.distance(p1);
        double s = (l1 + l2 + l3) * 0.5;

        return Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));

    }

    public double perimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    public Point2D getP1() {
        return p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public Point2D getP3() {
        return p3;
    }
}
