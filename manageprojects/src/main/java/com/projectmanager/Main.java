package com.projectmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv dine initialer for at logge ind: ");
        String initialer;
        initialer = scanner.next();
        
        if (initialer.equals("huba")) {
            System.out.println("Du er logget ind som " + initialer);
        } else {
            System.out.println("Forkerte initialer blev brugt.");
        }
        scanner.close();
    }
}
