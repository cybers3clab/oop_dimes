package oop.gen.bounds;

import jdk.jshell.execution.Util;
import oop.geom.v5.CartesianPoint2D;
import oop.geom.v5.Point2D;
import oop.geom.v5.PolarPoint2D;

import java.util.*;

public final class Utils {
    private Utils(){}

    public static <E extends Comparable<E>> E maxElem(Collection<E> c){
        if(c==null || c.isEmpty()) throw new IllegalArgumentException();
        Iterator<E> it =c.iterator();
        E max= it.next();
        while(it.hasNext()){
            E elem= it.next();
            if(elem.compareTo(max)>0){
                max=elem;
            }
        }
        return  max;

    }

    public static <E> void addAll(Collection<? super E> c1, Collection<? extends E> c2){
        if(c1==null|| c2==null) throw  new IllegalArgumentException();
        for(E e: c2){
            c1.add(e);
        }
    }


    public static void main(String[] args) {
        List<String> ls = new LinkedList<>();
        ls.add("ciao");
        ls.add("pippo");
        ls.add("alpha");
        String smax= maxElem(ls);
        System.out.println(smax);

        LinkedList<Point2D> lp= new LinkedList<Point2D>();
        lp.add(new PolarPoint2D(3,4));
        lp.add(new CartesianPoint2D(5,6));

        LinkedList<String> ls2= new LinkedList<>();
        addAll(ls2,ls);
        System.out.println(ls2);
        LinkedList<Object> lo= new LinkedList<>();
        addAll(lo,ls);
        System.out.println(lo);


        LinkedList<CartesianPoint2D> lc2d= new LinkedList<>();
        lc2d.add(new CartesianPoint2D(3,4));
        lc2d.add(new CartesianPoint2D(5,4));
        lc2d.add(new CartesianPoint2D(7,-2));

        Utils.<Point2D> addAll(lp,lc2d);
        System.out.println(lp);





    }

}
