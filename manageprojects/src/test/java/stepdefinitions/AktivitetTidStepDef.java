package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.projectmanager.App.*;
import com.projectmanager.model.*;

import io.cucumber.java.en.*;


public class AktivitetTidStepDef {

    @Given("at {string} er projektleder under projekt {string}")
    public void er_projektleder(String medarbejder, String projekt) {
    }

    @When("{string} bestemmer start- og sluttid til {string} som datoer {Uge}, {Uge}")
    public void bestem_start_og_slut(String medarbejder, String aktivitet, Uge startDate, Uge slutDate) {
    }

    @When("{Uge} er senere end {Uge}")
    public void start_efter_slut(Uge start, Uge slut) {
    }

    @Then("tildel {string} datoerne, {Uge} og {Uge} som værende afgrænsede tid for færdiggørelse af projekt")
    public void tildelDatoer() {
        
    }

    @Then("handling feljer med fejlbesked: 'Startdato kan ikke være efter slutdato'")
    public void fejler() {

    }
}
