package oop.test;

public class C extends SC{
    private int subValue=0;
    public C(){
        super(0);
    }

    public C(int v,int sv){

        super(v);

        this.subValue=sv;
    }

    @Override
    public String toString() {
        return "value="+getValue()+ "  subvalue="+subValue;
    }
}
