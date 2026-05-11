package com.projectmanager.commands;

import com.projectmanager.model.Employee;
import com.projectmanager.services.Parser;
import com.projectmanager.services.RuntimeContext;

public class CreateActivityCommand extends Command{

    @Override
    public String getName() {
        return "create_activity";
    }

    @Override
    public void execute(String[] args) {
        //Expected format: create_activity <projectName> <activityName> : <activityName2> : <activityName3>
        //args should only contain the part after inital command. Everything after ":" is optional
        if (args.length == 2) {
            
        } else if (args.length == 2) {
            Employee employee = Parser.stringToEmployee(args[1]);
            if (RuntimeContext.getEmployees().contains(employee)) {
                //Call the method
            }
        } 
    }

    
}
