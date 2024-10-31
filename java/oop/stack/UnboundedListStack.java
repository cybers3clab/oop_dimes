package oop.stack;

public class UnboundedListStack<E> implements Stack<E>{
    private int size=0;
    private Node<E> head=null;

    public UnboundedListStack() {
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public E pop() {
        if (head==null) throw new EmptyStackException();
        E info = head.info;
        head=head.next;
        size--;
        return info;
    }

    @Override
    public void push(E item) {
        head=new Node<>(item,head);
        size++;


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E top() {
        if(head==null) throw new EmptyStackException();
        return head.info;
    }

    private static class Node<E>{
        E info;
        Node<E> next;

        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
    }
}
