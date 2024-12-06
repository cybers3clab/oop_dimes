package oop.test;

import oop.container.Container;
import oop.container.DoubleLinkedContainer;

public class ProvaContainer {
    public static void main(String[] args) {
        Container<String> c = new DoubleLinkedContainer<>();
        //Container<String> c= new LinkedContainer<>();
        c.add(0, "pippo");
        System.out.println(c);

        c.add("miao");
        System.out.println(c);

        c.add(1, "bau");
        System.out.println(c);

        c.add(1, "pluto");
        System.out.println(c);

        c.add(0, "minnie");
        System.out.println(c);

        c.add(c.size(), "topolino");
        System.out.println(c);

        c.get(0);
        c.get(1);
        c.get(3);
        c.get(4);
        c.add(6, "test");
        System.out.println(c);

        c.add(6, "testa");
        System.out.println(c);

        c.add(0, "xxxx");
        System.out.println(c);

        c.add(1, "yyyyyyy");
        System.out.println(c);

        c.add(6, "yyyyyyy");
        System.out.println(c);

        c.add(6, "yyyyyyy");
        System.out.println(c);

        c.set(6, "zzzz");
        System.out.println(c);

        c.set(2, "bbbbb");
        System.out.println(c);

        c.set(1, "minnie");
        System.out.println(c);

        c.size();

    }
}
