package com.projectmanager.commands;

import java.time.Year;

import com.projectmanager.model.Week;
import com.projectmanager.services.RuntimeContext;

public class CreateActivityCommand extends Command{
    String format = "create_activity <projectNr> <activityName> or  : create_activity <projectNr> <activityName> <budgetTime> <endWeek> <amountWeek>";

    @Override
    public void execute(String[] args) {
        //Expected format: create_activity <projectNr> <activityName>
        //           or  : create_activity <projectNr> <activityName> <budgetTime> <endWeek> <amountWeek>
        //args should only contain the part after inital command. Everything after ":" is optional
        if (args.length == 2) {
            for (int i = 0; i < RuntimeContext.getProjects().size(); i++) {
                if (RuntimeContext.getProjects().get(i).getProjectNr().equals(args[0])) {
                    RuntimeContext.getProjects().get(i).addActivity(args[1]);
                }
            }
        } else if (args.length == 5) {
            for (int i = 0; i < RuntimeContext.getProjects().size(); i++) {
                if (RuntimeContext.getProjects().get(i).getProjectNr().equals(args[0])) {
                    RuntimeContext.getProjects().get(i).addActivity(args[1], Integer.parseInt(args[2]), new Week(Integer.parseInt(args[3]),Year.now().getValue()), Integer.parseInt(args[4]));
                }
            }
        } else{
            System.out.println("Expected format: " + format);
        }
    }
}
