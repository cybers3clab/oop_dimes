package oop.container;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Container<E> extends Iterable<E> {
    default int size() {
        int c = 0;

        for (E e : this) c++;
        /*Iterator<E> it= iterator();
        while (it.hasNext()){
            it.next();
            c++;
        }*/
        return c;

    }

    default E get(int index) {
        int i = 0;
        for (E elem : this) {
            if (index == i) return elem;
            i++;
        }
        throw new NoSuchElementException();
    }

    E set(int index, E elem);

    default E remove() {
        Iterator<E> it = iterator();
        E elem = it.next();
        it.remove();
        return elem;
    }

    default E remove(int index) {
        int i = 0;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (i == index) {
                it.remove();
                return elem;
            }
            i++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    default boolean remove(E elem) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E foundElem = it.next();
            if (foundElem.equals(elem)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    boolean add(E elem);


    void add(int index,E elem);

    default void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    default boolean contains(E elem) {
        for (E fe : this) {
            if (fe.equals(elem))
                return true;

        }
        return false;
    }

}
