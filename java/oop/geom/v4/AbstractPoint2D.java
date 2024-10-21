package oop.geom.v4;

public abstract class AbstractPoint2D implements Point2D{

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return  true;
        if(obj instanceof Point2D p){
            return p.distance(this)<=EPS;
        }
        return false;
    }
}
