package stepdefinitions;

import com.projectmanager.model.Activity;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tildelmedarbaktivitet {

    private Activity testActivity;
    private String errorMessageEmployeeAlrAdd;


    @Given("der findes en aktivitet med navn {string} i projektet")
    public void getActivityName(String aktivitetsnavn) {
    }

    // @And findes i CreateProjectSteps

    @When("en medarbedjer udpeger en anden medarbejder {string} til at være tilknyttet aktivitet med navn {string}")
    public void iTryToAddEmployeeToActivity() throws Exception {
        try {
            addEmployeeToActivity(testActivity);
        } catch (Exception e){
            errorMessageEmployeeAlrAdd = "The employee is already a part of this activity";
        }
    }

    @Then("tildel medarbejder {string} til aktivitet med navn {string} skal lykkes")
    public void addEmployeeToActivity(Activity activityName) {
        
    }

    @And("medarbejder {string} allerede er tildelt aktivitet med navn {string}")
    public void medarbejderAlleredeTildelt(String aktivitetsnavn) {
        
    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede tildelt til denne aktivitet'")
    public void handlingFejler(String aktivitetsnavn) {
        System.out.println(errorMessageEmployeeAlrAdd);
    }
}
