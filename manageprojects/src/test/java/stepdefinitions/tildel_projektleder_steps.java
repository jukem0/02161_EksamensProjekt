package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tildel_projektleder_steps {

    @And("en medarbejder {string} er ledig")
    public void ledigcheck(String medarbejder) {
        
    }

    @When("en anden medarbejder {string} udpeger medarbejder {string} som projektLeder for projekt {string}")
    public void udpegning(String udpeger, String medarbejder, String projekt) {
        
    }

    @Then("tildel medarbejder {string} som projektleder for projekt {string} skal lykkes")
    public void tildelProjektlederSuccess(String medarbejder, String projekt) {
       
    }

    @And("medarbejder {string} allerede er projektleder for et andet projekt med navn {string}")
    public void medarbejderErProjektlederForAndetProjekt(String medarbejder, String projekt) {
        
    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede projektleder for et andet projekt'")
    public void tildelPLFejler(String medarbejder) {
    }

}
