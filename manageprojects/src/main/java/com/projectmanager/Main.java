package com.projectmanager;

import java.util.Scanner;

public class Main {
    private Medarbejder bruger = new Medarbejder();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Skriv dine initialer for at logge ind: ");
        
    }

    public void login(String ini) {
        if (bruger.getName().equals("huba")) {
            System.out.println("Du er logget ind som " + bruger.getName());
        } else {
            System.out.println(bruger.getName() + " er ikke genkendt.");
        }
    }
}
