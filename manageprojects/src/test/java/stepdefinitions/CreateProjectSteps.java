package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.io.*;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.DataAccessLayer;
import com.projectmanager.services.RuntimeContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectSteps {
    private String foundEmployee = "";
    private ArrayList<Employee> employeesFromFile;
    private ArrayList<Project> projects;
    public File employeeFile = new File("src/main/java/com/projectmanager/HR/Employees.txt");

    public CreateProjectSteps() {
        try {
            DataAccessLayer data = new DataAccessLayer();
            if (!employeeFile.exists()) {
                employeeFile = new File("manageprojects/" + employeeFile.getPath());
            }
            employeesFromFile = data.parseToEmployee(employeeFile);
        } catch (FileNotFoundException e) {
            System.err.println("FEJL: Kunne ikke finde Employees.txt på: " + employeeFile.getAbsolutePath());
            employeesFromFile = new ArrayList<>();
        }
    }

    @Given("en {string} findes i systemet")
    public void employee_findes_i_systemet(String empName) {
        for (int i = 0; i < employeesFromFile.size(); i++) {
            if (employeesFromFile.get(i).getEmployeeName().equals(empName)) {
                foundEmployee = empName;
                System.out.println(foundEmployee);
                System.out.println(empName);
            }
        }
        assertEquals(empName, foundEmployee);
    }

    @When("en medarbejder opretter et projekt med navn {string}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {
        projects = new ArrayList<>();
        projects.add(new Project(projektnavn));
        assertEquals(1, projects.size());
    }

    @Then("er projektet oprettet og har projekt-nummer {string}")
    public void er_projektet_oprettet_og_har_projekt_nummer(String projectNummer) {
        assertEquals(projectNummer, projects.get(0).getProjectNr());
    }
}
