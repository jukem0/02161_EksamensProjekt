package com.projectmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Medarbejder> systemMedarbejdere = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    /* ================ fælles metoder, variabler og fields til stepdefinitions: =============================*/
    public record ProjektlederStat(boolean erProjektLeder, String projektnavn){}

    public static boolean findMedarbejder(String medarbejder) {
        return systemMedarbejdere.stream().anyMatch(m -> m.getName().equalsIgnoreCase(medarbejder));
    }
    
    public static ProjektlederStat erProjektleder(String projektnavn, String medarbejder){
        boolean result = false;
        return new ProjektlederStat(result, projektnavn);
    }
    
    public static boolean erLedig(String medarbejder) {
        // TODO: Implementer logik for tjek om medarbejder er ledig
        return true;
    }
    /*====================================================================================================== */
    public static void main(String[] args) {
        

        // Laver "kendte" medarbejdere
        systemMedarbejdere.add(new Medarbejder("huba"));
        systemMedarbejdere.add(new Medarbejder("wilo"));
        systemMedarbejdere.add(new Medarbejder("anda"));

        System.out.println("======================================");
        System.out.println("===   Projekt Manager Terminal     ===");
        System.out.println("======================================");

        Medarbejder loggedInUser = null;

        while (loggedInUser == null) {
            System.out.print("\nIndtast dit brugernavn for at logge ind: ");
            String inputName = scanner.nextLine().trim();

            for (Medarbejder m : systemMedarbejdere) {
                if (m.getName().equalsIgnoreCase(inputName)) {
                    loggedInUser = m;
                    break;
                }
            }

            if (loggedInUser != null) {
                System.out.println("Login succesfuldt! Velkommen til systemet, " + loggedInUser.getName() + ".");
            } else {
                System.out.println("Fejl: Brugernavnet '" + inputName + "' findes ikke i systemet. Prøv igen.");
            }
        }

        // Hovedmenu for bruger
        List<Projekt> systemProjekter = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Hovedmenu ---");
            System.out.println("1. Se eksisterende projekter");
            System.out.println("2. Opret projekt");
            System.out.println("3. Se ledige medarbejdere");
            System.out.println("4. Log ud");
            System.out.print("Vælg en mulighed: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    if (systemProjekter.isEmpty()) {
                        System.out.println("Der er i øjeblikket ingen projekter i systemet.");
                    } else {
                        System.out.println("\n--- Eksisterende Projekter ---");
                        for (Projekt p : systemProjekter) {
                            System.out.println(
                                    "- Projektnummer: " + p.getProjektNr() + " (Navn: " + p.getProjektNavn() + ")");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Indtast navn på det nye projekt: ");
                    String projektNavn = scanner.nextLine().trim();

                    boolean exists = false;
                    for (Projekt p : systemProjekter) {
                        if (p.getProjektNavn() != null && p.getProjektNavn().equalsIgnoreCase(projektNavn)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Fejl: Et projekt med dette navn findes allerede.");
                    } else {
                        Projekt nytProjekt = new Projekt(projektNavn);
                        nytProjekt.setProjektNr(String.valueOf(1000 + systemProjekter.size()));
                        systemProjekter.add(nytProjekt);
                        System.out.println("Projekt '" + projektNavn + "' oprettet med succes!");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Ledige Medarbejdere ---");
                    if (systemMedarbejdere.isEmpty()) {
                        System.out.println("Ingen medarbejdere i systemet.");
                    } else {
                        for (Medarbejder m : systemMedarbejdere) {
                            System.out.println("- " + m.getName() + " (Ledig)");
                        }
                    }
                    break;

                case "4":
                    System.out.println("Logger ud...");
                    loggedInUser = null;
                    isRunning = false;
                    break;

                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }

        scanner.close();
    }
}
