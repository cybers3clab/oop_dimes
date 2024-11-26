package oop.biblio;

import java.io.*;
import java.util.*;

public class BibliotecaSalva {

    // File per la persistenza dei dati
    private static final String FILE_LIBRI_DISPONIBILI = "libriDisponibili.txt";
    private static final String FILE_LIBRI_PRESTATI = "libriPrestati.txt";
    private static final String FILE_CODA_LETTORI = "codaLettori.txt";

    public static void main(String[] args) {
        // Collezioni principali
        List<String> libriDisponibili = caricaDati(FILE_LIBRI_DISPONIBILI);
        Set<String> libriPrestati = new HashSet<>(caricaDati(FILE_LIBRI_PRESTATI));
        Queue<String> codaLettori = new LinkedList<>(caricaDati(FILE_CODA_LETTORI));

        Scanner scanner = new Scanner(System.in);
        boolean esegui = true;

        while (esegui) {
            System.out.println("\nMenu Biblioteca:");
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Mostra tutti i libri disponibili");
            System.out.println("3. Presta un libro");
            System.out.println("4. Aggiungi lettore in coda per un libro");
            System.out.println("5. Visualizza coda di attesa");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il titolo del libro: ");
                    String titolo = scanner.nextLine();
                    libriDisponibili.add(titolo);
                    salvaDati(FILE_LIBRI_DISPONIBILI, libriDisponibili);
                    System.out.println("Libro aggiunto!");
                    break;

                case 2:
                    System.out.println("Libri disponibili: " + libriDisponibili);
                    break;

                case 3:
                    System.out.print("Inserisci il titolo del libro da prestare: ");
                    String libroPrestare = scanner.nextLine();
                    if (libriDisponibili.contains(libroPrestare)) {
                        libriDisponibili.remove(libroPrestare);
                        libriPrestati.add(libroPrestare);
                        salvaDati(FILE_LIBRI_DISPONIBILI, libriDisponibili);
                        salvaDati(FILE_LIBRI_PRESTATI, libriPrestati);
                        System.out.println("Libro prestato!");
                    } else {
                        System.out.println("Il libro non è disponibile.");
                    }
                    break;

                case 4:
                    System.out.print("Inserisci il nome del lettore: ");
                    String lettore = scanner.nextLine();
                    System.out.print("Inserisci il titolo del libro richiesto: ");
                    String libroRichiesto = scanner.nextLine();
                    codaLettori.add(lettore + " - " + libroRichiesto);
                    salvaDati(FILE_CODA_LETTORI, codaLettori);
                    System.out.println("Lettore aggiunto in coda!");
                    break;

                case 5:
                    System.out.println("Coda lettori: " + codaLettori);
                    break;

                case 6:
                    esegui = false;
                    System.out.println("Uscita dal programma. Arrivederci!");
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }

        scanner.close();
    }

    // Metodo per caricare i dati da un file
    private static List<String> caricaDati(String fileName) {
        List<String> dati = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                dati.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Errore nel caricamento del file " + fileName + ": " + e.getMessage());
        }
        return dati;
    }

    // Metodo per salvare i dati su un file
    private static void salvaDati(String fileName, Collection<String> dati) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String dato : dati) {
                writer.write(dato);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio del file " + fileName + ": " + e.getMessage());
        }
    }
}
