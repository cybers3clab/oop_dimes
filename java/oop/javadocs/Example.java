package oop.javadocs;

/**
 * Classe che rappresenta un semplice contatore.
 *
 * Questa classe fornisce metodi per incrementare, decrementare e
 * ottenere il valore attuale del contatore.
 *
 * @author Francesco Pironti
 * @version 1.0
 */

public class Example {
    /**
    * Costruttore che accetta valore con cui inizializzare il contatore
     * @param valore il valore da cui parte il contatore
     * @exception IllegalArgumentException nel caso in cui il valore sia negativo.
     * */
    public Example(int valore) {
        if(valore <0){
            throw new IllegalArgumentException("Valore negativo");
        }
        this.valore = valore;
    }

    /**
     * Costruttore di Default
     * Valore = 0.
     */
    public Example() {
        this.valore = 0;
    }

    private int valore;

    /**
     * Incrementa il valore del contatore di 1.
     */
    public void incrementa() {
        valore++;
    }

    /**
     * Incrementa il valore del contatore di val.
     * @param val   Il valore che verrà aggiunto al contatore, not null
     */
    public void incrementaVal(int val) {
        valore+=val;
    }

    /**
     * Decrementa il valore del contatore di 1.
     */
    public void decrementa() {
        valore--;
    }

    /**
     * Restituisce il valore attuale del contatore.
     *
     * @return il valore attuale
     */
    public int ottieniValore() {
        return valore;
    }
    /**
     * Restituisce il valore attuale del contatore.
     * @deprecated
     * @return il valore attuale
     */
    public int getValore() {
        return valore;
    }
}