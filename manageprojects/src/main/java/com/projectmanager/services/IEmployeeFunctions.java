package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public interface IEmployeeFunctions {

    public Employee getEmployee();
    public void addProject(Project project);
    public void addActivityToProject(String activityname, Project project, Employee projectLeader);
    public void addEmployeeToActivity(Employee employee, Activity activity, Project project);
    public void assignProjectleader(Project project, Employee employee);
    public void registerTime(double hours);


}
