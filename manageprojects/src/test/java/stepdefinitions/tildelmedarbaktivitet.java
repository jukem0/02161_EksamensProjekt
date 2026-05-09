package stepdefinitions;

import io.cucumber.java.en.*;
import com.projectmanager.app.*;
import com.projectmanager.model.*;

public class tildelmedarbaktivitet {
    @Given("der findes en aktivitet med navn {string} i projektet")
    public void getActivity(String aktivitetsnavn) {
    }

    @When("en medarbedjer udpeger en anden medarbejder {string} til at lave aktivitet med navn {string}")
    public void addEmployeeToActivity(Activity activityName) {
        
    }

    @Then("tildel medarbejder {string} til aktivitet med navn {string} skal lykkes")
    public boolean addEmployeeToActivity(Activity activityName) {

    }

    @And("medarbejder {string} allerede er tildelt aktivitet med navn {string}")
    public boolean medarbejderAlleredeTildelt(String aktivitetsnavn) {

    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede tildelt til denne aktivitet'")
    public boolean handlingFejler(String aktivitetsnavn) {
        
    }
}
