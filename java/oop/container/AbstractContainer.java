package oop.container;

import java.util.Iterator;

public abstract class AbstractContainer<E> implements Container<E> {
    protected int size;

    @Override
    public int size() {
        return size;
    }


    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        E el = Container.super.remove(index);

        return el;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        return Container.super.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<E> it = iterator();
        if (!it.hasNext()) sb.append(']');
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext())
                sb.append(',');
            else
                sb.append(']');
        }
        return sb.toString();
    }
}
