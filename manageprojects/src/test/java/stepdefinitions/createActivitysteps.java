package stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class createActivitysteps {
    private static List<Employee> employeelist = new ArrayList<>();
    private static List<Project> projectlist = new ArrayList<>();
    private  Project project;
    private  Employee employee; 
    
    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at
        List<String> employeeNames = table.asList(String.class);
        for (String name : employeeNames) {
            Employee newEmp = new Employee(name);
            employeelist.add(newEmp);
        }
        // vise hvem er i systemet.
    }

    @Given("følgende projekter findes i systemet:")
    public void følgendeProjekterFindesISystemet(DataTable table) { // bruger en given liste af projekter for at
        List<String> projectNames = table.asList(String.class);
        for (String name : projectNames) {
            Project newProject = new Project(name);
            projectlist.add(newProject);
        }
        // vise hvilke projekter er i systemet.
    }
    
    // @Given("en {string} findes i systemet")
    // public void getmedarbejder(String medarbejder) {
    // }
 
    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projectname) {
        project = projectlist.stream().filter(p -> p.getName().equalsIgnoreCase(projectname)).findFirst().orElse(null);
        employee = employeelist.stream().filter(e -> e.isAvailable() || e.leaderOf().equals(project.getProjectNr())).findFirst().orElse(null);
        assert(project.getName().equalsIgnoreCase(projectname) && project.getProjectLeader() != null && 
        (employee.leaderOf().equals(project.getProjectNr()) || employee.isAvailable())): 
        "Der skal være en projektleder eller en ledig medarbejder for at kunne oprette en aktivitet";
    }

    @When("projektleder eller ledig medarbejder opretter aktivitet med navn {string}")
    public void opretAktivitet(String actname){
        try {
            project.addActivity(actname, employee);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String actname) {
        assert(project.isActivityInProject(new Activity(actname))): "Aktiviteten blev ikke oprettet, der er noget galt";

    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projectname) {
        assert(project.getName().equalsIgnoreCase(projectname)): "Projektet blev ikke fundet";

    }

    @And("der findes allerede en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String actname) {
        assert(project.isActivityInProject(new Activity(actname))): "Aktiviteten blev ikke fundet";
    }

    @Then("handling fejler med fejlbesked: {string}")
    public void opretAktivitetFailure(String fejlbesked) {
        fejlbesked = "Aktiviteten findes allerede i projektet";
        System.out.println(fejlbesked);
    }

}
