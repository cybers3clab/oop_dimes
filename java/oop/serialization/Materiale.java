package oop.serialization;

import java.io.Serializable;

// Classe Materiale
class Materiale implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int quantita;
    private double prezzoUnitario;

    public Materiale(String nome, int quantita, double prezzoUnitario) {
        this.nome = nome;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    @Override
    public String toString() {
        return "Materiale{" +
                "nome='" + nome + '\'' +
                ", quantita=" + quantita +
                ", prezzoUnitario=" + prezzoUnitario +
                '}';
    }
}