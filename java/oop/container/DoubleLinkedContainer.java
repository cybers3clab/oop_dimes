package oop.container;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleLinkedContainer<E> extends AbstractContainer<E> {
    private Node<E> head;
    private Node<E> tail;

    @Override
    public E set(int index, E elem) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
        if (index == size) {
            add(elem);
            return null;
        }


        int m = size / 2;
        int k = 0;
        Node<E> cur = null;
        if (index < m) {
            cur = head;
            while (cur != null && k < index) {
                cur = cur.next;
                k++;
            }
        } else {
            cur = tail;
            k = size - 1;
            while (cur != null && k > index) {
                cur = cur.prev;
                k--;
            }
        }


        E res = cur.info;
        cur.info = elem;
        return res;
    }

    @Override
    public E get(int index) {
        if(index<0|| index>=size) throw new ArrayIndexOutOfBoundsException();
        final int m=size>>1;
        int k=0;
        Node<E> curr=null;
        if(index<m){
            k=0;
            curr=head;
            while (k<index){
                curr=curr.next;
                k++;
            }
        }else {

            k=size-1;
            curr=tail;
            while (k>index){
                curr= curr.prev;
                k--;
            }
        }
            return curr.info;
    }

    @Override
    public boolean add(E elem) {
        Node<E> newNode = new Node<>(elem, tail, null);
        if (tail != null) tail.next = newNode;
        else head = newNode;
        tail = newNode;

        size++;
        return true;

    }

    @Override
    public void add(int index, E elem) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
        int m = size / 2;
        int k = 0;
        Node<E> prev = null;
        Node<E> curr = null;
        if (index < m) {
            curr = head;

            while (curr != null && k < index) {
                prev = curr;
                curr = curr.next;
                k++;
            }
        } else {
            prev = tail;

            k = size;
            while (prev != null && k > index) {
                curr = prev;
                prev = prev.prev;
                k--;
            }
        }




        Node<E> newNode = new Node<>(elem, prev, curr);
        if (curr == head)
            head = newNode;
        else
            prev.next = newNode;

        if (prev == tail)
            tail = newNode;
        else
            curr.prev=newNode;

        size++;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new DLIterator();
    }


    private static final class Node<E> {
        Node<E> prev;
        Node<E> next;
        E info;

        public Node(E info, Node<E> prev, Node<E> next) {
            this.info = info;
            this.next = next;
            this.prev = prev;
        }

        public Node(E info) {
            this(info, null, null);
        }
    }

    private final class DLIterator implements Iterator<E> {

        private Node<E> cur = null;
        private boolean removeOK = false;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (cur == null) return head != null;
            return cur.next != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (cur == null)
                cur = head;
            else
                cur = cur.next;
            E res = cur.info;
            removeOK = true;
            return res;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            if (!removeOK) throw new IllegalStateException();
            if (cur == head)
                head = cur.next;
            else
                cur.prev.next = cur.next;
            if (cur == tail)
                tail = cur.prev;
            else
                cur.next.prev = cur.prev;
            removeOK=false;
            size--;

        }
    }
}
