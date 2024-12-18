
package oop.test;

import oop.stack.*;
import oop.range.*;

import java.util.ArrayList;
import java.util.List;

public class TestStack {

    public static void main(String[] args) {
        Range r= new Range(0,10);
        Stack<Integer> stack= new UnboundedArrayStack<>(150);
        stack.pushAll(r);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        Stack<Number> stack2= new UnboundedArrayStack<>(150);

            stack2.pushAll(r);
        while (!stack2.isEmpty())
            System.out.println(stack2.pop());


        List<Double> list= new ArrayList<>();
        list.add(6.9);
        list.add(3.5);
        stack2.pushAll(list);

        Stack<Number> stack3= new UnboundedListStack<>();
        stack3.pushAll(r);
        stack3.push(3.4);
        ArrayList<Object> al= new ArrayList<>();
        stack3.popAll(al);
        System.out.println(al);


    }
}
