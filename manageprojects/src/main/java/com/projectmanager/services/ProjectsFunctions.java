package com.projectmanager.services;

import java.util.List;

import com.projectmanager.model.Project;

public class ProjectsFunctions implements IProjectFunctions {

    @Override
    public String MakeReport(Project project) {
        StringBuilder sb = new StringBuilder();
        List<Project> projects = runtimeContext.getProjects();
        Project curProject = projects.get(Integer.parseInt(project.getProjectNr()) - 1);

        sb.append("Project report\n");
        sb.append("Project name: " + curProject.getName() + "\n");
        sb.append("Project number: " + curProject.getProjectNr() + "\n");

        //add activities
        sb.append("\nActivities:");
        for(Activity a : curProject.getActivityMap().keySet()) {
            sb.append("\n - " + a.getActivityName() + ":\n");
            sb.append(" -  Time Budget: " + a.getBudgetTime() + "  -  Time Spend: " + a.getTimeSpend() + "  -  Time Remaining: " + a.getRemainingTime() + "\n");
        }
        
        return sb.toString();
    }
}
