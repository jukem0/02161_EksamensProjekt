package com.projectmanager.services;

import java.util.List;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public class ProjectsFunctions implements IProject {

    @Override
    public String MakeRepport(Project project) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MakeRepport'");
    }

    @Override
    public void addActivity(String activityname, Project project, Employee projectLeader) {
        if (isActivityInProject(activityname) == true){
            throw new IllegalArgumentException("Aktiviteten findes allerede i projektet");
        }
        else {
            if (projectLeader != null && projectLeader.leaderOf() == project) {
                Project.activityMap.put(new Activity(activityname),null);
            }
            else if(projectLeader == null && projectLeader.isAvailable() == true){ //isAvailable() er ikke implementeret endnu
                Project.activityMap.put(new Activity(activityname),null);
            }
            else{
                throw new IllegalArgumentException("Der er ingen projektleder eller ledig medarbejder til at oprette aktiviteten");
            }
        }
    }

    @Override
    public List<Project> allProjects() {
        // TODO Auto-generated method stub
        
        throw new UnsupportedOperationException("Unimplemented method 'allProjects'");
    }

    

    @Override
    public boolean isEmployeeInProject(String employee) {
        for (Employee i : Project.employeeRegtime.keySet()){
            if (i.getEmployeeName().equals(employee)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isActivityInProject(String activityName) {
        for (Activity l : Project.activityMap.keySet()) {
            if (l.getActivityName().equalsIgnoreCase(activityName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmployeeInActivity(String employeeName) {
        for (Employee e : Project.employeeRegtime.keySet()){
            if (e.getEmployeeName().equalsIgnoreCase(employeeName)) {
                return true;
            }
        }
        return false;
    }
    
}
