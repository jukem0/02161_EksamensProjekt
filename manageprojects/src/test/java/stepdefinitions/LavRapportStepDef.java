package stepdefinitions;

import java.time.Year;

import static org.junit.Assert.assertEquals;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.projectmanager.services.RuntimeContext;

//lavet af sara

public class LavRapportStepDef {

    private Project curProject;
    private Project pro;
    private String outputtet;
    private String errorMsg = "";

    @Given("en {string} er tilmeldt projekt {string}")
    public void er_tilmeldt_projekt(String employee, String projektNavn) {

        Employee curEmployee = new Employee(employee);
        curProject = new Project(projektNavn);
        curProject.addActivity("Gunner rundt om jorden", 100, new Week(23, Year.now().getValue()), 5);
        curProject.getEmployeeMap().put(curEmployee, null);
    }

    @When("en medarbejder genererer rapport for uge {int}")
    public void forsøg_generer_rapport(int weeknr) {
        try {
            outputtet = curProject.generateReport(weeknr);
        } catch (Exception e) {
            RuntimeContext.setErrorMsg(e.getMessage());
        }
    }

    @When("der ikke er nogle aktivitet i projektet")
    public void projekt_mangler_aktiviteter() {
        // We want curProject to be the one we just generated report for, but empty.
        // The Background/And step might have created curProject with activities.
        // So we override it with a fresh one.
        if (curProject != null) {
            curProject = new Project(curProject.getName());
        } else {
            curProject = new Project("EmptyProject");
        }
    }

    @Then("generer rapport ved navn {string}-rapport-uge-{int}")
    public void generer_rapport(String projektNavn, int ugenummer) {
        assertEquals(outputtet, curProject.generateReport(ugenummer));
    }
}
