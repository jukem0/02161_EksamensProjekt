package com.projectmanager.services;

import java.util.List;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

public class ProjectsFunctions implements IProjectFunctions {

    @Override
    public String MakeRepport(Project project) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MakeRepport'");
    }

    @Override
    public void addActivity(String activityname, Project project, Employee projectLeader) {
        if (project.isActivityInProject(activityname) == true){
            throw new IllegalArgumentException("Aktiviteten findes allerede i projektet");
        }
        else {
            if (projectLeader != null && projectLeader.leaderOf() == project) {
                Project.activityMap.put(new Activity(activityname),null);
            }
            else if(projectLeader == null && projectLeader.isAvailable() == true){ //isAvailable() er ikke implementeret endnu
                Project.activityMap.put(new Activity(activityname),null);
            }
            else{
                throw new IllegalArgumentException("Der er ingen projektleder eller ledig medarbejder til at oprette aktiviteten");
            }
        }
    }

    @Override
    public List<Project> allProjects() {
        // TODO Auto-generated method stub
        
        throw new UnsupportedOperationException("Unimplemented method 'allProjects'");
    }

    

    
}
