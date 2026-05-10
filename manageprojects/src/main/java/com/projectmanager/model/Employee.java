package com.projectmanager.model;

public class Employee {
    private String initialer;
    private String leaderOf;
    // Maybe add in ID?
    // I'm p sure no ID is needed since their initials should be unique
    //800 people are called Sara Jensen

    public Employee(String ini) {
        this.initialer = ini;
        leaderOf = null;
    }

    public void assignProjectleader(String projectNr, Employee employee) {
        this.leaderOf = projectNr;
    }

    public void becomeLeaderOf(String projectNr) {
        this.leaderOf = projectNr;
    }

    public String leaderOf() {
        return leaderOf;
    }
    public void addProject(String projectname, Project project){
        projectlist.add(project = new Project(projectname));
    }

    public String getEmployeeName() {
        return initialer;
    }

    public boolean isAvailable(){
        return (leaderOf == null);
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
