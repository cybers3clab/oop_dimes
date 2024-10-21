package oop.geom.v4;

import static java.lang.Math.sqrt;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
public interface Point2D {
    double getX();
    double getY();
    double getMod();
    double getPhase();
    default double distance(Point2D p){
        double dx=getX()-p.getX();
        double dy=getY()-p.getY();
        System.out.println("sono il metodo di default di Point2D!!");
        return sqrt(dx*dx+dy*dy);
    }

    static Point2D makeFromCartesian(double x, double y){
        return new CartesianPoint2D(x,y);

    }
    static Point2D makeFromPolar(double mod, double ph){
        //return new PolarPoint2D(mod,ph);
        return  new CartesianPoint2D(mod*cos(ph),mod*sin(ph));
    }

    public static final double EPS=1e-10;


}
