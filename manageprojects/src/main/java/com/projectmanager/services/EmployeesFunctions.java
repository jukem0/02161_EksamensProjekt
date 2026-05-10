package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import java.util.*;

public class EmployeesFunctions implements IEmployeeFunctions {

    @Override
    public void addActivityToProject(String activityname, Project project, Employee projectLeader){
        // TODO Auto-generated method stub
        project.addActivity(activityname, project, projectLeader);
        throw new UnsupportedOperationException("Unimplemented method 'addActivityToProject'");
    }

    @Override
    public void addEmployeeToActivity(Employee employee, Activity activity, Project project){
        // TODO Auto-generated method stub

        if (project.isActivityInProject(activity.getActivityName())) {
            activity.addEmployeeToActivity(employee);
        }

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
    public void registerTime(Employee emp,Project pro, Activity act, Double hours){
        //employeeRegTime
    }

    @Override
    public Employee getEmployee(){
    // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployee'");
    }

}
