package oop.soldi;

import java.util.Objects;

public class DenaroConcreto implements Denaro{
    private final Taglio valore;
    private int quantita;

    public DenaroConcreto(double valore, int quantita) {
        this.valore = Taglio.findByValue(valore); //faccio propagare ecc
        if(quantita<0){
            throw new IllegalArgumentException("Numero zero");
        }
        this.quantita = quantita;
    }

    @Override
    public double getValore() {
        return valore.getValue();
    }

    @Override
    public int getQuantita() {
        return quantita;
    }

    @Override
    public void setQuantita(int quantita) {
        if(quantita<0){
            throw new IllegalArgumentException("Numero zero");
        }
        this.quantita=quantita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DenaroConcreto that)) return false;
        return quantita == that.quantita && valore == that.valore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valore, quantita);
    }

    @Override
    public String toString() {
        return "DenaroConcreto{" +
                "valore=" + valore +
                ", quantita=" + quantita +
                '}';
    }
}
