package oop.inheritanceex;

public class Derived extends Base{
    private double x;
    public Derived(){
        super(1);
        x=0.0;
    }
    public Derived(double x){
        this();
        this.x=x;
    }

    @Override
    public String toString() {
        return super.toString()+" x:"+x;
    }

    public static void main(String[] args) {
        Derived d = new Derived(4.0);
        System.out.println(d);

        Base b = new Base(4);
        System.out.println(b);

        System.out.println(b);


    }
}
