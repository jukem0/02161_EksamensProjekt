package com.projectmanager.model;

import java.util.ArrayList;

public class Activity {
    private String actName;
    private double budgetTime;
    private Week startWeek, endWeek;
    private int weekAmount;
    private ArrayList<Employee> employees = new ArrayList<>();


    public Activity(String activityName){
        this.actName = activityName;
    }

    public Activity(String activityName, double budgetTime, Week endWeek, int weekAmount) {
        this.actName = activityName;
        this.budgetTime = budgetTime;
        this.endWeek = endWeek;
        this.weekAmount = weekAmount;
        this.startWeek = new Week(endWeek.getWeekNum() - weekAmount, endWeek.getYear());
    }
    
    public String getEmployees() {
        return null; //!! Skal laves xdDDDDD
    }

    public String getActivityName() {
        return actName;
    }

    public double getBudgetTime() {
        return budgetTime;
    }

    public Week getEndWeek() {
        return endWeek;
    }

    public Week getStartWeek() {
        return startWeek;
    }

    public void setActivityName(String newActivityName) {
        this.actName = newActivityName;
    }

    public void setBudgetTime(double newBudgetTime) {
        this.budgetTime = newBudgetTime;
    }

    public void setEndWeek(Week newEndWeek) {
        this.endWeek = newEndWeek;
    }

    public void setWeekAmount(int newWeekAmount) {
        this.weekAmount = newWeekAmount;
        this.startWeek = new Week(endWeek.getWeekNum() - weekAmount, endWeek.getYear());
    }

}
