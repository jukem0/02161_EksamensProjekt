package com.projectmanager.services;

import java.util.HashMap;
import java.util.Map;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public class EmployeesFunctions implements IEmployeeFunctions {

    @Override
    public void nsaddActivityToProject(String activityname, Project project, Employee projectLeader){
        // TODO Auto-generated method stub
        project.addActivity(activityname, projectLeader);
        throw new UnsupportedOperationException("Unimplemented method 'addActivityToProject'");
    }

    @Override
    public void nsaddEmployeeToActivity(Employee employee, Activity activity, Project project){
        // TODO Auto-generated method stub

        Map<Activity, Map<Employee, Double>> activityMap = project.getActivityMap();

        activityMap.putIfAbsent(activity, new HashMap<>());

        activityMap.get(activity).putIfAbsent(employee, 0.0);
    }

    @Override
    public void nsaddProject(Project project) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void nsassignProjectleader(Project project, Employee employee){
        Employee.assignProjectleader(project.getProjectNr(), employee);
    }

    @Override
    public void nsregisterTime(Employee emp, Project pro, Activity act, Double hours) throws Exception {
        if (hours < 0) {
            throw new Exception("Tiden kan ikke indtastes som negativt");
        }

        Map<Activity, Map<Employee, Double>> activityMap = pro.getActivityMap();

        activityMap.putIfAbsent(act, new HashMap<>());
        Map<Employee, Double> empMap = activityMap.get(act);

        Double oldVal = empMap.getOrDefault(emp, 0.0);
        empMap.put(emp, oldVal + hours);
    }


    

    public static void addActivityToProject(String activityname, Project project, Employee projectLeader) {
        IEmployeeFunctions obj = new EmployeesFunctions();
        obj.nsaddActivityToProject(activityname, project, projectLeader);
    }

    public static void addEmployeeToActivity(Employee employee, Activity activity, Project project){
        IEmployeeFunctions obj = new EmployeesFunctions();
        obj.nsaddEmployeeToActivity(employee, activity, project);
    }

    public static void addProject(Project projects){
        IEmployeeFunctions obj = new EmployeesFunctions();
        obj.nsaddProject(projects);
    }

    public static void assignProjectleader(Project project, Employee employee){
        IEmployeeFunctions obj = new EmployeesFunctions();
        obj.nsassignProjectleader(project, employee);
    }

    public static void registerTime(Employee emp, Project pro, Activity act, Double hours) throws Exception{
        IEmployeeFunctions obj = new EmployeesFunctions();
        obj.nsregisterTime(emp, pro, act, hours);
    }


}
