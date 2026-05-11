package com.projectmanager.commands;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.EmployeesFunctions;
import com.projectmanager.services.Parser;
import com.projectmanager.services.RuntimeContext;

public class CreateProjectCommand extends Command{
    public CreateProjectCommand() {
        setFormat("create_project <projectName> : <newLeaderName>");
    }

    @Override
    public void execute(String[] args) {
        //Expected format: create_project <projectName> : <newLeaderName>
        //args should only contain the part after inital command. Everything after ":" is optional
        switch (args.length) {
            case 1 -> EmployeesFunctions.addProject(new Project(args[0]));
            case 2 -> {
                Employee employee = Parser.stringToEmployee(args[1]);
                if (RuntimeContext.getEmployees().contains(employee)) {
                    EmployeesFunctions.addProject(new Project(args[0], employee));
                }
            }
            default -> System.out.println("Expected format: " + getFormat());
        }
    }

    
}
