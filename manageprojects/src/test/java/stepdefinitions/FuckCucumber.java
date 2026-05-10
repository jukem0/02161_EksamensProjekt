package stepdefinitions;

import java.util.List;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.ProjectsFunctions;


public class FuckCucumber {

    public static Project getProject(String project){
        
        ProjectsFunctions projectFunctions = new ProjectsFunctions();
        List<Project> projecter = projectFunctions.allProjects();

        for (Project p : projecter) {
            if (p.getName().equalsIgnoreCase(project) ) {
                return p;
            }
        }

        return null;
    }

    public static Employee getEmployee(String emp){
        return null;
    }

    public static Activity getActivity(String emp, Project project){
        return null;
    }

}
