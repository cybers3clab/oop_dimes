package oop.soldi;

import java.util.List;

public interface Soldi extends Comparable<Soldi>,Iterable<Denaro>{

    default void add(Soldi s){
        for(Denaro d: s){
            this.add(d);
        }
    }
    void add(Denaro d);
    void sub(Soldi s);
    void sub(Denaro d);
    List<Denaro> paga(Soldi s1, Soldi s2);

    default double totale(){
        double tot=0;
        for (Denaro s: this){
            tot+= s.getSomma();
        }
        return tot;
    }

    @Override
    default int compareTo(Soldi s){
        return Double.compare(this.totale(),s.totale());
    }


}
