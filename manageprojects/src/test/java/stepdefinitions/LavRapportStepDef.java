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
    private Project pro;
    private String outputtet;

    @Given("en {string} er tilmeldt projekt {string}")
    public void er_tilmeldt_projekt(String employee, String projektNavn) {

        Employee curEmployee = new Employee(employee);
        curProject = new Project(projektNavn);
        curProject.addActivity("Gunner rundt om jorden", 100, new Week(23, Year.now().getValue()), 5);
        curProject.getEmployeeMap().put(curEmployee, null);
        // curProject.getActivityMap().put(curProject.getActivityName(projektNr), null);
    }

    @When("en medarbejder genererer rapport for uge {int}")
    public void forsøg_generer_rapport(int weeknr) {
        outputtet = curProject.generateReport(weeknr);
    }

    @When("der ikke er nogle aktivitet i projektet")
    public void projekt_mangler_aktiviteter() {

        pro = new Project("idkman");
    }

    @Then("generer rapport ved navn {string}-rapport-uge-{int}")
    public void generer_rapport(String projektNavn, int ugenummer) {
        assertEquals(outputtet, curProject.generateReport(ugenummer));
        // Project pro = new Project(projektNavn);
        // pro.generateReport(ugenummer);
        
    }

    @Then("handling fejler med fejlbesked: 'ingen aktiviteter i projekt'")
    public void handling_fejler() throws IllegalArgumentException {
        try {
            pro.generateReport(1);
        } catch(Exception e) {
            assert(e.getMessage().equalsIgnoreCase("ingen aktiviteter i projekt"));
        }
    }
}
