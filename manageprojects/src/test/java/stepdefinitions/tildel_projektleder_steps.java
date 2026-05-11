package stepdefinitions;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.EmployeesFunctions;
import com.projectmanager.services.RuntimeContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class tildel_projektleder_steps {

    private String error = "";

    @Given("en medarbejder {string} er ledig")
    public void enMedarbejderErLedig(String initials) {
        Employee emp = RuntimeContext.getEmployees().stream()
                .filter(e -> e.getEmployeeName().equals(initials))
                .findFirst().orElseGet(() -> {
                    Employee newEmp = new Employee(initials);
                    RuntimeContext.getEmployees().add(newEmp);
                    return newEmp;
                });
        assertTrue(emp.isAvailable());
    }

    @When("en anden medarbejder {string} udpeger {string} som projektleder for projektet")
    public void udpegerSomProjektleder(String udpeger, String medarbejder) {
        Employee emp = RuntimeContext.getEmployees().stream()
                .filter(e -> e.getEmployeeName().equals(medarbejder))
                .findFirst().orElseThrow();
        // Get the latest project added
        Project pro = RuntimeContext.getProjects().get(RuntimeContext.getProjects().size() - 1);

        try {
            EmployeesFunctions.assignProjectleader(pro, emp);
        } catch (Exception e) {
            error = e.getMessage();
        }
    }

    @Then("er {string} registreret som projektleder for {string}")
    public void erRegistreretSomProjektleder(String medarbejder, String projectName) {
        Project pro = RuntimeContext.getProjects().stream()
                .filter(p -> p.getName().equals(projectName))
                .findFirst().orElseThrow();
        assertNotNull(pro.getProjectLeader());
        assertEquals(medarbejder, pro.getProjectLeader().getEmployeeName());
    }

    @Given("medarbejder {string} allerede er projektleder for et andet projekt med navn {string}")
    public void medarbejderAlleredeErProjektlederForEtAndetProjekt(String medarbejder, String otherProjectName) {
        Employee emp = RuntimeContext.getEmployees().stream()
                .filter(e -> e.getEmployeeName().equals(medarbejder))
                .findFirst().orElseGet(() -> {
                    Employee newEmp = new Employee(medarbejder);
                    RuntimeContext.getEmployees().add(newEmp);
                    return newEmp;
                });
        Project otherProject = new Project(otherProjectName);
        RuntimeContext.getProjects().add(otherProject);

        try {
            EmployeesFunctions.assignProjectleader(otherProject, emp);
        } catch (Exception e) {
            // Ignored as this is setup
        }
    }

    @When("en anden medarbejder {string} udpeger medarbejder {string} som projektleder for projekt {string}")
    public void udpegerSomProjektlederForProjekt(String udpeger, String medarbejder, String projectName) {
        Employee emp = RuntimeContext.getEmployees().stream()
                .filter(e -> e.getEmployeeName().equals(medarbejder))
                .findFirst().orElseThrow();
        Project pro = RuntimeContext.getProjects().stream()
                .filter(p -> p.getName().equals(projectName))
                .findFirst().orElseThrow();

        try {
            EmployeesFunctions.assignProjectleader(pro, emp);
        } catch (Exception e) {
            error = e.getMessage();
        }
    }

    @Then("fejler handling med fejlbesked: {string}")
    public void fejlerHandlingMedFejlbesked(String expectedError) {
        assertEquals(expectedError, error);
    }
}
