package oop.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListStack1 <E> implements Stack<E>{
    private List<E> list;

    public ListStack1() {

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
