package oop.bank;

public class ContoRisparmio extends AbstractBankingAccount {
    private double saldo=0.0;

    public ContoRisparmio(User proprietario) {
        super(proprietario);
    }

    @Override
    public boolean deposita(double val) throws Exception {
        if(val < 0){
            throw new Exception();
        }
        this.saldo+=val;
        return true;
    }

    @Override
    public boolean preleva(double val) throws Exception {
        if(val>saldo){
            throw new Exception();
        }
        return false;
    }

    @Override
    public double saldo() {
        return this.saldo;
    }

    public void creaBuono(){
        System.out.println("Buono Creato");
    }

    public void chiudiBuono(){
        System.out.println("Chiudi Buono");
    }

    @Override
    public int compareTo(BankOperations o) {
        if(this.saldo > o.saldo())
            return 1;
        else if (this.saldo<o.saldo()) {
            return -1;
        }
        return 0;
    }
}
