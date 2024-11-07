package oop.test;

import oop.container.Container;
import oop.container.DoubleLinkedContainer;

public class ProvaContainer {
    public static void main(String[] args) {
        Container<String> c = new DoubleLinkedContainer<>();
        //Container<String> c= new LinkedContainer<>();
        c.add(0, "pippo");
        c.add("miao");
        c.add(1, "bau");
        c.add(1, "pluto");
        c.add(0, "minnie");
        c.add(c.size(), "topolino");
        c.get(0);
        c.get(1);
        c.get(3);
        c.get(4);
        c.add(6, "test");
        c.add(6, "testa");
        c.add(0, "xxxx");
        c.add(1, "yyyyyyy");
        c.add(6, "yyyyyyy");
        c.add(6, "yyyyyyy");
        c.set(6, "zzzz");
        c.set(2, "bbbbb");
        c.set(1, "minnie");
        c.size();

    }
}
