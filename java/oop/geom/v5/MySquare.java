package oop.geom.v5;

public class MySquare extends  Rectangle{
    public MySquare (double l){
        super(l,l);
    }

    @Override
    public void setBase(double base) {
        super.setBase(base);
        super.setHeight(base);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setBase(height);
    }

    public static void main(String[] args) {
        Rectangle r= new MySquare(3);
        System.out.println(r.area());
        r.setBase(6);
        System.out.println(r.area());

    }
}
