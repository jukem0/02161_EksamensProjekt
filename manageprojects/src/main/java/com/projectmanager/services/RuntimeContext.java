package com.projectmanager.services;

import java.util.ArrayList;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public class RuntimeContext {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Project> projects = new ArrayList<>();
    private static ArrayList<Activity> activities = new ArrayList<>();

    private static RuntimeContext context_instance = null;

    public static synchronized RuntimeContext getInstance(){
        if (context_instance == null) {
            context_instance = new RuntimeContext();
        }

        return context_instance;
    }
    
    public static ArrayList<Employee> getEmployees(){
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> inputEmployees){
        for (Employee e : inputEmployees) {
            employees.add(e);
        }
    }
    
    public static ArrayList<Project> getProjects(){
        return projects;
    }

    public static void setProjects(ArrayList<Project> inputProjects){
        for (Project p : inputProjects) {
            projects.add(p);
        }
    }

    public static ArrayList<Activity> getActivities(){
        return activities;
    }

    public static void setActivities(ArrayList<Activity> inputActivities){
        for (Activity a : inputActivities) {
            activities.add(a);
        }
    }
}
