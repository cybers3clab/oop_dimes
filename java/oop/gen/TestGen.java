package oop.gen;

import oop.gen.v3.Pair;

public class TestGen {
    public static void main(String[] args) {
        Pair<String,String> pair1=new Pair<>("pippo","pluto");
        String s1=pair1.getSecond();


        Pair<Double,Double> pair2= new Pair<>(4.0,8.0);

        System.out.println(pair1.getFirst().getClass());

        System.out.println(pair1.getSecond().getClass());
        System.out.println(pair2.getFirst().getClass());
        System.out.println(pair2.getSecond().getClass());


    }
}
