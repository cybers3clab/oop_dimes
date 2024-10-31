package oop.range;

public class TestRange {
    public static void main(String[] args) {
        Range r= new Range(4,5000,100);
        for (int i: r)
            System.out.println(i);
    }
}
