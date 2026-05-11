package stepdefinitions;

import static org.junit.Assert.assertEquals;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.RuntimeContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectSteps {
    int selectedIndex = 0;

    @Given("en {string} findes i systemet")
    public void en_medarbejder_findes_i_systemet(String empName) {
        boolean isInSystem = RuntimeContext.getEmployees().stream()
                .anyMatch(e -> e.getEmployeeName().equals(empName));

        if (!isInSystem) {
            Employee newEmp = new Employee(empName);
            RuntimeContext.getEmployees().add(newEmp);
        }
    }

    @When("en medarbejder opretter et projekt med navn {string}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {
        Project newProject = new Project(projektnavn);
        RuntimeContext.getProjects().add(newProject);
        
        for (int x = 0; x < RuntimeContext.getProjects().size(); x++) {
            if(RuntimeContext.getProjects().get(x).getName().equals(projektnavn)){
                selectedIndex = x;
            }
        }
    }

    @Then("er projektet oprettet og har projekt-nummer {string}")
    public void er_projektet_oprettet_og_har_projekt_nummer(String projectNummer) {
        assertEquals(projectNummer, RuntimeContext.getProjects().get(selectedIndex).getProjectNr());
    }
}