package com.projectmanager.model;

import java.time.Year;
import java.util.*;

public class Project {
    private String projectName;
    private double regTime;
    private Employee projectLeader;
    private ArrayList<Activity> activities = new ArrayList<>();


    private Map<Employee, Double> employeeRegtime = new HashMap<>();

    private Map<Activity, Map<Employee, Double>> activityMap = new HashMap<>();

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(String projectName, Employee projectLeader) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
    }

    public boolean isEmployeeInProject(String employee) {
        for (Employee i : employeeRegtime.keySet()){
            if (i.getName().equals(employee)) {
                return true;
            }
        }

        return false;
    }

    public boolean isActivityInProject(String activityName) {
        for (Activity l : activityMap.keySet()) {
            if (l.getName().equalsIgnoreCase(activityName)){
                return true;
            }
        }
        return false;
    }

    public String getYear() {
        return Year.now().;
    }



}