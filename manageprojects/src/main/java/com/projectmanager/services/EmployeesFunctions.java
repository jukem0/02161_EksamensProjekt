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

        Map<Activity, Map<Employee, Double>> activityMap = project.getActivityMap();

        activityMap.putIfAbsent(activity, new HashMap<>());

        activityMap.get(activity).putIfAbsent(employee, 0.0);
    }

    

    @Override
    public void assignProjectleader(Project project, Employee employee){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignProjectleader'");
    }
    @Override 
    public void registerTime(Employee emp,Project pro, Activity act, Double hours) throws Exception{
        //employeeRegTime
        if (hours >= 0){
            throw new Exception("Tiden kan ikke indtastes som negativt");
        }

        Map<Activity, Map<Employee, Double>> activityMap = pro.getActivityMap();

        Double oldVal = activityMap.get(act).get(emp);

        activityMap.get(act).put(emp, oldVal + hours);

    }

    @Override
    public Employee getEmployee(){
    // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployee'");
    }

}
