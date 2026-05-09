package com.projectmanager.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.projectmanager.model.Employee;

public class InitializeEmployees {
    public static ArrayList<Employee> employees = new ArrayList<>();
    File employeeInitialsFile = new File("../HR/Employees.txt");
    public void initializeEmployees() {
        try (Scanner fileReader = new Scanner(employeeInitialsFile)) {
            while (fileReader.hasNextLine()) {
                String employeeInitials = fileReader.nextLine();
                Employee emp = new Employee(employeeInitials);
                employees.add(emp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}