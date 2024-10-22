package oop.bank;

public class Utente implements Comparable<Utente>{
    String cod;
    String nome;
    String Cognome;
    BankOperations Conto;

    public Utente(String cod, String nome, String cognome, BankOperations conto) throws Exception {
        if (cod.charAt(0)!='U'){
            throw new Exception();
        }
        this.cod = cod;
        this.nome = nome;
        Cognome = cognome;
        Conto = conto;
    }

    public String getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public BankOperations getConto() {
        return Conto;
    }

    @Override
    public int compareTo(Utente o) {
        return 0;
    }
}
