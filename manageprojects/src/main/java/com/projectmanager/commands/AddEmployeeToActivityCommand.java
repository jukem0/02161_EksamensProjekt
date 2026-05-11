package com.projectmanager.commands;

import java.util.ArrayList;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.EmployeesFunctions;
import com.projectmanager.services.Parser;
import com.projectmanager.services.RuntimeContext;

public class AddEmployeeToActivityCommand extends Command{
    public AddEmployeeToActivityCommand() {
        setFormat("add_employee_to_activity <employeeName> <activityName> <nameOfProject>");
    }

    @Override
    public void execute(String[] args){
        if (args.length == 3) {
            Employee employee = Parser.stringToEmployee(args[0]);
            Activity activity = Parser.stringToActivity(args[1]);
            Project project = Parser.stringToProject(args[2]);
            ArrayList<Project> projects = RuntimeContext.getProjects();
            for (Project p : projects) {
                if (p.equals(project)) {
                    if (p.getActivityMap().keySet().contains(activity)) {
                        EmployeesFunctions.addEmployeeToActivity(employee, activity, project);
                    }
                }
            }
        } else{
            System.out.println("Expected format: " + getFormat());
        }
    }
}
