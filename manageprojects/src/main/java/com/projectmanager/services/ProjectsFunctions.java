package com.projectmanager.services;

import java.util.List;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Project;


public class ProjectsFunctions implements IProjectFunctions {
    @Override
    public String MakeReport(Project project, int weekNr) {
        StringBuilder sb = new StringBuilder();
        List<Project> projects = RuntimeContext.getProjects();
        Project curProject = projects.get(Integer.parseInt(project.getProjectNr()) - 1);

        sb.append("Project report\n").append("Project name: ").append(curProject.getName()).append("\n").
        append("Project number: ").append(curProject.getProjectNr()).append("\n");

        //add activities
        sb.append("\nActivities:");
        for(Activity a : curProject.getActivityMap().keySet()) {
            sb.append("\n - ").append(a.getActivityName()).append(":\n");
            sb.append(" -  Time Budget: ").append(a.getBudgetTime()).append("  -  Time Spend: ").append(a.getTimeSpend()).append("  -  Time Remaining: ").append(a.getRemainingTime()).append("\n");
        }
        
        return sb.toString();
    }
}
