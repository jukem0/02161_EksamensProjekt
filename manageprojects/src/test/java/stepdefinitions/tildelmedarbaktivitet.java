package stepdefinitions;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tildelmedarbaktivitet {

    private Activity testActivity;
    private String errorMessageEmployeeAlrAdd;


    @Given("der findes en aktivitet med navn {string} i projektet {string}")
    public void checkIfActivityInProject(String testActivity, String pro) {

        Project Pro = new Project(pro);
        Pro.addActivity(testActivity);
        Activity act = new Activity(testActivity);
        
        assert(Pro.isActivityInProject(act));
    }

    // @And findes i CreateProjectSteps

    @When("en medarbedjer udpeger en anden medarbejder {string} til at være tilknyttet aktivitet med navn {string}")
    public void iTryToAddEmployeeToActivity(String emp, String act ) throws Exception {
        
        try {
            addEmployeeToActivity(emp,act);
        } catch (Exception e){
            errorMessageEmployeeAlrAdd = "The employee is already a part of this activity";
        }
    }

    @Then("tildel medarbejder {string} til aktivitet med navn {string} skal lykkes")
    public void addEmployeeToActivity(String emp, String activityName) {
        
        Activity act = new Activity(activityName);
        Employee Emp = new Employee("empo");
        act.addEmployeeToActivity(Emp);

        assert (act.getEmployees().contains(Emp));
    }

    @And("medarbejder {string} allerede er tildelt aktivitet med navn {string}")
    public void medarbejderAlleredeTildelt(String aktivitetsnavn) {

        
        
    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede tildelt til denne aktivitet'")
    public void handlingFejler(String aktivitetsnavn) {

        System.out.println(errorMessageEmployeeAlrAdd);
    }
}
