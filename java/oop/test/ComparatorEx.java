package oop.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorEx {

    public static void main(String[] args) {
        String[] as = {"aaaa", "bfddf", "aaaax", "fdsfsdf", "assas", "lsdld"};

        Comparator<String> comp =  ( s1,  s2) -> {
            if (s1.length() < s2.length()) return -1;
            else if (s1.length() > s2.length()) return 1;
            return s1.compareTo(s2);
        };

        comp= String::compareTo;

        int k = comp.compare("alpha", "beta");
        System.out.println(k);
        System.out.println(comp.getClass());

        TreeSet<String> set = new TreeSet<>(comp);
        Collections.addAll(set, as);
        System.out.println(set);


    }
}
