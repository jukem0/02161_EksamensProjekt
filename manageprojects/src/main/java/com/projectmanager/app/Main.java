package com.projectmanager.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.projectmanager.model.Employee;
import com.projectmanager.services.DataAccessLayer;

public class Main {
    static DataAccessLayer data = new DataAccessLayer();
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Employee> employees = data.parseToEmployee("manageprojects\\src\\main\\java\\com\\projectmanager\\HR\\Employees.txt");
        for (Employee e : employees) {
            System.out.println(e.getEmployeeName());
        }
        
    }
}
