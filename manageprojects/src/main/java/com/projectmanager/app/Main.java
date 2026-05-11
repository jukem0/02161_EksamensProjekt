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

public class Main {
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataAccessLayer data = new DataAccessLayer();
        RuntimeContext.setEmployees(data.parseToEmployee("manageprojects\\src\\main\\java\\com\\projectmanager\\HR\\Employees.txt"));
        CommandRegistry registry = new CommandRegistry(List.of(
            new HelpCommand(),
            new CreateProjectCommand()
        ));

        Scanner commandInput = new Scanner(System.in);


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
        }
    }
}
