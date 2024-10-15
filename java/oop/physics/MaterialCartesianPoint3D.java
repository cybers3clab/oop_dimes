package oop.physics;

import oop.geom.v3.CartesianPoint3D;

import static java.lang.System.exit;

public class MaterialCartesianPoint3D implements MaterialPoint3D {
    private CartesianPoint3D point3D;
    private double mass;

    @Override
    public CartesianPoint3D getPoint3D() {
        return point3D;
    }

    @Override
    public double getMass() {
        return mass;
    }

    public MaterialCartesianPoint3D(CartesianPoint3D point3D, double mass) {
        if (mass < 0){
            exit(-1);
        }
        else {
            this.point3D = point3D;
            this.mass = mass;
        }
    }

    public MaterialCartesianPoint3D(double x, double y, double z, double mass){
        if (mass < 0){
            exit(-1);
        }
        else {
            this.mass=mass;
            this.point3D=new CartesianPoint3D(x,y,z);
        }
    }
}
