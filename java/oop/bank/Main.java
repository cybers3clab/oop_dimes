package oop.bank;

public class Main {
    public static void main(String[] args) {
        User u=null;
        try {
           u = new User("U1", "Pino", "Rossi");
        }
        catch (InvalidUserIdException e){
            System.out.println("Errore nella gestione utente");
        }
        catch (Exception e){
            System.out.println("Errore generico");
        }
        if(u == null){
            throw new RuntimeException("utente Nullo");

        }
        ContoCorrente cc= new ContoCorrente(u);
        try {
            cc.preleva(1000.0);
        } catch (SaldoInsufficente e) {
            System.out.println("non hai soldi");
        } catch (NegativeFund e) {
            System.out.println("Non mettere numeri negativi");
        }
    }
}
