package com.projectmanager.services;

import java.util.ArrayList;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;


//Lavet af Gustav
public class RuntimeContext {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Project> projects = new ArrayList<>();
    private static Activity lastCreatedActivity;
    private static Project lastUsedProject;
    private static String errorMsg = "";

    private static Employee loggedInEmployee;

    private static RuntimeContext context_instance = null;

    public static synchronized RuntimeContext getInstance(){
        if (context_instance == null) {
            context_instance = new RuntimeContext();
        }

        return context_instance;
    }
    
    public static String getErrorMsg() {
        return errorMsg;
    }

    public static void setErrorMsg(String msg) {
        errorMsg = msg;
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

    public static void addProject(Project project){
        projects.add(project);
    }

    public static ArrayList<Activity> getActivities(Project project){
        int index = -1;
        for (int x = 0; x < projects.size() ; x++) {
            if (projects.get(x).equals(project)) {
                index = x;
            }
        }
        if (index != -1) {
            return new ArrayList<Activity>(projects.get(index).getActivityMap().keySet());
        }
        return null;
    }

    public static void setActivities(Project project, ArrayList<Activity> inputActivities){
        for (Project p : projects) {
            if(p.equals(project)) {
                for (Activity a : inputActivities) {
                    p.addActivity(a.getActivityName());
                }
            }
        }
    }

    public static Activity getLastCreatedActivity() {
        return lastCreatedActivity;
    }

    public static void setLastCreatedActivity(Activity activity) {
        lastCreatedActivity = activity;
    }

    public static Project getLastUsedProject() {
        return lastUsedProject;
    }

    public static void setLastUsedProject(Project project) {
        lastUsedProject = project;
    }

    public static void reset() {
        employees.clear();
        projects.clear();
        lastCreatedActivity = null;
        lastUsedProject = null;
        errorMsg = "";
    }

    public static void setLoggedInEmployye(Employee employee){
        loggedInEmployee = employee;
    }

    public static Employee getLoggedInEmployee(){
        return loggedInEmployee;
    }
}
