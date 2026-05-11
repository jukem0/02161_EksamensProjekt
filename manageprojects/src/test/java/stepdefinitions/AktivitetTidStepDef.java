package stepdefinitions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;
import com.projectmanager.services.Parser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//lavet af Gustav

public class AktivitetTidStepDef {
    Week endWeek;
    int weekAmount;
    Project project;
    String errorMessage = "Startdato kan ikke være efter slutdato";
    Employee employee;
    Activity activity;
    ArrayList<Project> projects = new ArrayList<>();

    @Given("at {string} er projektleder under {string}")
    public void at_medarbejder_er_projektleder_under_projektnavn(String employee, String project) {
        for (Employee e : CreateProjectSteps.employees) {
            if (e.getEmployeeName().equals(employee)) {
                this.employee = e;
            }
        }
        this.project = new Project(project);
        projects.add(this.project);
        Employee.assignProjectleader(this.project.getProjectNr(), this.employee);
    }

    @Given("{string} findes i systemet")
    public void aktivitet_i_systemet(String activityName){
        this.activity = new Activity(activityName);
    }

    @When("{string} bestemmer slutdato, {int}, {int}, og {int} for aktiviteten {string}")
    public void bestem_start_og_slut(String employee, int endWeek, int endYear, int weekAmount, String activityName) {
        String[] inputToParse = {String.valueOf(endWeek), String.valueOf(endYear)};
        this.weekAmount = weekAmount;
        this.endWeek = Parser.stringsToWeek(inputToParse);
        if (this.activity == null || !this.activity.getActivityName().equals(activityName)) {
            this.activity = new Activity(activityName);
        }
    }

    @When("tildeler {string} slutdatoen, {string}, og {int} uger som værende afgrænsede tid for færdiggørelse af projekt")
    public void tildel_activitetstid(String activityName, String endWeekString, int weekAmount){
        if (this.activity == null || !this.activity.getActivityName().equals(activityName)) {
            this.activity = new Activity(activityName);
        }
        String[] parts = endWeekString.split("-");
        Week parsedEndWeek = Parser.stringsToWeek(new String[]{parts[1], parts[0]});
        this.activity.setEndWeek(parsedEndWeek);
        this.activity.setWeekAmount(weekAmount);
    }

    @When("{int} er negativ")
    public void start_efter_slut(int ugemængde) {
        assertFalse(ugemængde > 0);
    }
    
    @Then("kan {string} findes under projektet med slutdatoen, {string}, og {int} uger")
    public void tildelDatoer(String activityName, String expectedEndWeekString, int expectedWeekAmount) {
        String[] parts = expectedEndWeekString.split("-");
        Week expectedEndWeek = Parser.stringsToWeek(new String[]{parts[1], parts[0]});
        assertTrue(this.activity != null && this.activity.getActivityName().equals(activityName)
            && this.activity.getEndWeek().equals(expectedEndWeek)
            && this.activity.getWeekAmount() == expectedWeekAmount);
    }

    @Then("handling fejler med fejlbesked: {string}")
    public void fejler(String string) {
        assertEquals(errorMessage, string);
    }
}
