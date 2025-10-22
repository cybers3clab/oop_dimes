package oop.gen.v1;

import oop.geom.v5.CartesianPoint2D;

public class ProvaV1 {
    public static void main(String[] args) {
        Pair [] pairs= new Pair[3];
        pairs[0]=new Pair("pippo","pluto");
        pairs[1]= new Pair(new CartesianPoint2D(3,4),"punto");
        pairs[2]= new Pair(new CartesianPoint2D(1,4),new CartesianPoint2D(3,7));
        //for(Pair p:pairs)
        for(int i=0;i< pairs.length;i++) {
            Pair p=pairs[i];
            System.out.println("<" + p.getFirst() + "," + p.getSecond() + ">");
        }
        pairs[1].setFirst("Giovanni");
        for(Pair p:pairs)
            System.out.println("<" + p.getFirst() + "," + p.getSecond() + ">");



    }
}
