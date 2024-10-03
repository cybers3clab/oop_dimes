package oop.physics;

import oop.geom.v3.CartesianPoint3D;

import java.util.List;

import static java.lang.System.exit;

public class MaterialPoint3D {
    private CartesianPoint3D point3D;
    private double mass;

    public CartesianPoint3D getPoint3D() {
        return point3D;
    }

    public double getMass() {
        return mass;
    }

    public MaterialPoint3D(CartesianPoint3D point3D, double mass) {
        if (mass < 0){
            exit(-1);
        }
        else {
            this.point3D = point3D;
            this.mass = mass;
        }
    }

    public MaterialPoint3D(double x, double y, double z, double mass){
        if (mass < 0){
            exit(-1);
        }
        else {
            this.mass=mass;
            this.point3D=new CartesianPoint3D(x,y,z);
        }
    }
}
