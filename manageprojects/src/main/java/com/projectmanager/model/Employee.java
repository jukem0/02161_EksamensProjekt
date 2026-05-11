package com.projectmanager.model;

public class Employee {
    private String initialer, leaderOf;
    // Maybe add in ID?
    // I'm p sure no ID is needed since their initials should be unique
    // 700 people are called Sara(h) Jensen

    public Employee(String ini) {
        this.initialer = ini.replace("\"", ""); 
        leaderOf = null;
    }

    public static void assignProjectleader(String projectNr, Employee employee) {
        employee.leaderOf = projectNr;
    }

    public void becomeLeaderOf(String projectNr) {
        this.leaderOf = projectNr;
    }

    public String leaderOf() {
        return leaderOf;
    }

    public String getEmployeeName() {
        return initialer;
    }

    public boolean isAvailable(){
        //return (leaderOf == null);
        return true; // antager lige at det altid er rigtigt.
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return java.util.Objects.equals(initialer, other.initialer) &&
               java.util.Objects.equals(leaderOf, other.leaderOf);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(initialer, leaderOf);
    }

}
