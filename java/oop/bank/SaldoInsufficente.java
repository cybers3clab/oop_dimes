package oop.bank;

public class SaldoInsufficente extends RuntimeException {
    public SaldoInsufficente(String message) {
        super(message);
    }
}
