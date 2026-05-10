package com.projectmanager.model;

public class Employee {
    private String initialer;
    private Project leaderOf = null;
    //Maybe add in ID?

    public Employee(String ini) {
        this.initialer = ini;
    }

    public void assignProjectleader(Project projectNr, Employee employee) {
        leaderOf = projectNr;
    }

    public Project leaderOf() {
        return leaderOf;
    }

    public String getEmployeeName() {
        return initialer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Employee other = (Employee) obj;

        return (getEmployeeName().equals(other.getEmployeeName()) && leaderOf().equals(other.leaderOf()));
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(initialer, leaderOf);
    }
    
    

}
