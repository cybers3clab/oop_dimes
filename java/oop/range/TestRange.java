package oop.range;

import java.util.Iterator;

public class TestRange {
    public static void main(String[] args) {
        Range r= new Range(4,500,100);

        printAll(r);
        printAll(()->new FakeIterator(0,9));
    }


    static void  printAll(Iterable<Integer> it){
        for(Integer i:it)
            System.out.println(i);
    }


}
class FakeIterator implements Iterator<Integer>{
    private int v;
    private final int lb;
    private final int ub;

    public FakeIterator(int lb, int ub) {
        this.lb = lb;
        this.ub = ub;
        v=lb;
    }

    @Override
    public Integer next() {
        return v++;
    }

    @Override
    public boolean hasNext() {
        return v<ub;
    }
}