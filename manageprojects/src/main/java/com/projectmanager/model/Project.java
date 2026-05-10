package com.projectmanager.model;


import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Project{
    private String projectName;
    private double regTime;
    private Employee projectLeader;
    private ArrayList<Activity> activities = new ArrayList<>();


    // Indre hashmap
    private static Map<Employee, Double> employeeRegtime = new HashMap<>();

    // Ydre hashmap
    private static Map<Activity, Map<Employee, Double>> activityMap = new HashMap<>();

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(String projectName, Employee projectLeader) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
    }

    
    public String getActivityName(String activityName) {
        return String.valueOf(activityMap.keySet().stream().filter(a -> a.getActivityName().equalsIgnoreCase(activityName)).findFirst().orElse(null));
    }

    public String getEmployeeName(String employee){
        return String.valueOf(employeeRegtime.keySet().stream().filter(a -> a.getEmployeeName().equalsIgnoreCase(employee)).findFirst().orElse(null));
    }

    public String getYear() {
        return Year.now().toString().substring(2);
    }

    public String getName() {
        return projectName;
    }
    
    public boolean isEmployeeInProject(Map<Employee, Double> employeeRegtime, String employeeName) {
        for (Employee e : employeeRegtime.keySet()) {
            if (e.getEmployeeName().equals(employeeName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmployeeInProject(Map<Employee, Double> employeeRegtime, Employee employee){
        return employeeRegtime.containsKey(employee);
    }

    public boolean isActivityInProject(String activityName) {
        for (Activity l : Project.activityMap.keySet()) {
            if (l.getActivityName().equalsIgnoreCase(activityName)){
                return true;
            }
        }
        return false;
    }

    public boolean isActivityInProject(Activity activity){
        return activityMap.containsKey(activity);
    }

    public boolean isEmployeeInActivity(String employeeName) {
        for (Employee e : Project.employeeRegtime.keySet()){
            if (e.getEmployeeName().equalsIgnoreCase(employeeName)) {
                return true;
            }
        }
        return false;
    }

    public Map<Activity, Map<Employee, Double>> getActivityMap(){
        return activityMap;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()){
            return false;
        }

        Project other = (Project) obj;

        return (getName().equals(other.getName()) && getActivityMap().equals(other.getActivityMap()));
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(projectName, activityMap);
    }

    
    


}