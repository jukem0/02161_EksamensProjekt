package stepdefinitions;

import java.time.Year;

import static org.junit.Assert.assertEquals;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//lavet af sara

public class LavRapportStepDef {

    private Project curProject;

    @Given("en {string} er tilmeldt projekt {string}")
    public void er_tilmeldt_projekt(String employee, String projektNavn) {

        Employee curEmployee = new Employee(employee);
        Project curProject = new Project(projektNavn);
        curProject.addActivity("Gunner rundt om jorden", 100, new Week(23, Year.now().getValue()), 5);
        curProject.getEmployeeMap().put(curEmployee, null);
        // curProject.getActivityMap().put(curProject.getActivityName(projektNr), null);
    }

    @When("en {string} genererer rapport")
    public void forsøg_generer_rapport(String medarbejder) {
        curProject.generateReport();
    }

    @When("der ikke er nogle aktivitet i projektet")
    public void projekt_mangler_aktiviteter() {
    }

    @Then("generer rapport ved navn {string}-rapport-uge-{int}")
    public void generer_rapport(String projektNavn, int ugenummer) {
    }

    @Then("handling fejler med fejlbesked: 'ingen aktiviteter i projekt'")
    public void handling_fejler() {
    }
}
