package oop.stack;

public interface Stack<E> {
    void push(E item);
    E pop();
    E top();
    boolean isEmpty();
    boolean isFull();
    int size();
}
