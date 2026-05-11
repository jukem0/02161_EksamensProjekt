package com.projectmanager.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import com.projectmanager.commands.Command;
import com.projectmanager.commands.CommandRegistry;
import com.projectmanager.commands.CreateProjectCommand;
import com.projectmanager.commands.HelpCommand;
import com.projectmanager.services.DataAccessLayer;
import com.projectmanager.services.RuntimeContext;
import com.projectmanager.model.*;

public class Main {
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataAccessLayer data = new DataAccessLayer();
        RuntimeContext curContext = new RuntimeContext();
        curContext.setEmployees(data.parseToEmployee("manageprojects\\src\\main\\java\\com\\projectmanager\\HR\\Employees.txt"));
        CommandRegistry registry = new CommandRegistry(List.of(
            new HelpCommand(),
            new CreateProjectCommand(curContext)
        ));

        Scanner commandInput = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("===   Project Manager Terminal     ===");
        System.out.println("======================================");
        Employee loggedInUser = null;

        while (loggedInUser == null) {
            System.out.print("\nIndtast dit brugernavn for at logge ind: ");
            String inputName = commandInput.nextLine().trim();

            for (Employee m : curContext.getEmployees()) {
                if (m.getEmployeeName().equalsIgnoreCase(inputName)) {
                    loggedInUser = m;
                    break;
                }
            }
            if (loggedInUser != null) {
                System.out.println("Login succesfuldt! Velkommen til systemet, " + loggedInUser.getEmployeeName() + ".");
            } else {
                System.out.println("Fejl: Brugernavnet '" + inputName + "' findes ikke i systemet. Prøv igen.");
            }
        }
        
        while (true) {
            String[] commandParts = commandInput.nextLine().split("[s]");
            String commandName = commandParts[0];
            Command command = registry.findCommand(commandName);

            if (command == null) {
                System.out.println("Command " + commandName + " not found");
                continue;
            }

            String[] commandArgs = Arrays.copyOfRange(commandParts, 1, commandParts.length);
            command.execute(commandArgs);
            
            System.out.println("\n--- Hovedmenu ---");
            System.out.println("1. Se eksisterende projekter");
            System.out.println("2. Opret projekt");
            System.out.println("3. Se ledige medarbejdere");
            System.out.println("4. Log ud");
            System.out.print("Vælg en mulighed: ");


            switch (commandName) {
                case "1":
                    if (allprojects.isEmpty()) {
                        System.out.println("Der er i øjeblikket ingen projekter i systemet.");
                    } else {
                        System.out.println("\n--- Eksisterende Projekter ---");
                        for (Project p : allprojects) {
                            System.out.println(
                                    "- Projektnummer: " + p.getProjectNr() + " (Navn: " + p.getName() + ")");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Indtast navn på det nye projekt: ");
                    String projectname = commandInput.nextLine().trim();

                    boolean exists = false;
                    for (Project p : allprojects) {
                        if (p.getName() != null && p.getName().equalsIgnoreCase(projectname)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Fejl: Et projekt med dette navn findes allerede.");
                    } else {
                        Project nytProjekt = new Project(projectname);
                        nytProjekt.setProjectNr(String.valueOf(1000 + allprojects.size()));
                        allprojects.add(nytProjekt);
                        System.out.println("Projekt '" + projectname + "' oprettet med succes!");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Ledige Medarbejdere ---");
                    if (systemMedarbejdere.isEmpty()) {
                        System.out.println("Ingen medarbejdere i systemet.");
                    } else {
                        for (Employee m : systemMedarbejdere) {
                            System.out.println("- " + m.getEmployeeName() + " (Ledig)");
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
        
    }
       
}   

