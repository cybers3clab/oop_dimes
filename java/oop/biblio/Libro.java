package oop.biblio;

import java.util.Objects;

class Libro {
    private String titolo;
    private String autore;
    private String genere;
    private int annoPubblicazione;
    private boolean disponibile;

    public Libro(String titolo, String autore, String genere, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.annoPubblicazione = annoPubblicazione;
        this.disponibile = true; // inizialmente il libro è disponibile
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return annoPubblicazione == libro.annoPubblicazione && Objects.equals(titolo, libro.titolo) && Objects.equals(autore, libro.autore) && Objects.equals(genere, libro.genere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, autore, genere, annoPubblicazione);
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", Genere: " + genere + ", Anno: " + annoPubblicazione + ", Disponibile: " + (disponibile ? "Sì" : "No");
    }
}