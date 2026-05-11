package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public interface IEmployeeFunctions {

    public Employee nsgetEmployee();
    public void nsaddProject(Project project);
    public void nsaddActivityToProject(String activityname, Project project, Employee projectLeader);
    public void nsaddEmployeeToActivity(Employee employee, Activity activity, Project project);
    public void nsassignProjectleader(Project project, Employee employee);
    public void nsregisterTime(Employee emp,Project pro, Activity act, Double hours) throws Exception;


}
