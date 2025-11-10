package oop.geom.v5;

import java.util.Comparator;

public class Point2DModPhaseComparator implements Comparator<Point2D> {


    @Override
    public int compare(Point2D p1, Point2D p2) {
        if(p1==null||p2==null) throw  new NullPointerException();
        double m1 =p1.getMod();
        double m2 =p2.getMod();
        int res = Double.compare(m1,m2);
        if(res!=0) return res;
        double ph1=p1.getPhase();
        double ph2=p2.getPhase();
        return  Double.compare(ph1,ph2);
    }
}
