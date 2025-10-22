package oop.range;

import java.util.Iterator;

public class TestRange {
    public static void main(String[] args) {
        Range r= new Range(4,7,1);


        printAll(r);


        //Iterator<Integer> fi= new FakeIterator(0,9);
        //printAll(fi);
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
        if(lb>=ub)throw new IllegalArgumentException();
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