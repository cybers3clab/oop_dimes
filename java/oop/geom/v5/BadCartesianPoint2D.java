package oop.geom.v5;

import java.util.Objects;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class BadCartesianPoint2D extends AbstractPoint2D {


    private double x;
    private double y;

    public BadCartesianPoint2D(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public BadCartesianPoint2D() {
    }

    @Override
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getMod() {
        return sqrt(x * x + y * y);
    }

    @Override
    public double getPhase() {
        return atan2(y, x);
    }

    @Override
    public String toString() {
        return "<x=" + getX() + ",y=" + getY() + ">";
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
