package oop.physics;

import oop.geom.v3.CartesianPoint3D;

public class MaterialPoint3DUtils {

    public static CartesianPoint3D getBarycenter(MaterialCartesianPoint3D[] list){
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        double tot_mass=0.0;

        int index =0;
        while( index < list.length ) {

            MaterialCartesianPoint3D curr = list[index];
            tot_mass += curr.getMass();
        }
        index =0;
        while( index < list.length ){
            MaterialCartesianPoint3D curr = list[index];
            x+=(curr.getPoint3D().getX()*curr.getMass());
            y+=(curr.getPoint3D().getY()*curr.getMass());
            z+=(curr.getPoint3D().getZ()*curr.getMass());
            index ++;
        }
        return new CartesianPoint3D(x/tot_mass,y/tot_mass,z/tot_mass);
    }
}
