package stepdefinitions;

import static org.junit.Assert.assertEquals;

import com.projectmanager.services.InitializeEmployees;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectSteps {
    private String foundEmployee = "";
    InitializeEmployees.initializeEmployees();

    @Given("en {string} findes i systemet")
    public void employee_findes_i_systemet(String empName) {
        for (int i = 0; i < InitializeEmployees.employees.size(); i++) {
            if (empName.equals(InitializeEmployees.employees.get(i).getEmployeeName())) {
                foundEmployee = empName;
            } else {
                foundEmployee = null;
            }
        }
        assertEquals(empName, foundEmployee);
    }

    @When("en medarbejder opretter et projekt med navn {string}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {

    }

    @When("et projekt med navn {string} ikke findes i systemet")
    public void et_projekt_findes_ikke_i_systemet(String projektnavn) {
    }

    @When("et projekt med navn {string} findes i systemet")
    public void et_projekt_findes_i_systemet(String projektnavn) {
    }

    @Then("opret projekt med navn {string} og unikt projektnummer {string}")
    public void opret_projekt_og_tildel_projekt_nummer(String projektnavn, String UID) {
    }

    @Then("Fejler handling med besked {string}")
    public void fejler_handling_med_besked(String besked) {
    }

}
