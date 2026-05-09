package stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import com.projectmanager.model.*;
import com.projectmanager.services.*;
import com.projectmanager.services.IProject;
import com.projectmanager.services.ProjectsFunctions;


public class FuckCucumber {

    public Project getProject(String project){
        
        ProjectsFunctions projectFunctions = new ProjectsFunctions();
        List<Project> projecter = projectFunctions.allProjects();

        for (Project p : projecter) {
            if (p.getName() == project ) {
                return p;
            }
        }

        return null;
    }

    public Employee getEmployee(String emp){
        return null;
    }

    public Activity getActivity(String emp, Project project){
        return null;
    }
}
