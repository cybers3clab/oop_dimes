package oop.innnerex;

public class Outer {
    private static final String secret ="abracadabra";
    private final String name;

    public Outer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Outer{" +
                "name='" + name + '\'' +
                '}';
    }


    public class Inner{
        private int v;
        Inner(int v){
            this.v=v;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "v=" + v +
                    '}';
        }

        public String motherName(){
            return Outer.this.name;
        }
    }


    public static class InnerS{
        public static String showSecret(){
            return secret;
        }
    }
    public static void main(String[] args) {
        Outer m1= new Outer("m1");
        Outer m2= new Outer("m2");
        Outer.Inner f11= m1.new Inner(1);
        Outer.Inner f21= m1.new Inner(2);
        Outer.Inner f12= m2.new Inner(1);
        System.out.println(f11.motherName());
        System.out.println(f21.motherName());
        System.out.println(f12.motherName());
        System.out.println(Outer.InnerS.showSecret());

        Object o = new Outer.InnerS();


    }
}
