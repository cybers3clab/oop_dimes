package oop.bank;

public abstract class AbstractBankingAccount implements BankOperations{
    User proprietario;

    public AbstractBankingAccount(User proprietario) {
        this.proprietario = proprietario;
    }

    public User getProprietario() {
        return proprietario;
    }
}
