package com.projectmanager.services;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public interface IProject {
    public String MakeRepport(Project project);
    public void addActivity(String activityname, Project project, Employee projectLeader);
    
}
