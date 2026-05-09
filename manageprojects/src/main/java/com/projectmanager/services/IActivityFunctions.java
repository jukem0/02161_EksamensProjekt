package com.projectmanager.services;

import com.projectmanager.model.Week;


public interface IActivityFunctions {
    public void addActivity(String name, Double budgetTime, Week endDate, int weekAmount);
    public void setStartDate(Week startDate);
    public void setEndDate(Week endDate);
    public void setBudgetTime(double budgetTime);
    public void setduration(int weekAmount);

}