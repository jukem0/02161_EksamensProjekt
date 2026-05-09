package com.projectmanager.services;

import com.projectmanager.model.Week;


public interface IActivity {
    public void addActivity(String name, Double budgetTime, Week endDate, int weekAmount);
    public void setStartDate(Week startDate);

}