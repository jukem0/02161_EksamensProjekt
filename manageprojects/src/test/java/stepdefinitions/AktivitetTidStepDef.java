package stepdefinitions;

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

    @Given("at {string} er projektleder under projekt {string}")
    public void er_projektleder(String employee, String project) {
        this.employee = new Employee(employee);
        this.project = new Project(project);
        Employee.assignProjectleader(this.project.getProjectNr(), this.employee);
    }

    @Given("{string} er findes i systemet")
    public void aktivitet_i_systemet(String string){
        this.activity = new Activity(string);
    }

<<<<<<< HEAD
    @When("{string} bestemmer slutdato, {int}, {int}, og {int} for aktiviteten {string}")
=======
    @When("{string} bestemmer slutdato, {int},{int}, og {int} for aktiviteten {string}")
>>>>>>> 0e3ed8a6abeae0aaf3a1d7b8ef0f87152203e997
    public void bestem_start_og_slut(String employee, String activity, int endWeek, int endYear, int weekAmount) {
        String[] inputToParse = {endWeek+"", endYear+""};
        this.weekAmount = weekAmount;
        this.endWeek = Parser.stringsToWeek(inputToParse);
    }

    
    @When("tilder {string} slutdatoen, {Week}, og {int} uger som værende afgrænsede tid for færdiggørelse af projekt")
    public void tildel_activitetstid(){
        activity.setEndWeek(endWeek);
        activity.setWeekAmount(weekAmount);
    }

    @When("{int} er negativ")
    public void start_efter_slut(int ugemængde) {
        assertFalse(ugemængde>0);
    }
    
    @Then("kan <aktivitetsnavn> findes under projektet med slutdatoen, <slutdato>, og <antaluger> uger")
    public void tildelDatoer(Week expectedEndWeek, int expectedWeekAmount) {
        assertTrue(this.activity.getEndWeek().equals(expectedEndWeek) && this.activity.getWeekAmount() == expectedWeekAmount);
    }

    @Then("handling feljer med fejlbesked: {string}")
    public void fejler(String string) {
        assertEquals(errorMessage, string);
    }
}
