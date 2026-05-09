package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Medarbejder;
import com.projectmanager.model.Project;
import.com.projectmanager.services.*;
import java.util.*;

public class EmployeesFunctions implements IEmployee {

    @Override
    public void addProject(Project project){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProject'");
    }

    @Override
    public void addActivityToProject(String activityname, Project project, Employee projectLeader){
        // TODO Auto-generated method stub
        project.addActivity(activityname, project, projectLeader);
        throw new UnsupportedOperationException("Unimplemented method 'addActivityToProject'");
    }

    @Override
    public void addEmployeeToActivity(Employee employee, Activity activity, Project project){
        // TODO Auto-generated method stub
        activityMap.putIfAbsent(activity, new HashMap<>());

        Map<Employee, Double> employeeRegtime = activityMap.get(activity);

        employeeRegtime.put(employee, null);
        throw new UnsupportedOperationException("Unimplemented method 'addEmployeeToActivity'");
    }

    @Override
    public void assignProjectleader(Project project, Employee employee){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignProjectleader'");
    }
    @Override 
    public void registerTime(double hours){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerTime'");
    }

    @Override
    public Employee getEmployee(){
    // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployee'");
    }

}
