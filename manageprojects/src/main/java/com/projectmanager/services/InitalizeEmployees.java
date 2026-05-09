package com.projectmanager.services;

import java.util.*;
import java.io.*;

import com.projectmanager.model.Employee;

public class InitalizeEmployees {
    File employeeInitialsFile = new File("../HR/Employees.txt");

    try (Scanner fileReader = new Scanner(employeeInitialsFile)) {
        while (fileReader.hasNextLine()) {
            String employeeInitials = fileReader.nextLine();
            Employee emp = new Employee(employeeInitials);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}