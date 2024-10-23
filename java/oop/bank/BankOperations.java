package oop.bank;

public interface
BankOperations extends Comparable<BankOperations>{
    boolean deposita(double val) throws NegativeFund;
    boolean preleva(double val) throws NegativeFund, SaldoInsufficente;
    double saldo();

    //int compareTo(BankOperations o);
}
