package oop.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public record Range2(int start, int stop, int step) implements Iterable<Integer> {

    public Range2 {
        if (step == 0) throw new IllegalArgumentException();

    }

    public Range2(int start, int stop) {
        this(start, stop, 1);
    }

    public Range2(int stop) {
        this(0, stop, 1);
    }

    @Override
    public Iterator<Integer> iterator() {

        return new WrapperIterator(step>0);
    }


    private class WrapperIterator implements Iterator<Integer> {
        private int value;
        private Iterator<Integer> wrapped;

        WrapperIterator(boolean up) {
            value=start;
            if (up)
                wrapped = new StartUpCountingIter();
            else
                wrapped = new StartDownCountingIter();
        }

        @Override
        public Integer next() {
            return wrapped.next();

        }

        @Override
        public boolean hasNext() {
            return wrapped.hasNext();
        }

        private class StartUpCountingIter implements Iterator<Integer> {
            @Override
            public boolean hasNext() {
                return value < stop;
            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException();

                wrapped= new UpCountingIter();
                return value;

            }
        }

        private class StartDownCountingIter implements Iterator<Integer> {
            @Override
            public boolean hasNext() {
                return value>stop;
            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException();
                wrapped= new DownCountingIter();

                return value;
            }
        }
        private class UpCountingIter implements Iterator<Integer>{
            @Override
            public boolean hasNext() {
                return   value < Integer.MAX_VALUE - step &&  value + step < stop;

            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException();
                value=value+step;
                return value;
            }
        }

        private class DownCountingIter implements Iterator<Integer>{
            @Override
            public boolean hasNext() {
                return value > Integer.MIN_VALUE - step && value + step > stop;
            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException();
                value=value+step;
                return value;
            }
        }
    }

}