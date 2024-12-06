package oop.test;

import oop.people.PeopleUtil;
import oop.people.Person;
import oop.people.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestPeople {
    public static void main(String[] args) {
        Person pippo= new Person("33232");
        Person pluto= new Person("12345");
        Person topolino= new Person("00123");
        Student barbieri= new Student("00001");
        System.out.println(barbieri.compareTo(topolino));
        System.out.println(topolino.compareTo(barbieri));
        ArrayList<Person> al=new ArrayList<>(List.of(pippo,pluto,topolino,barbieri));


        System.out.println(PeopleUtil.min(al));

        ArrayList<Student> as= new ArrayList<>();
        as.add(barbieri);
        as.add(new Student("1562"));
        as.add(new Student("0000"));

        as.forEach(System.out::println);


        System.out.println(PeopleUtil.min(as));


        String [ ] as1=new String[]{"a","b","c"};

        Person [] ap1=buildFromID(as1,s ->{
            return new Person("id::"+s);
        } );


        for(Person p:ap1)
            System.out.println(p);
    }


    static Person[] buildFromID(String[] iterable, Function<String,Person> f){
        ArrayList<Person> ap= new ArrayList<>();
        for(String str:iterable){
            ap.add(f.apply(str));
        }
        return  ap.toArray(new Person[ap.size()]);
    }
}
