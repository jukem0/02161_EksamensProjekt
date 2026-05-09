package com.projectmanager.app;

import com.projectmanager.services.InitializeEmployees;

public class Main {
    public static void main(String[] args) {
        InitializeEmployees.initializeEmployees();
        for (int i = 0; i < InitializeEmployees.employees.size(); i++) {
            System.out.println(InitializeEmployees.employees.get(i).getEmployeeName());
        }
    }
}
