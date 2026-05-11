package com.projectmanager.services;

import java.util.List;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Project;


public class ProjectsFunctions implements IProjectFunctions {
    @Override
    public String MakeReport(Project project, int weekNr) {
        StringBuilder sb = new StringBuilder();
        List<Project> projects = RuntimeContext.getProjects();
        Project curProject = null;
        for(Project p : RuntimeContext.getProjects()){
            if (p.equals(project)) {
                curProject = p;
            }
        }

        sb.append("Project report\n").append("Project name: ").append(curProject.getName()).append("\n").
        append("Project number: ").append(curProject.getProjectNr()).append("\n");

        //add activities
        sb.append("\nActivities:");
        for(Activity a : curProject.getActivityMap().keySet()) {
            sb.append("\n - ").append(a.getActivityName()).append(":\n");
            sb.append(" -  Time Budget: ").append(a.getBudgetTime()).append("  -  Time Spend: ").append(a.getTimeSpend()).append("  -  Time Remaining: ").append(a.getRemainingTime()).append("\n");
        }
        
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String makeReport(Project project, int weekNr){
        ProjectsFunctions obj = new ProjectsFunctions();
        return obj.MakeReport(project, weekNr);
    }
}
