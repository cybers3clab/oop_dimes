package oop.documents;

import java.io.IOException;
import java.util.Scanner;

public class GestioneDocumenti {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Report[] ListaReport;
        Lettera[] ListaLettere;

        String prompt= """
                Gestione Documenti effettua una scelta per continuare:
                0) Vedi docs
                1) Crea un report
                2) Crea Una Lettera
                3) Invia un report 
                4) Invia una lettera
                5)
                """;
        System.out.println(prompt);
        int scelta=-1;
        scelta=scanner.nextInt();
        while (scelta >=0){
            switch (scelta){
                case 0:
                    System.out.println("Lista Report");

                    break;
                case 1:
                    System.out.println("Inserisci il proprietario del report:");
                    break;


            }
            System.out.println(prompt);
            scelta=scanner.nextInt();
        }
        System.out.println("Bye");
    }
}
