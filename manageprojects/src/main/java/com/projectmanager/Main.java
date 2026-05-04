package com.projectmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Laver "kendte" medarbejdere
        List<Medarbejder> systemMedarbejdere = new ArrayList<>();
        systemMedarbejdere.add(new Medarbejder("huba"));
        systemMedarbejdere.add(new Medarbejder("ambe"));
        systemMedarbejdere.add(new Medarbejder("joni"));

        System.out.println("======================================");
        System.out.println("===   Project Manager Terminal     ===");
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

        // Fremtidig logik her!

        scanner.close();
    }
}
