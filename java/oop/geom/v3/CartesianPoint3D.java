package oop.geom.v3;

import static java.lang.Math.sqrt;



public class CartesianPoint3D implements Point3D{
    //Variabili d'istanza
    private double x;
    private double y;
    private double z;
    public static double EPS=1e-10;

    //Costruttore
    public CartesianPoint3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Costruttore di Copia
    public CartesianPoint3D(CartesianPoint3D p){
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

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Point3D p){
        var s=0.0;
        var d= p.getX()-x;
        s+=d*d;
        d=p.getY()-y;
        s+=d*d;
        d=p.getZ()-z;
        s+=d*d;
        return sqrt(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartesianPoint3D point3D)) return false;
        CartesianPoint3D p =(CartesianPoint3D) o;
        return this.distance(p)<= EPS ;
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
