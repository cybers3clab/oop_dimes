package oop.cipher;

import java.io.*;


public class CodificaCesare {

    public static void main(String[] args) {
        // Controllo degli argomenti da linea di comando
        if (args.length != 3) {
            System.out.println("Uso: java CodificaCesare <-e|-d> <file_input> <file_output>");
            return;
        }

        // Lettura delle flag e dei file
        String mode = args[0];
        String inputFilePath = args[1];
        String outputFilePath = args[2];
        int shift = 3; // Spostamento fisso per la codifica di Cesare

        // Verifica della modalità (codifica o decodifica)
        if ("-e".equals(mode)) {
            System.out.println("Modalità: Cifratura");
        } else if ("-d".equals(mode)) {
            System.out.println("Modalità: Decifratura");
            shift = -shift; // Inverti lo spostamento per decifrare
        } else {
            System.out.println("Errore: usa -e per cifrare o -d per decifrare.");
            System.exit(-1);
        }

        BufferedWriter bw = null;
        BufferedReader br= null;
        try {
            // Legge il contenuto del file
            br = new BufferedReader(new FileReader(inputFilePath));
            bw = new BufferedWriter(new FileWriter(outputFilePath));

            // Applica la codifica o decodifica di Cesare
            String s=br.readLine();
            while(s != null) {
                String processedContent = cesareTransform(s, shift);

                // Scrive il testo elaborato in un nuovo file
                bw.write(processedContent);
                bw.newLine();
                s=br.readLine();
            }
            System.out.println("Operazione completata. File salvato in: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Errore durante la lettura o la scrittura del file: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Errore nella chiusura");
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Errore nella chiusura");
            }
        }
    }

    // Metodo per trasformare il testo con la codifica/decodifica di Cesare
    private static String cesareTransform(String text, int shift) {
        StringBuilder transformed = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                transformed.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                // I caratteri non alfabetici rimangono invariati
                transformed.append(c);
            }
        }

        return transformed.toString();
    }
}


