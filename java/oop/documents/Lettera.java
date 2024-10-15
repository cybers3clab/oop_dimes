package oop.documents;

public class Lettera extends DocumentoAstratto implements StampaDocumento{
    String mittente;
    String destinatario;

    public Lettera(String testo, String proprietario, String nomeFirma, int codice, String mittente, String destinatario) {
        super(testo, proprietario, nomeFirma, codice);
        this.mittente = mittente;
        this.destinatario = destinatario;
    }

    public Lettera(String testo, String proprietario, String mittente, String destinatario) {
        super(testo, proprietario);
        this.mittente = mittente;
        this.destinatario = destinatario;
    }

    @Override
    protected boolean checkSign() {
        return(mittente.equals(super.getNomeFirma()) && super.getCodice()%7==0);
    }

    @Override
    public void invia() {
        System.out.println("Invio a: "+destinatario+"\n\n\n"+super.getTesto()+"\nSinceramente tuo,"+mittente);

    }

    @Override
    public void stampa() {
        System.out.println("DA:"+mittente+ "A: "+destinatario+"\n\n\n"+super.getTesto());
    }

    public String getMittente() {
        return mittente;
    }

    public String getDestinatario() {
        return destinatario;
    }
}
