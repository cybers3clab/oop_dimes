package oop.stack;

import java.util.LinkedList;
import java.util.List;

public class ListStack<E> implements Stack<E>{
    private List<E> list;

    public ListStack() {

        list= new LinkedList<>();
        //list= new Vector<>();
        //list= new ArrayList<>();

    }

    @Override
    public void push(E item) {
        list.addLast(item);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E top() {
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }
}
