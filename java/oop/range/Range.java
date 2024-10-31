package oop.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private final int start;
    private final int stop;
    private final int step;

    public Range(int start, int stop, int step) {
        if (step == 0) throw new IllegalArgumentException();

        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    public Range(int start, int stop) {
        this(start, stop, 1);
    }

    public Range(int stop) {
        this(0, stop, 1);
    }

    @Override
    public Iterator<Integer> iterator() {

        return new InnerIter();
    }

    private class InnerIter implements Iterator<Integer> {
        private boolean begin = false;
        private int value = start;


        @Override
        public boolean hasNext() {
            if (!begin)
                return value < stop;

            if (step > 0 && value < Integer.MAX_VALUE - step) return value + step < stop;
            else if (step < 0 && value > Integer.MIN_VALUE - step)
                return value + step > stop;
            else return false;
        }


        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (begin)
                value = value + step;
            else begin = true;
            return value;
        }
    }
}