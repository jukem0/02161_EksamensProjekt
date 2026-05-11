package com.projectmanager.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.projectmanager.services.RuntimeContext;

public class Project {
    private String projectName, projectNr;
    private double regTime;
    private Employee projectLeader;
    private ArrayList<Activity> activities = new ArrayList<>();
    private static int serialNumber = 0;

    public static void resetSerialNumber() {
        serialNumber = 0;
    }

    // Indre hashmap
    private static Map<Employee, Double> employeeRegtime = new HashMap<>();

    // Ydre hashmap
    private Map<Activity, Map<Employee, Double>> activityMap = new HashMap<>();

    public Project(String projectName) {
        this.projectName = projectName.replace("\"", "");
        this.projectNr = generateProjectNr();
    }

    public Project(String projectName, Employee projectLeader) {
        this.projectName = projectName.replace("\"", "");
        this.projectLeader = projectLeader;
        this.projectNr = generateProjectNr();
    }

    private String generateProjectNr() {
        serialNumber++;
        // Dette giver f.eks. "26" + "001" = "26001"... "26002" osv.
        return getYear() + String.format("%03d", serialNumber);
    }

    public Employee getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(Employee employee) {
        this.projectLeader = employee;
    }

    public String getActivityName(String activityName) {
        return String.valueOf(activityMap.keySet().stream()
                .filter(a -> a.getActivityName().equalsIgnoreCase(activityName)).findFirst().orElse(null));
    }

    public String getEmployeeName(String projectNr) {
        return String.valueOf(employeeRegtime.keySet().stream()
                .filter(a -> a.getEmployeeName().equalsIgnoreCase(projectNr)).findFirst().orElse(null));
    }

    public String getYear() {
        return Year.now().toString().substring(2);
    }

    public String getName() {
        return projectName;
    }

    public String getProjectNr() {
        return projectNr;
    }

    public boolean isEmployeeInProject(Map<Employee, Double> employeeRegtime, Employee employee) {
        for (Activity a : activities) {
            Map<Employee, Double> activityInProject = activityMap.get(a);
            if (activityInProject != null && activityInProject.containsKey(employee)) {
                return true;
            }
        }
        return false;
    }

    public boolean isActivityInProject(Activity activity) {
        return activityMap.containsKey(activity);
    }

    public boolean isEmployeeInActivity(String employeeName) {
        for (Employee e : Project.employeeRegtime.keySet()) {
            if (e.getEmployeeName().equalsIgnoreCase(employeeName)) {
                return true;
            }
        }
        return false;
    }

    public void addActivity(String actName) {
        Activity newAct = new Activity(actName);
        activities.add(newAct);
        activityMap.put(newAct, null);
        RuntimeContext.setLastCreatedActivity(newAct);
    }

    public void addActivity(String actName, double budgetTime, Week endWeek, int weekAmount) {
        Activity newAct = new Activity(actName, budgetTime, endWeek, weekAmount);
        activities.add(newAct);
        activityMap.put(newAct, null);
        RuntimeContext.setLastCreatedActivity(newAct);
    }

    public void addActivity(String actname, Employee projectLeader) {
        assert (projectLeader != null) : "Ingen medarbejder valgt";
        if (isActivityInProject(new Activity(actname)) == true) {
            throw new IllegalArgumentException("denne aktivitet findes allerede");
        } else if (projectLeader.leaderOf() != null && projectLeader.leaderOf().equals(this.getProjectNr())
                || projectLeader.isAvailable()) {
            Activity newAct = new Activity(actname);
            activityMap.put(newAct, null);
            activities.add(newAct);
            RuntimeContext.setLastCreatedActivity(newAct);
        } else {
            throw new IllegalArgumentException(
                    "Der er ingen projektleder eller ledig medarbejder til at oprette aktiviteten");
        }
    }

    public Map<Activity, Map<Employee, Double>> getActivityMap() {
        return activityMap;
    }

    public Map<Employee, Double> getEmployeeMap() {
        return employeeRegtime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Project other = (Project) obj;
        return java.util.Objects.equals(projectName, other.projectName) &&
                java.util.Objects.equals(projectNr, other.projectNr);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(projectName, projectNr);
    }

    public double getTimeSpend() {
        double timeSpend = 0.0;
        for (Map<Employee, Double> employeeRegtime : this.activityMap.values()) {
            if (employeeRegtime != null) {
                for (double value : employeeRegtime.values()) {
                    timeSpend += value;
                }
            }
        }
        return timeSpend;
    }

    public double getTimeSpendPerPersonActivity(Activity activity, Employee employee) {
        double timeSpendEmployee = 0.0;

        Map<Employee, Double> empMap = activityMap.get(activity);
        if (empMap != null) {
            Double hours = empMap.get(employee);
            if (hours != null) {
                timeSpendEmployee = hours;
            }
        }

        return timeSpendEmployee;
    }

    public String generateReport(int weeknr) {
        if (activities.isEmpty()) {
            throw new IllegalArgumentException("ingen aktiviteter i projekt");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(projectName).append(", ").append(weeknr).append("\n\n\n");
        for (Activity a : activities) {
            sb.append(a.getActivityName()).append(":\n");
            sb.append(" -  Time Budget: ").append(a.getBudgetTime())
                    .append("  -  Time Spend: ").append(a.getTimeSpend())
                    .append("  -  Time Remaining: ").append(a.getRemainingTime()).append("\n");
        }
        return sb.toString();
    }

    public Activity getActivity(int index) {
        return activities.get(index);
    }

}