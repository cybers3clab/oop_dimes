package oop.geom.v1;

import static java.lang.Math.sqrt;


public class Point3D {
    //Variabili d'istanza
    private double x;
    private double y;
    private double z;

    //Costruttore
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Costruttore di Copia
    public Point3D(Point3D p){
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point3D p){
        var s=0.0;
        var d= p.x-x;
        s+=d*d;
        d=p.y-y;
        s+=d*d;
        d=p.z-z;
        s+=d*d;
        return sqrt(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D point3D)) return false;
        Point3D p =(Point3D) o;
        return this.distance(p)<=Point2D.EPS;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
