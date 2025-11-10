package oop.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testCarte {
    public static void main(String[] args) {

        List<Carta> mazzo =new ArrayList<>();
        for(Seme s:Seme.values())
            for (Valore v: Valore.values())
                mazzo.add(new Carta(s,v));
        Collections.shuffle(mazzo);
        for(Carta c: mazzo)
            System.out.println(c);
    }
}
