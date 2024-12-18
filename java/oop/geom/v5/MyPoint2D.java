package oop.geom.v5;

import java.util.LinkedList;
import java.util.Objects;

public class MyPoint2D extends  CartesianPoint2D{

   private LinkedList<String> names;
    public MyPoint2D(String name,double x, double y) {
        super(x, y);
        Objects.requireNonNull(name);
        this.names=new LinkedList<>();
        this.names.add(name);
    }
    public void addName(String n){
        Objects.requireNonNull(n);
        if(!names.contains(n))
            names.add(n);
    }
    @Override
    public String toString() {
        return super.toString()+"["+names.toString()+"]";
    }

    @Override
    public Object clone() {
        MyPoint2D cloned=(MyPoint2D) super.clone();
        cloned.names=(LinkedList<String>) names.clone();
        return cloned;
    }
}