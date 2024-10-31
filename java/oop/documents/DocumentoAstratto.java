package oop.documents;

public abstract class DocumentoAstratto{
    private final String testo;
    private final String proprietario;
    private final String nomeFirma;
    private final int codice;

    public DocumentoAstratto(String testo, String proprietario, String nomeFirma, int codice) {
        this.testo = testo;
        this.proprietario = proprietario;
        this.nomeFirma = nomeFirma;
        this.codice = codice;
    }

    public DocumentoAstratto(String testo, String proprietario) {
        this.testo = testo;
        this.proprietario = proprietario;
        this.nomeFirma=null;
        this.codice=-1;
    }

    protected abstract boolean checkSign();

    public abstract void invia();

    public boolean isInviabile(){
        return checkSign();
    }

    public String getProprietario() {
        return proprietario;
    }

    public boolean isSigned(){
        return !this.nomeFirma.equals("");
    }

    public String getTesto(){
        return this.testo;
    }

    protected int getCodice(){
        return codice;

    }

    protected String getNomeFirma(){
        return nomeFirma;
    }
}
