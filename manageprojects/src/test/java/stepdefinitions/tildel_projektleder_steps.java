package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tildel_projektleder_steps{
    @Given("et projekt med navn {string} findes i systemet"){
    public void getprojekt(String projekt) {
        }
    }
    @And("en medarbejder {string} er ledig"){
        
    }
    @When("en anden medarbejder {string} udpeger medarbejder {string} som projektLeder for projekt {string}"){

    }
    @Then("tildel medarbejder {string} som projektleder for projekt {string} skal lykkes")
    public boolean tildelProjektlederSuccess(String medarbejder, String projekt) {
        if (findMedarbejder(medarbejder)) {
            System.out.println("Medarbejder " + medarbejder + " er nu projektleder for projekt " + projekt);
            return true;
        } else {
            System.out.println("Tildeling mislykkedes: Medarbejder " + medarbejder + " findes ikke i systemet.");
            return false;
        }
    }
    @And("medarbejder {string} allerede er projektleder for et andet projekt med navn {string}"){
        if (findMedarbejder(medarbejder)) {
            System.out.println("Medarbejder " + medarbejder + " er allerede projektleder for projekt " + projekt);
        } else {
            System.out.println("Medarbejder " + medarbejder + " er ikke projektleder for noget projekt.");
        }
    }
    @then("handling fejler med fejlbesked: 'Medarbejder er allerede projektleder for et andet projekt'")
    public boolean handlingFejler(String medarbejder, String projekt) {
        if (findMedarbejder(medarbejder)) {
            System.out.println("Handling fejler med fejl besked: 'Medarbejder " + medarbejder + " er allerede projektleder for projekt " + projekt + "'");
            return true;
        } else {
            System.out.println("Handling fejler med fejl besked: 'Medarbejder " + medarbejder + " findes ikke i systemet.'");
            return false;
        }
    }

}
*/

