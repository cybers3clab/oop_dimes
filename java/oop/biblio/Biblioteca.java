package oop.biblio;

import java.util.*;

class Biblioteca {
    private List<Libro> catalogo; // Utilizziamo una List per il catalogo
    private Map<Libro, String> prestiti; // Utilizziamo una Map per gestire i prestiti

    public Biblioteca() {
        catalogo = new LinkedList<>();
        prestiti = new HashMap<>();
    }

    public void aggiungiLibro(Libro libro) {
        catalogo.add(libro);
        System.out.println("Libro aggiunto: " + libro);
    }

    public List<Libro> cercaLibro(String titolo, String autore) {
        List<Libro> risultati = new ArrayList<>();
        for (Libro libro : catalogo) {
            if ((titolo != null && libro.getTitolo().toLowerCase()
                    .contains(titolo.toLowerCase())) ||
                    (autore != null && libro.getAutore().toLowerCase()
                            .contains(autore.toLowerCase()))) {
                risultati.add(libro);
            }
        }
        return risultati;
    }

    public void ordinaCatalogoPerTitolo() {
        catalogo.sort((l1, l2) -> l1.getTitolo()
                .compareToIgnoreCase(l2.getTitolo()));
        System.out.println("Catalogo ordinato per titolo.");
    }

    public void ordinaCatalogoPerAnno() {
        catalogo.sort((l1, l2) -> Integer
                .compare(l2.getAnnoPubblicazione(), l1.getAnnoPubblicazione())); // Ordinamento decrescente
        System.out.println("Catalogo ordinato per anno di pubblicazione.");
    }

    public void visualizzaCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("Il catalogo è vuoto.");
            return;
        }
        for (Libro libro : catalogo) {
            System.out.println(libro);
        }
    }

    public void prestaLibro(Libro libro, String persona) {
        if (libro.isDisponibile()) {
            libro.setDisponibile(false);
            prestiti.put(libro, persona);
            System.out.println("Libro prestato: " + libro + " a " + persona);
        } else {
            System.out.println("Il libro '" + libro.getTitolo() + "' non è disponibile.");
        }
    }

    public void restituisciLibro(Libro libro) {
        if (prestiti.containsKey(libro)) {
            libro.setDisponibile(true);
            prestiti.remove(libro);
            System.out.println("Libro restituito: " + libro);
        } else {
            System.out.println("Il libro '" + libro.getTitolo() + "' non era stato prestato.");
        }
    }
}