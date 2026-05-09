package com.projectmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Medarbejder> systemMedarbejdere = new ArrayList<>();
    public static List<Projekt> systemProjekter = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    /*
     * ================ fælles metoder, variabler og fields til stepdefinitions
     * =============================
     */
    public record ProjektlederStat(boolean erProjektLeder, String projektnavn) {
    }

    public static boolean findMedarbejder(String medarbejder) {
        return systemMedarbejdere.stream().anyMatch(m -> m.getName().equalsIgnoreCase(medarbejder));
    }

    public static ProjektlederStat erProjektleder(String projektnavn, String medarbejder) {
        if (systemProjekter.stream().anyMatch(p -> p.getProjektNavn().equalsIgnoreCase(projektnavn) && p.getProjektLeder() != null && p.getProjektLeder().getName().equalsIgnoreCase(medarbejder))) {
            return new ProjektlederStat(true, projektnavn);
        } else if (systemProjekter.stream().anyMatch(p -> p.getProjektLeder() != null && p.getProjektLeder().getName().equalsIgnoreCase(medarbejder))) {
            String lederProjekt = systemProjekter.stream().filter(p -> p.getProjektLeder() != null && p.getProjektLeder().getName().equalsIgnoreCase(medarbejder)).findFirst().get().getProjektNavn();
            return new ProjektlederStat(false, lederProjekt);
        } else {
            return new ProjektlederStat(false, null);
        }
    }

    public static boolean erLedig(String medarbejder) {
        // TODO: Implementer logik for tjek om medarbejder er ledig
        // beregn om medarbejderen er ledig baseret på deres nuværende opgaver og
        // projekter, hvor projekter og aktiviteter har forskellig vægt
        return true;
    }
    /*
     * =============================================================================
     * ==========================
     */

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
        boolean isRunning = true;

        while (isRunning){
            
            System.out.println("angiv arbejdes timer på "+ loggedInUser + "eller tast other");
            String choose = scanner.nextLine().trim();

        }

       scanner.close();
    }

    public static Double TryParseDouble(String someText) { 
        try {
            return Double.parseDouble(someText);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private static void addHours (Projekt projekt, Aktivitet aktivitet, Double timer){
        //TODO implementation ?????????????????????????????????????????????????????????????????????????????????????????

    }

    private static boolean erProjektLeder(Medarbejder user){ //placeholder====================================

        return true;
    }

    private static void nytProjekt(String navn, Uge startUge, Uge slutuge, List<Aktivitet> aktiviteter, List<Medarbejder> medarbejder){
        //placeholder========================================================
    }


    public static List<Projekt> getProjekter() {
        return systemProjekter;
    }

    public static List<Medarbejder> getMedarbejdere() {
        return systemMedarbejdere;
    }
}
