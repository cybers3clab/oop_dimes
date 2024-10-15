package oop.geom.v4;

import static java.lang.Math.*;


public class PolarPoint2D implements Point2D {
  private double mod;
  private double ph;

    public PolarPoint2D(double mod, double ph) {
        this.mod = mod;
        this.ph = ph;
    }

    public PolarPoint2D(){}



    @Override
    public double getX() {
        return mod*cos(ph);
    }

    @Override
    public double getY() {
        return mod*sin(ph);
    }

    @Override
    public double getMod() {
        return mod;
    }

    @Override
    public double getPhase() {
        return ph;
    }



}
