package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

public class Parser {

    public static Employee stringToEmployee(String string){
        return new Employee(string);
    }

    public static Project stringToProject(String string){
        return new Project(string);
    }

    public static Activity stringToActivity(String string){
        return new Activity(string);
    }

    public static Week stringsToWeek(String[] args){
        int weekNum = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        return new Week(weekNum, year);
    }

}
