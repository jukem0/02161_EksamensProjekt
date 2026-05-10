package stepdefinitions;

import static org.junit.Assert.assertFalse;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


//lavet af sara og fabrizio

public class tildelmedarbaktivitet {

    private String errorMessageEmployeeAlrAdd;


    @Given("der findes en aktivitet med navn {string} i projektet {string}")
    public void checkIfActivityInProject(String testActivity, String pro) {

        Project Pro = new Project(pro);
       
        Activity act1 = new Activity(testActivity,20.1, new Week(5, 2026),1);
        Activity act2 = new Activity(testActivity,20.1, new Week(4, 2026),1);

        Pro.addActivity(act2, new Employee("nejo"));
        
        assertFalse(Pro.isActivityInProject(act1));
    }

    // @And findes i CreateProjectSteps

    @When("en medarbedjer udpeger en anden medarbejder {string} til at være tilknyttet aktivitet med navn {string}")
    public void iTryToAddEmployeeToActivity(String emp, String act) throws Exception {
        
        try {
            addEmployeeToActivity(emp,act);
        } catch (Exception e){
            errorMessageEmployeeAlrAdd = "The employee is already a part of this activity";
        }
    }

    @Then("tildel medarbejder {string} til aktivitet med navn {string} skal lykkes")
    public void addEmployeeToActivity(String emp, String activityName) {
        
        Activity act = new Activity(activityName, 20.1, new Week(5, 2026),1);
        Employee Emp = new Employee(emp);
        act.addEmployeeToActivity(Emp);

        assert (act.getEmployees().contains(Emp));
    }

    @And("medarbejder {string} allerede er tildelt aktivitet med navn {string}")
    public void medarbejderAlleredeTildelt(String emp, String activityName) {

        Activity act = new Activity(activityName,20.1, new Week(5, 2026),1);
        Employee Emp = new Employee(emp);
        act.addEmployeeToActivity(Emp);
        act.addEmployeeToActivity(Emp);
    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede tildelt til denne aktivitet'")
    public void handlingFejler(String aktivitetsnavn) {

        System.out.println(errorMessageEmployeeAlrAdd);
    }
}
