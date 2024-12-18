package oop.students;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestStudent {

    public static void main(String[] args) {

        Comparator<Student> comp= new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        Set<Student> students= new TreeSet<>(comp);

        var s1= new Student("1234","Smith","PierAristide");
        var s2= new Student("35564","Moore","PierCarmelo");
        var s3= new Student("773446473","Mason","Nick");
        var s4= new Student("745323","Barret","Sid");
        var s5= new Student("898473","Gilmour","David");
        var s6= new Student("45465","Waters","Roger");
        var s7= new Student("8899","Wrigth","Richard");


        students.add(s1);
        System.out.println(students);
        students.add(s2);
        System.out.println(students);
        students.add(s3);
        System.out.println(students);
        students.add(s4);
        System.out.println(students);
        students.add(s5);
        System.out.println(students);
        students.add(s6);
        System.out.println(students);
        students.add(s7);
        System.out.println(students);
        students.add(new Student("83833","Moore","Vinnie"));
        System.out.println(students);
    }
}


class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int res= o1.getSurname().compareTo(o2.getSurname());
        if(res!=0) return  res;
        res = o1.getName().compareTo(o2.getName());
        if(res!=0) return  res;
        res = o1.getId().compareTo(o2.getId());

        return res;
    }
}