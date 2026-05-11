package stepdefinitions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectSteps {
    private ArrayList<Project> projects;
    public static ArrayList<Employee> employees = new ArrayList<>();
    int selectedIndex = 0;

    @Given("en {string} findes i systemet")
    public void en_medarbejder_findes_i_systemet(String empName) {
        boolean isInSystem = false;
        for (int i = 0; i < employees.size(); i++) {
            if (empName.equals(employees.get(i).getEmployeeName())) {
                isInSystem = true;
            }
        }

        if (!isInSystem) {
            Employee newEmp = new Employee(empName);
            employees.add(newEmp);
        }
    }

    @When("en medarbejder opretter et projekt med navn {string}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {
        projects = new ArrayList<>();
        projects.add(new Project(projektnavn));
        for (int x = 0; x < projects.size(); x++) {
            if(projects.get(x).getName().equals(projektnavn)){
                selectedIndex = x;
            }
        }
        assertEquals(1, projects.size());
    }

    @Then("er projektet oprettet og har projekt-nummer {string}")
    public void er_projektet_oprettet_og_har_projekt_nummer(String projectNummer) {
        assertEquals(projectNummer, projects.get(selectedIndex).getProjectNr());
    }
}