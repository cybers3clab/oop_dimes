package oop.geom.v3;

public class Point2DUtil {
     public static double middleX(Point2D[] ap){
         double xm=0.0;
         for(Point2D p:ap)
             xm+=p.getX();
         return xm/ap.length;
     }
    public static double middleY(Point2D[] ap){
        double ym=0.0;
        for(Point2D p:ap)
            ym+=p.getY();
        return ym/ap.length;
    }
}
