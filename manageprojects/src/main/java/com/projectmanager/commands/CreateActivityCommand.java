package com.projectmanager.commands;

import java.time.Year;

import com.projectmanager.model.Week;
import com.projectmanager.services.RuntimeContext;

public class CreateActivityCommand extends Command{
    public CreateActivityCommand() {
        setFormat("create_activity <projectName> <activityName> <budgetTime>");
        //or  : create_activity <projectNr> <activityName> <budgetTime> <endWeek> <amountWeek>"
    }

    @Override
    public void execute(String[] args) {
        //Expected format: create_activity <projectName> <activityName> <budgetTime>
        //           or  : create_activity <projectName> <activityName> <budgetTime> <endWeek> <amountWeek>
        //args should only contain the part after inital command. Everything after ":" is optional
        switch (args.length) {
            case 3 -> {
                for (int i = 0; i < RuntimeContext.getProjects().size(); i++) {
                    if (RuntimeContext.getProjects().get(i).getName().equals(args[0])) {
                        double budgetTime = Double.parseDouble(args[2]);
                        RuntimeContext.getProjects().get(i).addActivity(args[1], budgetTime);
                    }
                }
            }
            case 5 -> {
                for (int i = 0; i < RuntimeContext.getProjects().size(); i++) {
                    if (RuntimeContext.getProjects().get(i).getName().equals(args[0])) {
                        double budgetTime = Double.parseDouble(args[2]);
                        RuntimeContext.getProjects().get(i).addActivity(args[1], budgetTime, new Week(Integer.parseInt(args[3]),Year.now().getValue()), Integer.parseInt(args[4]));
                    }
                }
            }
            default -> System.out.println("Expected format: " + getFormat());
        }
    }
}
