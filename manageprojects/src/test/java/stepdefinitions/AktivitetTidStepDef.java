package stepdefinitions;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AktivitetTidStepDef {
    int aktivitetIndex = -1;
    boolean startFørSlut;
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

    @When("{string} bestemmer start- og sluttid til {string} som datoer {Week}, {Week}")
    public void bestem_start_og_slut(String medarbejder, String aktivitet, Week startDate, Week slutDate) {
    }

    @When("{Week} er senere end {Week}")
    public void start_efter_slut(Week start, Week slut) {
    }

    @Then("tildel {string} datoerne, {Week} og {Week} som værende afgrænsede tidfor færdiggørelse af projekt")
    public void tildelDatoer() {

    }

    @Then("handling feljer med fejlbesked: 'Startdato kan ikke være efterslutdato'")
    public void fejler() {

    }
}
