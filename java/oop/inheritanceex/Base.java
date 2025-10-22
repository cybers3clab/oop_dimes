package oop.inheritanceex;

public class Base {
    private int v;//deve essere positivo
    public Base(int v){
        if(v<=0)throw  new IllegalArgumentException("Deve essere positivo"+v);
        this.v=v;
    }

    public int getV() {
        return v;
    }


    public void setV(int v) {
        if(v<=0) throw new IllegalArgumentException("v must be a positive value, found"+v);
        this.v = v;
    }

    @Override
    public String toString() {
        return "Base{" +
                "v=" + v +
                '}';
    }
}
