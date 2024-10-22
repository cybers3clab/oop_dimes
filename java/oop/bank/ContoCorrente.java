package oop.bank;

public class ContoCorrente extends AbstractBankingAccount {
    private double saldo=0.0;

    public ContoCorrente(User proprietario) {
        super(proprietario);
    }

    @Override
    public boolean deposita(double val) throws NegativeFund {
        if(val < 0){
            throw new NegativeFund("Val minore di 0");
        }
        this.saldo+=val;
        return true;
    }

    @Override
    public boolean preleva(double val) throws NegativeFund {
        if(val < 0){
            throw new NegativeFund("Val minore di 0");
        }
        if(val>saldo){
            throw new SaldoInsufficente("POVERO");
        }
        this.saldo=this.saldo-val;
        return true;
    }

    @Override
    public double saldo() {
        return this.saldo;
    }

    @Override
    public int compareTo(BankOperations o) {
        return Double.compare(this.saldo,o.saldo());
        /*if(this.saldo > o.saldo())
            return 1;
        else if (this.saldo<o.saldo()) {
            return -1;
        }
        return 0;*/
    }
}
