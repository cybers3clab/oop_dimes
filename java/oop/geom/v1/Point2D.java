package oop.geom.v1;


public class Point2D {
    private double x;
    private double y;
    public static double EPS=1e-10;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D point2D) {
        this.x = point2D.x;
        this.y = point2D.y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D p = (Point2D) o;
        return distance(p)<=EPS;
    }


    public double distance(Point2D p){
        double dx=p.x-x;
        double dy=p.y-y;
        return Math.sqrt(dx*dx+dy*dy);
    }


    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}