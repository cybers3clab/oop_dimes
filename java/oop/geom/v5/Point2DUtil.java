package oop.geom.v5;

public class Point2DUtil {
     public static double middleX(Point2D... ap){
         double xm=0.0;
         for(Point2D p:ap)
             xm+=p.getX();
         return xm/ap.length;
     }
    public static double middleY(Point2D... ap){
        double ym=0.0;
        for(Point2D p:ap)
            ym+=p.getY();
        return ym/ap.length;
    }

    public static Point2D middlePoint(Point2D... ap){
        return  makeFromCartesian(middleX(ap),middleY(ap));
    }

    public static boolean aligned(Point2D p1, Point2D p2, Point2D p3){
         return Math.abs((p2.getY()-p1.getY())*(p3.getX()-p2.getX())-(p3.getY()-p2.getY())*(p2.getX()-p1.getX()))< Point2D.EPS;
    }
    public static Point2D makeFromCartesian(double x, double y){
        return new CartesianPoint2D(x,y);

    }
    public static Point2D makeFromPolar(double mod, double ph){
        return new PolarPoint2D(mod,ph);
        //return  new CartesianPoint2D(mod*cos(ph),mod*sin(ph));
    }
}
