package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.projectmanager.*;

public class tildel_projektleder_steps{
    Main.ProjektlederStat status;
    @And("en medarbejder {string} er ledig")
    public void ledigcheck(String medarbejder){
        assert(Main.erLedig(medarbejder)): "Medarbejder " + medarbejder + " er ikke ledig.";
    }
    
    @When("en anden medarbejder {string} udpeger medarbejder {string} som projektLeder for projekt {string}")
    public void udpegning(String udpeger, String medarbejder, String projekt){
        assert (udpeger.appointPL(projekt, medarbejder)) : "Tildeling mislykkedes: Medarbejder " + medarbejder + " findes ikke i systemet eller er ikke ledig.";
        status = Main.erProjektleder(projekt, medarbejder);
    }

    @Then("tildel medarbejder {string} som projektleder for projekt {string} skal lykkes")
    public void tildelProjektlederSuccess(String medarbejder, String projekt) {
        assert (status.erProjektLeder()) : "Tildeling mislykkedes: Medarbejder " + medarbejder + " findes ikke i systemet.";
        System.out.println("Medarbejder " + medarbejder + " er nu projektleder for projekt " + projekt);
    }

    @And("medarbejder {string} allerede er projektleder for et andet projekt med navn {string}")
    public void medarbejderErProjektlederForAndetProjekt(String medarbejder, String projekt) {
        assert (!status.erProjektLeder() && status.projektnavn() != null && !status.projektnavn().equals(projekt)) : "Medarbejder " + medarbejder + " er allerede projektleder for et andet projekt:" + projekt;
    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede projektleder for et andet projekt'")
    public void tildelPLFejler(String medarbejder, String projekt) {
        assert (!status.erProjektLeder()) : "Handling fejler: Medarbejder " + medarbejder + " er allerede projektleder for projekt " + projekt;
    }
    

}

