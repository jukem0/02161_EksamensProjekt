package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AktivitetTidStepDef {
    int aktivitetIndex = -1;
    boolean startBeforeEnd;
    Week startDato, slutDato;
    Project tempProject;
    String errorMessage = "Startdato kan ikke være efter slutdato";
    Employee employee;

    @Given("at {string} er projektleder under projekt {string}")
    public void er_projektleder(String employee, String project) {
        this.employee = new Employee(employee);
        this.tempProject = new Project(project);
        Employee.assignProjectleader(this.tempProject.getProjectNr(), this.employee);
    }

    @When("{string} bestemmer slutdato, {week}, og {int} for aktiviteten {string}")
    public void bestem_start_og_slut(String employee, String activity, String endDate) {

    }

    @When("{int} er negativ")
    public void start_efter_slut(int ugemængde) {
        assertFalse(ugemængde>0);
    }

    @Then("tildel {string} datoerne, {Week} og {Week} som værende afgrænsede tidfor færdiggørelse af projekt")
    public void tildelDatoer() {

    }

    @Then("handling feljer med fejlbesked: {string}")
    public void fejler(String string) {
        assertEquals(errorMessage, string);
    }
}
