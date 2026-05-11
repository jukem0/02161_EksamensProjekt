package com.projectmanager.services;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Week;


public interface IActivityFunctions {
    public void addActivity(String projectNr, String name, Double budgetTime, Week endDate, int weekAmount);
    public void setEndDate(String projectNr, Activity activityName, Week endDate);
    public void setBudgetTime(String projectNr, Activity activityName, double budgetTime);
    public void setduration(String projectNr, Activity activityName, int weekAmount);

}