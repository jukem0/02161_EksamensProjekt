package com.projectmanager.services;

import java.util.ArrayList;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public class RuntimeContext {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<Activity> activities = new ArrayList<>();
    
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees){
        for (Employee e : employees) {
            this.employees.add(e);
        }
    }
    
    public ArrayList<Project> getProjects(){
        return projects;
    }

    public void setProjects(ArrayList<Project> projects){
        for (Project p : projects) {
            this.projects.add(p);
        }
    }

    public ArrayList<Activity> getActivities(){
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities){
        for (Activity a : activities) {
            this.activities.add(a);
        }
    }
}
