package com.projectmanager.model;

import java.util.ArrayList;

public class Project {
    private String projectName;
    private Employee projectLeader;
    private ArrayList<Activity> activities = new ArrayList<>();

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(String projectName, Employee projectLeader) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
    }

    public String getName(){
        return projectName;
    }
}