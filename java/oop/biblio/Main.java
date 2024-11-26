package oop.biblio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Creazione dei libri
        Libro libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "Fantasy", 1954);
        Libro libro2 = new Libro("Dune", "Frank Herbert", "Sci-Fi", 1965);
        Libro libro3 = new Libro("1984", "George Orwell", "Distopia", 1949);

        // Aggiungi libri alla biblioteca
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);

        // Visualizza il catalogo
        System.out.println("\nCatalogo completo:");
        biblioteca.visualizzaCatalogo();

        // Cerca un libro per titolo
        System.out.println("\nCerca per titolo 'Dune':");
        List<Libro> risultati = biblioteca.cercaLibro("Dune", null);
        for (Libro libro : risultati) {
            System.out.println(libro);
        }

        // Ordina i libri per titolo
        biblioteca.ordinaCatalogoPerTitolo();
        System.out.println("\nCatalogo dopo ordinamento per titolo:");
        biblioteca.visualizzaCatalogo();

        // Ordina i libri per anno di pubblicazione
        biblioteca.ordinaCatalogoPerAnno();
        System.out.println("\nCatalogo dopo ordinamento per anno:");
        biblioteca.visualizzaCatalogo();

        // Presta un libro
        biblioteca.prestaLibro(libro1, "Mario Rossi");
        // Visualizza il catalogo dopo il prestito
        System.out.println("\nCatalogo dopo il prestito:");
        biblioteca.visualizzaCatalogo();

        // Restituisci un libro
        biblioteca.restituisciLibro(libro1);

        // Visualizza il catalogo dopo la restituzione
        System.out.println("\nCatalogo dopo la restituzione:");
        biblioteca.visualizzaCatalogo();
    }
}