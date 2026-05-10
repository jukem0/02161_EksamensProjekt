package stepdefinitions;

import com.projectmanager.model.*;
//import com.projectmanager.stepdefinitions.CreateProjectSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class createActivitysteps {
    public static List<Employee> employees = new ArrayList<>();
    public static List<Project> projects = new ArrayList<>();

    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at
        List<String> employeeNames = table.asList(String.class);
        for (String name : employeeNames) {
            Employee newEmp = new Employee(name);
            employees.add(newEmp);
        }
        // vise hvem er i systemet.
    
    }

    // @Given("en {string} findes i systemet")
    // public void getmedarbejder(String medarbejder) {

    // }

    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projectname, Project project, Employee Employee, String employeename) {
        assert(project.getName().equalsIgnoreCase(projectname) && project.getProjectLeader() != null && 
        (Employee.leaderOf().equals(project.getProjectNr()) || Employee.isAvailable())): 
        "Der skal være en projektleder eller en ledig medarbejder for at kunne oprette en aktivitet";
    }

    @When("projektleder eller ledig medarbejder opretter aktivitet med navn {string}")
    public void opretAktivitet(String aktivitetsnavn, Project project, Employee Employee) {
        try {
            project.addActivity(aktivitetsnavn, Employee);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String aktivitetsnavn, Project project, Employee Employee) {
        assert(project.isActivityInProject(new Activity(aktivitetsnavn))): "Aktiviteten blev ikke oprettet, der er noget galt";

    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projectname, Project project) {
        assert(project.getName().equalsIgnoreCase(projectname)): "Projektet blev ikke fundet";

    }

    @And("der findes allerede en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String aktivitetsnavn, Project project) {
        assert(project.isActivityInProject(new Activity(aktivitetsnavn))): "Aktiviteten blev ikke fundet";
    }

    @Then("handling fejler med fejlbesked: {string}")
    public void opretAktivitetFailure(String fejlbesked) {
        fejlbesked = "Aktiviteten findes allerede i projektet";
        System.out.println(fejlbesked);
    }

}
