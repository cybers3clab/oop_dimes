package oop.geom.v4;

import java.util.Objects;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class CartesianPoint2D extends AbstractPoint2D {

    private double x;
    private double y;

    public CartesianPoint2D(double x, double y) {

        this.x = x;
        this.y = y;
    }
    public CartesianPoint2D(){}

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getMod() {
        return sqrt(x*x+y*y);
    }

    @Override
    public double getPhase() {
        return atan2(y,x);
    }

    //rimuovere!!
   @Override
    public double distance(Point2D p){
        double dx=x-p.getX();
        double dy=p.getY()-y;
        System.out.println("sono il metodo dentro CP!!");
        return sqrt(dx*dx+dy*dy);
    }


    @Override
    public String toString(){
        return "<x="+getX()+",y="+getY()+">";
    }




    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
