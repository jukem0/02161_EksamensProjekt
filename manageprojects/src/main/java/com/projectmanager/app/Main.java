package com.projectmanager.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.projectmanager.model.Employee;
import com.projectmanager.services.DataAccessLayer;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) {
        InitializeEmployees.initializeEmployees();
        for (int i = 0; i < InitializeEmployees.employees.size(); i++) {
            System.out.println(InitializeEmployees.employees.get(i).getEmployeeName());
        }
=======
    static DataAccessLayer data = new DataAccessLayer();
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Employee> employees = data.parseToEmployee("manageprojects\\src\\main\\java\\com\\projectmanager\\HR\\Employees.txt");
        for (Employee e : employees) {
            System.out.println(e.getEmployeeName());
        }
        
>>>>>>> 5eb79303fbd074f4a5c53bfd757871e0aec10094
    }
}
