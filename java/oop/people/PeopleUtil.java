package oop.people;

public class PeopleUtil {


    public static  <T extends Comparable<? super T>> T min(Iterable<T> list){
        T min=null;
        for(T p: list){
            if(min==null || p.compareTo(min)<0){
                min=p;
            }
        }
        return min;
    }
}
