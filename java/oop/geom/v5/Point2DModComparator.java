package oop.geom.v5;

import java.util.Comparator;

public class Point2DModComparator implements Comparator<Point2D> {
    @Override
    public int compare(Point2D o1, Point2D o2) {
        return Double.compare(o1.getMod(), o2.getMod());
    }
}
