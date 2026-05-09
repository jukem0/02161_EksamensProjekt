package com.projectmanager.model;


import java.time.Year;
import java.util.*;

public class Project{
    private String projectName;
    private double regTime;
    private Employee projectLeader;
    private ArrayList<Activity> activities = new ArrayList<>();


    public static Map<Employee, Double> employeeRegtime = new HashMap<>();

    public static Map<Activity, Map<Employee, Double>> activityMap = new HashMap<>();

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(String projectName, Employee projectLeader) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
    }

    
    public String getActivityName(String activityName) {
        return String.valueOf(activityMap.keySet().stream().filter(a -> a.getName().equalsIgnoreCase(activityName)).findFirst().orElse(null));
        }

    public String getEmployeeName(String employee){
        return String.valueOf(employeeRegtime.keySet().stream().filter(a -> a.getName().equalsIgnoreCase(employee)).findFirst().orElse(null));
    }

    public String getYear() {
        return Year.now().toString().substring(2);
    }

    public String getName() {
        return projectName;
    }

    


}