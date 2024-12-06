package oop.stack;

import java.util.Collection;

public interface Stack<E> {
    void push(E item);
    E pop();
    E top();
    boolean isEmpty();
    boolean isFull();
    int size();

    default void pushAll(Iterable<? extends E> src){
        for (E elem:src)
            push(elem);
    }

   default void popAll(Collection<? super E> c){
        while(!isEmpty())
            c.add(pop());
   }
}
