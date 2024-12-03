package oop.serialization;

public class MaterialePericoloso extends Materiale{
    private final int classePericolo;
    public MaterialePericoloso(String nome, int quantita, double prezzoUnitario, int classePericolo) {
        super(nome, quantita, prezzoUnitario);
        this.classePericolo = classePericolo;
    }

    public int getClassePericolo() {
        return classePericolo;
    }
    @Override
    public String toString() {
        return "Materiale{" +
                "nome='" + super.getNome() + '\'' +
                ", quantita=" + super.getQuantita() +
                ", prezzoUnitario=" + super.getPrezzoUnitario() +
                ", Pericolo="+ classePericolo+
                '}';
    }
}


