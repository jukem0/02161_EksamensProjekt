package com.projectmanager.commands;

import com.projectmanager.model.Employee;
import com.projectmanager.services.EmployeesFunctions;

public class AddEmployeeCommand extends Command {

    @Override
    public String getName() {
        return "add_employee";
    }

    @Override
    public void execute(String[] args) {
        // Expected format: add_employee <initialer>
        if (args.length >= 1) {
            String initialer = args[0];
            Employee employee = new Employee(initialer);
            EmployeesFunctions.addEmployee(employee);
            System.out.println("Medarbejder '" + initialer + "' tilføjet til systemet.");
        } else {
            System.out.println("Fejl: Mangler initialer. Format: add_employee <initialer>");
        }
    }
}
