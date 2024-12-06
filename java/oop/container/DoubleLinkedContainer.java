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
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        final int m = size >> 1;
        int k = 0;
        Node<E> curr = null;
        if (index < m) {
            k = 0;
            curr = head;
            while (k < index) {
                curr = curr.next;
                k++;
            }
        } else {

            k = size - 1;
            curr = tail;
            while (k > index) {
                curr = curr.prev;
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
        Node<E> curr = null;
        if (index < size) {
            int m = size / 2;
            int k = 0;

            if (index < m) {
                curr = head;
                while (curr != null && k < index) {
                    curr = curr.next;
                    k++;
                }
            } else {
                curr = tail;

                k = size-1;
                while (curr != null && k > index) {
                    curr = curr.prev;

                    k--;
                }
            }
        }


        Node<E> newNode = new Node<>(elem, null, curr);
        if (curr == null){// add to tail
            if(tail==null)//empty list
                head=newNode;
            else
                tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }else{
            if(curr==head){
                head=newNode;

            }else{
                curr.prev.next=newNode;
                newNode.prev=curr.prev;
            }
            curr.prev=newNode;
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
        return new DLIterator();
    }


    public ListIterator<E> listIterator(){
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

    private final class DLIterator implements ListIterator<E> {

        private Node<E> cur = null;
        private boolean removeOK = false;
        private boolean setOK = false;
        private int index=0;
        private  boolean forward=true;
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
            index++;
            setOK=true;
            removeOK = true;
            forward=true;
            return res;
        }

        /**
         * Returns {@code true} if this list iterator has more elements when
         * traversing the list in the reverse direction.  (In other words,
         * returns {@code true} if {@link #previous} would return an element
         * rather than throwing an exception.)
         *
         * @return {@code true} if the list iterator has more elements when
         * traversing the list in the reverse direction
         */
        @Override
        public boolean hasPrevious() {
            return cur!=null;

        }

        /**
         * Returns the previous element in the list and moves the cursor
         * position backwards.  This method may be called repeatedly to
         * iterate through the list backwards, or intermixed with calls to
         * {@link #next} to go back and forth.  (Note that alternating calls
         * to {@code next} and {@code previous} will return the same
         * element repeatedly.)
         *
         * @return the previous element in the list
         * @throws NoSuchElementException if the iteration has no previous
         *                                element
         */
        @Override
        public E previous() {
            if(!hasPrevious())throw new NoSuchElementException();
            E res = cur.info;
            cur = cur.prev;

            removeOK = true;
            setOK=true;
            forward=false;
            index--;

            return res;

        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #next}. (Returns list size if the list
         * iterator is at the end of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code next}, or list size if the list
         * iterator is at the end of the list
         */
        @Override
        public int nextIndex() {
            return index;
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #previous}. (Returns -1 if the list
         * iterator is at the beginning of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code previous}, or -1 if the list
         * iterator is at the beginning of the list
         */
        @Override
        public int previousIndex() {
            return index-1;
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

            if(!forward){
                if(cur==null)
                    cur=head;
                else
                    cur=cur.next;
            }

            if (cur == head)
                head = cur.next;
            else
                cur.prev.next = cur.next;
            if (cur == tail)
                tail = cur.prev;
            else
                cur.next.prev = cur.prev;
            removeOK = false;
            setOK=false;
            size--;

        }

        /**
         * Replaces the last element returned by {@link #next} or
         * {@link #previous} with the specified element (optional operation).
         * This call can be made only if neither {@link #remove} nor {@link
         * #add} have been called after the last call to {@code next} or
         * {@code previous}.
         *
         * @param e the element with which to replace the last element returned by
         *          {@code next} or {@code previous}
         * @throws UnsupportedOperationException if the {@code set} operation
         *                                       is not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of the specified
         *                                       element prevents it from being added to this list
         * @throws IllegalStateException         if neither {@code next} nor
         *                                       {@code previous} have been called, or {@code remove} or
         *                                       {@code add} have been called after the last call to
         *                                       {@code next} or {@code previous}
         */
        @Override
        public void set(E e) {
            if(!setOK) throw new IllegalStateException();
            cur.info=e;
        }

        /**
         * Inserts the specified element into the list (optional operation).
         * The element is inserted immediately before the element that
         * would be returned by {@link #next}, if any, and after the element
         * that would be returned by {@link #previous}, if any.  (If the
         * list contains no elements, the new element becomes the sole element
         * on the list.)  The new element is inserted before the implicit
         * cursor: a subsequent call to {@code next} would be unaffected, and a
         * subsequent call to {@code previous} would return the new element.
         * (This call increases by one the value that would be returned by a
         * call to {@code nextIndex} or {@code previousIndex}.)
         *
         * @param e the element to insert
         * @throws UnsupportedOperationException if the {@code add} method is
         *                                       not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of this element
         *                                       prevents it from being added to this list
         */
        @Override
        public void add(E e) {
            Node<E> newNode=new Node<>(e,cur,null);
            if(cur==null) {
                newNode.next=head;
                if(head!=null)
                    head.prev=newNode;
                else
                    tail=newNode;
                head = newNode;

            }else {
                newNode.next=cur.next;
                if(cur==tail)
                    tail=newNode;
                else
                    cur.next.prev=newNode;

                cur.next=newNode;
            }
            index++;
            size++;
            removeOK=false;
            setOK=false;


        }
    }
}
