package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

public class Parser {
    RuntimeContext context;

    public Parser(RuntimeContext context) {
        this.context = context;
    }

    public Employee stringToEmployee(String string){
        for (Employee e : context.getEmployees()) {
            if (e.getEmployeeName().equalsIgnoreCase(string)) {
                return e;
            }
        }
        return null;
    }

    public Project stringToProject(String string){
        for (Project p : context.getProjects()) {
            if (p.getName().equalsIgnoreCase(string)) {
                return p;
            }
        }
        return null;
    }

    public Activity stringToActivity(String string){
        
    }

    public Week stringsToWeek(String[] args){
        int weekNum = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        return new Week(weekNum, year);
    }
}
