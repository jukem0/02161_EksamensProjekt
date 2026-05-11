package com.projectmanager.commands;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Project;
import com.projectmanager.services.EmployeesFunctions;
import com.projectmanager.services.Parser;
import com.projectmanager.services.RuntimeContext;

public class RegisterTimeCommand extends Command{
    String format = "register_time <projectName> <activityName> <hours>";

    @Override
    public void execute(String[] args) {
        if (args.length == 3) {
            Project project = Parser.stringToProject(args[0]);
            Activity activity = Parser.stringToActivity(args[1]);
            Double hours = Double.parseDouble(args[2]);
            for(Project p : RuntimeContext.getProjects()){
                if (p.equals(project)) {
                    if (p.getActivityMap().keySet().contains(activity)){
                        EmployeesFunctions.registerTime(RuntimeContext.getLoggedInEmployee(), project, activity, hours);
                    }
                }
            }
        }
    }

    
}
