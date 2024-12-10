package oop.soldi;

public interface Denaro extends Comparable<Denaro>{
    double getValore();
    int getQuantita();
    default double getSomma(){
        return getValore()*getQuantita();
    }
    default int compareTo(Denaro d){
        return  Double.compare(getSomma(),d.getSomma());
    }

    void setQuantita(int i);
}
