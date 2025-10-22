package oop.soldi;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoldiList extends SoldiAbstract {


    public SoldiList(){
       super(new LinkedList<Denaro>());
    }

    public SoldiList(List<Denaro> denaro){
        super(new LinkedList<Denaro>());
        for (Denaro d :denaro) {
            this.lista.add(d);

        }
        Collections.sort(this.lista);
        Collections.reverse(this.lista);
    }


    @Override
    public Iterator<Denaro> iterator() {
        return lista.iterator();
    }


}
