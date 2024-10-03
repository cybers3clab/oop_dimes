package oop.geom.v3;

public class Point3DUtil {

    public static double middleX(Point3D[] ap){
        double xm=0.0;
        for(Point3D p:ap)
            xm+=p.getX();
        return xm/ap.length;
    }
    public static double middleY(Point3D[] ap){
        double ym=0.0;
        for(Point3D p:ap)
            ym+=p.getY();
        return ym/ap.length;
    }

    public static double middleZ(Point3D[] ap){
        double zm=0.0;
        for(Point3D p:ap)
            zm+=p.getZ();
        return zm/ap.length;
    }
}
