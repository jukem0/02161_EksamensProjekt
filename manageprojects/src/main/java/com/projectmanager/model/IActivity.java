package com.projectmanager.model;

import java.util.ArrayList;

public interface IActivity {
    public ArrayList<Employee> getEmployees();
    public String getActivityName();
    public double getBudgetTime();
    public Week getEndWeek();
    public Week getStartWeek();
    public void setActivityName(String newActivityName);
    public void setBudgetTime(double newBudgetTime);
    public void setEndWeek(Week newEndWeek);
    public void setWeekAmount(int newWeekAmount);
    public void addEmployeeToActivity(Employee employee);
}
