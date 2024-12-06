package oop.students;

public class Student {

    private final String id;
    private final String surname;
    private  final String name;

    public Student(String id, String surname, String name) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public final boolean equals(Object obj) {
        if(obj==null) return  false;
        if(obj==this) return true;
        if(! (obj instanceof Student s))
            return  false;

        return s.id.equals(id);

    }

    @Override
    public final int hashCode() {
        return 31*id.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "("+surname+","+name+")["+id+"]";
    }
}
