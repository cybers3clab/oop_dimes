package oop.gen.v2;

import oop.geom.v4.CartesianPoint2D;
import oop.geom.v4.Point2D;
import oop.geom.v4.PolarPoint2D;

public class ProvaV2 {
    public static void main(String[] args) {
        Pair<String>[] pairs= new Pair[3];
        pairs[0]=new Pair<>("topolino","pippo");
        pairs[1]=new Pair<>("pluto","pippo");
        pairs[2]=new Pair<>("topolino","paperino");
        for (Pair<String>p:pairs)
            System.out.println("<" + p.getFirst() + "," + p.getSecond() + ">");

        Pair<String> p1 =new Pair<>("s1","s2");
        Pair<Point2D> p2= new Pair<Point2D>(new CartesianPoint2D(),new PolarPoint2D());
        Pair<CartesianPoint2D> p3= new Pair<CartesianPoint2D>(new CartesianPoint2D(),new CartesianPoint2D());
        String s= p1.getFirst();

    }
}
