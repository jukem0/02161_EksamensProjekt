package com.projectmanager.services;

import com.projectmanager.model.Week;

public class ActivityFuctions implements  IActivityFunctions{

    @Override
    public void addActivity(String name, Double budgetTime, Week endDate, int weekAmount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setStartDate(Week startDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setEndDate(Week endDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBudgetTime(double budgetTime) {
        //check if posetive number and round up to the nearst half
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setduration(int weekAmount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
