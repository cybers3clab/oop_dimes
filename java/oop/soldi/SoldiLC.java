package oop.soldi;

import java.util.*;


public class SoldiLC extends SoldiAbstract {
    //private final Lista<Denaro> lista;

    public SoldiLC() {
        super(new Lista<Denaro>());
    }

    @Override
    public Iterator<Denaro> iterator() {
        return lista.iterator();
    }
}

    final class Lista<T extends Comparable<? super T>> implements Iterable<T>, List<T>{

        public int size() {
            return size;
        }


        public boolean isEmpty() {
            return size != 0;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iteratore();
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
            return null;
        }


        private static class Nodo<T extends Comparable<? super T>> {
            Nodo<T> next;
            T value;
        }


        Nodo<T> root;
        int size = 0;

        public boolean add(T val) {
            this.size += 1;
            Nodo<T> nodo = new Nodo<T>();
            nodo.value = val;

            if (root == null || root.value.compareTo(val) < 0) {
                nodo.next = root;
                root = nodo;
            } else {
                Nodo<T> cor = root.next, pre = root;
                while (cor != null && cor.value.compareTo(val) >= 0) {
                    pre = cor;
                    cor = cor.next;
                }
                nodo.next = cor;
                pre.next = nodo;
            }


            return true;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {
            size=0;

        }

        @Override
        public T get(int index) {
            return null;
        }

        @Override
        public T set(int index, T element) {
            return null;
        }

        @Override
        public void add(int index, T element) {

        }

        @Override
        public T remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<T> listIterator() {
            return null;
        }

        @Override
        public ListIterator<T> listIterator(int index) {
            return null;
        }

        @Override
        public List<T> subList(int fromIndex, int toIndex) {
            return List.of();
        }

        public class Iteratore implements Iterator<T> {
            private Nodo<T> current = null, last = null;

            @Override
            public boolean hasNext() {
                if (current == null)
                    return root != null;
                return current.next != null;

            }

            @Override
            public T next() {
                if(! hasNext() )
                    throw new NoSuchElementException("");
                if (current == null) {
                    current = root;
                    return current.value;
                } else {
                    last=current;
                    current=current.next;
                    return current.value;
                }
            }
        }
    }