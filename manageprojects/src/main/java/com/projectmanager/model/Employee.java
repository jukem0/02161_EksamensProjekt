package com.projectmanager.model;

public class Employee {
    private String initialer;
    private Project leaderOf;

    public Employee(String ini) {
        this.initialer = ini;
    }

    public void assignProjectleader(Project projectNr, Employee employee) {
        leaderOf = projectNr;
    }

    


}
