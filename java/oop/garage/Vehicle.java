package oop.garage;

import java.util.Vector;

public interface Vehicle {
    default String details(){
        return getName()+", "+getKm()+" KM Plate:"+getLicensePlate();}
    String getName();
    int getWheels();
    int getKm();
    String getLicensePlate();

}

