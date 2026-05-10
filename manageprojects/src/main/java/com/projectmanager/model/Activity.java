package com.projectmanager.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class Activity implements IActivity {
    private String actName;
    private double budgetTime, timeSpend, timeRemaining;
    private Week startWeek, endWeek;
    private int weekAmount;
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Activity(String activityName) {
        this.actName = activityName;
        this.timeSpend = 0;
    }

    public Activity(String activityName, double budgetTime, Week endWeek, int weekAmount) {
        this.actName = activityName;
        this.budgetTime = budgetTime;
        this.timeRemaining = budgetTime;
        this.endWeek = endWeek;
        this.weekAmount = weekAmount;
        this.startWeek = new Week(endWeek.getWeekNum() - weekAmount, endWeek.getYear());
        this.timeSpend = 0;

        if (budgetTime < 0) {
            budgetTime = 0;
        } else {
            budgetTime = Math.round(budgetTime*2)/2.0;
        }
    }
    
    @Override
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    @Override
    public void addEmployeeToActivity(Employee employee){
    }

    @Override
    public String getActivityName() {
        return actName;
    }

    @Override
    public double getBudgetTime() {
        return budgetTime;
    }

    @Override
    public Week getEndWeek() {
        return endWeek;
    }

    @Override
    public Week getStartWeek() {
        return startWeek;
    }

    @Override
    public void setActivityName(String newActivityName) {
        this.actName = newActivityName;
    }

    @Override
    public void setBudgetTime(double newBudgetTime) {
        this.budgetTime = newBudgetTime;
    }

    @Override
    public void setEndWeek(Week newEndWeek) {
        this.endWeek = newEndWeek;
    }

    @Override
    public void setWeekAmount(int newWeekAmount) {
        this.weekAmount = newWeekAmount;
        this.startWeek = new Week(endWeek.getWeekNum() - weekAmount, endWeek.getYear());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Activity other = (Activity) obj;

        return (getActivityName().equals(other.getActivityName()) && getEmployees().equals(other.getEmployees()) && getStartWeek().equals(other.getStartWeek()) && getEndWeek().equals(other.getEndWeek()));
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(actName, employees, startWeek, endWeek);
    }

    public double getRemainingTime() {
        return timeRemaining;
    }
}
