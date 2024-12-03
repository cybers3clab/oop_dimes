package oop.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe GestioneMagazzino
public class GestioneMagazzino {
    private static final String FILE_PATH = "magazzino.dat";
    private List<Materiale> magazzino;

    public GestioneMagazzino() {
        this.magazzino = caricaMagazzino();
    }


    private List<Materiale> caricaMagazzino() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            return (List<Materiale>) ois.readObject();
        } catch (ClassNotFoundException | IOException e){
            System.out.println("Nessun file trovato o errore durante il caricamento, inizializzo magazzino vuoto.");
            return new ArrayList<>();
        }
        finally {

            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void salvaMagazzino() {
        ObjectOutputStream oos = null;
        try {
            new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(magazzino);
            System.out.println("Magazzino salvato correttamente!");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del magazzino: " + e.getMessage());
        }
        finally {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("Errore in chiusura oos");
            }
        }
    }

    public void aggiungiMateriale(String nome, int quantita, double prezzoUnitario) {
        magazzino.add(new Materiale(nome, quantita, prezzoUnitario));
        System.out.println("Materiale aggiunto con successo!");
    }

    public void visualizzaMagazzino() {
        if (magazzino.isEmpty()) {
            System.out.println("Il magazzino è vuoto.");
        } else {
            for (Materiale materiale : magazzino) {
                System.out.println(materiale);
            }
        }
    }

    public static void main(String[] args) {
        GestioneMagazzino gestioneMagazzino = new GestioneMagazzino();
        Scanner scanner = new Scanner(System.in);

        int scelta;
        do {
            System.out.println("\n--- Menu Gestione Magazzino ---");
            System.out.println("1. Aggiungi Materiale");
            System.out.println("2. Visualizza Magazzino");
            System.out.println("3. Salva Magazzino");
            System.out.println("4. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci nome materiale: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci quantità: ");
                    int quantita = scanner.nextInt();
                    System.out.print("Inserisci prezzo unitario: ");
                    double prezzoUnitario = scanner.nextDouble();
                    gestioneMagazzino.aggiungiMateriale(nome, quantita, prezzoUnitario);
                    break;

                case 2:
                    gestioneMagazzino.visualizzaMagazzino();
                    break;

                case 3:
                    gestioneMagazzino.salvaMagazzino();
                    break;

                case 4:
                    gestioneMagazzino.salvaMagazzino();
                    System.out.println("Uscita dal programma...");
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        } while (scelta != 4);

        scanner.close();
    }
}
