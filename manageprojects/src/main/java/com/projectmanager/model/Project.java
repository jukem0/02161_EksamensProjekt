package com.projectmanager.model;

import java.time.Year;
import java.util.*;

public class Project {
    private String projectName;
    private Employee projectLeader;
    private ArrayList<Activity> activities = new ArrayList<>();

    private Map<Employee, List<Activity>> medarbejderAktiviteter = new HashMap<>();

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(String projectName, Employee projectLeader) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
    }

<<<<<<< HEAD
    public String getName(){
        return projectName;
    }
=======
    public boolean isEmployeeInProject(String employee) {
        for (Employee i : employeeActivity.keySet()){
            if (i.getName().equals(employee)) {
                return true;
            }
        }

        return false;
    }

    public boolean isActivityInProject(String activityName) {
        for (Activity l : activities) {
            if (l.getName().equalsIgnoreCase(activityName)){
                currentActivity = l;
                return true;
            }
        }
        return false;
    }



>>>>>>> a202982ed00b705a3df04b12a6c00e65366552b9
}