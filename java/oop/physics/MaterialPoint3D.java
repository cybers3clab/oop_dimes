package oop.physics;

import oop.geom.v3.CartesianPoint3D;

public interface MaterialPoint3D {
    CartesianPoint3D getPoint3D();

    double getMass();
}
