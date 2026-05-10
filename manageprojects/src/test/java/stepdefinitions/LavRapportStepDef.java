package stepdefinitions;

import java.time.Year;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
=======
import static org.junit.Assert.assertTrue;
>>>>>>> 1775d8218ace5b6ec09c4dbe5a7d1f6ed65d6962

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//lavet af sara

public class LavRapportStepDef {

    @Given("en {string} er tilmeldt projekt {string}")
<<<<<<< HEAD
    public void er_tilmeldt_projekt(String employee, String projektNavn) {

        Employee curEmployee = new Employee(employee);
        Project curProject = new Project(projektNavn);
        curProject.addActivity("Gunner rundt om jorden", 100, new Week(23, Year.now().getValue()), 5);
        curProject.getEmployeeMap().put(curEmployee, null);
        // curProject.getActivityMap().put(curProject.getActivityName(projektNr), null);
=======
    public void er_tilmeldt_projekt(String employee, String projektNr) {

        Employee curEmployee = new Employee(employee);
        Project curProject = new Project(projektNr);
        curProject.addActivity("Gunner rundt om jorden", 100, new Week(23, Year.now().getValue()), 5);
        // curProject.getActivityMap().put(curProject.getActivityName(projektNr), null);

        assertTrue(curProject.isEmployeeInProject(curProject.getEmployeeMap(), curEmployee));
>>>>>>> 1775d8218ace5b6ec09c4dbe5a7d1f6ed65d6962
    }

    @When("en {string} genererer rapport")
    public void forsøg_generer_rapport(String medarbejder) {
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
