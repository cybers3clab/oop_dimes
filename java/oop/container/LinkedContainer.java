package oop.container;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedContainer<E> extends AbstractContainer<E> {

    private Node<E> head;

    @Override
    public E set(int index, E elem) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();

        if (index == size) {
            add(elem);
            return null;
        }

        Node<E> cur = head;
        int i = 0;
        while (i < index) {
            i++;
            cur = cur.next;
        }
        E e = cur.info;
        cur.info = elem;
        return e;

        /*
        Node<E> cur=head;
        Node<E> prev=null;
        int i=0;
        while (i<index){
            i++;
            prev=cur;
            cur=cur.next;
        }
        if(i<size){
            E e= cur.info;
            cur.info=elem;
            return e;
        }

        Node<E> newNode=new Node<>(elem,null);
        if(prev==null){
            head=newNode;
        } else prev.next= newNode;
        size++;

        return null;

         */
    }

    @Override
    public boolean add(E elem) {

        Node<E> prev = null;
        Node<E> cur = head;
        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }
        Node<E> newNode = new Node<>(elem, null);
        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E elem) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();

        int i=0;
        Node<E> prev = null;
        Node<E> cur = head;
        while (cur != null&&i<index) {
            prev = cur;
            cur = cur.next;
            i++;
        }

        Node<E> newNode = new Node<>(elem, cur);
        if (cur == head) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LCIterator();
    }

    private static class Node<E> {
        E info;
        Node<E> next;

        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;

        }


    }

    private final class LCIterator implements Iterator<E> {

        private Node<E> prev;
        private Node<E> curr;
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
            if (curr == null)
                return head != null;
            else
                return curr.next != null;
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
            prev = curr;
            if (curr == null)
                curr = head;
            else
                curr = curr.next;
            E res = curr.info;

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
            removeOK = false;
            if (curr == head) {
                head = head.next;
            } else {
                prev.next = curr.next;

            }
            curr = curr.next;
            size--;
        }
    }
}
