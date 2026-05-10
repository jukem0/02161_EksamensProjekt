package com.projectmanager.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.projectmanager.model.Employee;

public class DataAccessLayer {

    public ArrayList<Employee> parseToEmployee(File fileToParse) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileToParse);
        ArrayList<Employee> returnVal = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Employee tempEmployee = new Employee(scanner.nextLine());
            returnVal.add(tempEmployee);
        }
        scanner.close();
        return returnVal;
    }

    public ArrayList<Employee> parseToEmployee(String fileToParseString) throws FileNotFoundException {
        File fileToParse = new File(fileToParseString);
        return parseToEmployee(fileToParse);
    }

    public void writeToDatabase(String fileName, String input) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(input);
        writer.close();
    }

    public void writeToDatabase(String fileName, List<String> inputs) throws IOException {
        for (String s : inputs) {
            writeToDatabase(fileName, s);
        }
    }
}
