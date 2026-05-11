package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Week;

public class ActivityFuctions implements IActivityFunctions {

    @Override
    public void addActivity(String projectNr, String name, Double budgetTime, Week endDate, int weekAmount) {
        for (int j = 0; j < RuntimeContext.getProjects().size(); j++) {
            if (RuntimeContext.getProjects().get(j).getProjectNr().equals(projectNr)) {
                RuntimeContext.getProjects().get(j).addActivity(name, budgetTime, endDate, weekAmount);
            }
        }
    }

    @Override
    public void setEndDate(String projectNr, Activity activityName, Week endDate) {
        for (int j = 0; j < RuntimeContext.getProjects().size(); j++) {
            if (RuntimeContext.getProjects().get(j).getProjectNr().equals(projectNr)) {
                RuntimeContext.getProjects().get(j).getActivityMap().keySet().stream()
                        .filter(a -> a.equals(activityName)).findFirst().orElse(null).setEndWeek(endDate);
            }
        }
    }

    @Override
    public void setBudgetTime(String projectNr, Activity activityName, double budgetTime)
            throws IllegalArgumentException {
        if (budgetTime < 0) {
            throw new IllegalArgumentException("Time Budget cannot be negative");
        }
        for (int j = 0; j < RuntimeContext.getProjects().size(); j++) {
            if (RuntimeContext.getProjects().get(j).getProjectNr().equals(projectNr)) {
                RuntimeContext.getProjects().get(j).getActivityMap().keySet().stream()
                        .filter(a -> a.equals(activityName)).findFirst().orElse(null).setBudgetTime(budgetTime);
            }
        }
    }

    @Override
    public void setduration(String projectNr, Activity activityName, int weekAmount) {
        for (int j = 0; j < RuntimeContext.getProjects().size(); j++) {
            if (RuntimeContext.getProjects().get(j).getProjectNr().equals(projectNr)) {
                RuntimeContext.getProjects().get(j).getActivityMap().keySet().stream()
                        .filter(a -> a.equals(activityName)).findFirst().orElse(null).setWeekAmount(weekAmount);

            }
        }
    }

    

}
