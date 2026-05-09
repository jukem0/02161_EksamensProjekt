package com.projectmanager.services;

import java.util.List;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public interface IProject {
    public String MakeRepport(Project project);

    public void addActivity(String activityname, Project project, Employee projectLeader);

    public List<Project> allProjects();

    public boolean isEmployeeInProject(String employee);

    public boolean isActivityInProject(String activityName);

    boolean isEmployeeInActivity(String employeeName);

}
