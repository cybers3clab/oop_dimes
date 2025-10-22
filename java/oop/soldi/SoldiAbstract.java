package oop.soldi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class SoldiAbstract implements Soldi{
    protected final List<Denaro> lista;

    protected SoldiAbstract(List<Denaro> lista) {
        this.lista = lista;
    }


    @Override
    public void sub(Soldi s){
        for( Denaro d: s){
            this.sub(d);
        }

    }

    public List<Denaro> paga(Soldi s1, Soldi s2) {
        if (s1.totale()>=s2.totale()){
            throw new RuntimeException("Non è possibile effettuare il pagamento");
        }

        List<Denaro> ret = new LinkedList<Denaro>();
        double resto=s2.totale() - s1.totale();
        this.add(s2);
        for(Denaro d : this.lista) {
            if (resto >= d.getValore() && resto >= 0.01) {
                int qta = (int) Math.floor(resto / d.getValore());
                if (d.getQuantita() < qta) {
                    resto -= d.getValore() * d.getQuantita();
                    ret.add(new DenaroConcreto(d.getValore(), d.getQuantita()));
                    this.sub(new DenaroConcreto(d.getValore(), d.getQuantita()));
                } else {
                    resto -= d.getValore() * qta;
                    ret.add(new DenaroConcreto(d.getValore(), d.getQuantita() - qta));
                    this.sub(new DenaroConcreto(d.getValore(), qta));
                }

            }
        }
            if(resto > 0.01  || resto < -0.01) {
                this.sub(s2);
                throw new RuntimeException("No taglio");
            }


        return ret;
    }

    @Override
    public void add(Denaro d) {

        Boolean inserito=false;
        for (Denaro den: this){
            if(den.getValore()==d.getValore()){
                den.setQuantita(den.getQuantita()+d.getQuantita());
                inserito=true;
            }

        }
        if (! inserito){
            this.lista.add(d);
            Collections.sort(this.lista);
            Collections.reverse(this.lista);
        }
    }

    public void sub(Denaro d) {
        for (Denaro den: this){
            if(den.getValore()==d.getValore()){
                if(den.getQuantita()-d.getQuantita() <0){
                    throw new IllegalArgumentException("Denaro non trovato dalla sub");
                }
                den.setQuantita(den.getQuantita()-d.getQuantita());
                return;
            }

        }
        throw new IllegalArgumentException("AAA");
    }
    @Override
    public String toString(){
        return this.totale()+" ";
    }

}
