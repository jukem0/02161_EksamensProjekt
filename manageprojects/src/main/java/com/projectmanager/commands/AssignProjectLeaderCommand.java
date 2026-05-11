package com.projectmanager.commands;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.EmployeesFunctions;
import com.projectmanager.services.Parser;
import com.projectmanager.services.RuntimeContext;

public class AssignProjectLeaderCommand extends Command {

    public AssignProjectLeaderCommand() {
        setFormat("assign_project_leader <projectName> <employeeName>");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            Project project = Parser.stringToProject(args[0]);
            Employee employee = Parser.stringToEmployee(args[1]);
            if (RuntimeContext.getEmployees().contains(employee)) {
                for (Project p : RuntimeContext.getProjects()) {
                    if (p.equals(project)) {
                        EmployeesFunctions.assignProjectleader(project, employee);
                        return;
                    }
                }
                System.out.println("The project with the name " + args[1] + "could not be found");
            } else{
                System.out.println("The employee with name " + args[0] + " could not be found");
            }
        } else {
            System.out.println("Expected format: " + getFormat());
        }
    }

}
