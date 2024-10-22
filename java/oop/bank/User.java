package oop.bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    private String codice;
    private String nome;
    private String cognome;
    private List<AbstractBankingAccount> ListaContiCorrenti;

    public User(String codice, String nome, String cognome) throws InvalidUserIdException {
        if(codice.charAt(0) != 'U'){
            throw new InvalidUserIdException("Non inizia per U");
        }
        try {
            if(Integer.valueOf(codice.replace('U', ' '))>=0){
               throw new Exception();
            }

        }
        catch (Exception e ){
            throw new InvalidUserIdException("");
        }
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.ListaContiCorrenti = new ArrayList<AbstractBankingAccount>();
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public List<AbstractBankingAccount> getListaContiCorrenti() {
        return ListaContiCorrenti;
    }
    public void addConto(AbstractBankingAccount conto){
        if(this.ListaContiCorrenti.contains(conto)){
            throw new RuntimeException();
        }
        this.ListaContiCorrenti.add(conto);
    }
}
