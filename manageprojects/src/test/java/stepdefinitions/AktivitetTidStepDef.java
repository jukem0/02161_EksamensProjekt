package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.projectmanager.*;

public class AktivitetTidStepDef {
    Aktivitet aktivitet1;
    boolean startFørSlut;

    // @Given("en {string} findes i systemet")
    // public boolean getmedarbejder(String medarbejder) {
    //     // Implementation for checking if an employee exists in the system
    //     return false;
    // }

    @Given("at {string} er projektleder under projekt {string}")
    public void er_projektleder(String medarbejder){
        // Implementation for checking if an employee is a project leader for a project
    }

    @When("{string} bestemmer start- og sluttid til {string} som datoer {Uge}, {Uge}")
    public void bestem_start_og_slut(String medarbejder, Aktivitet aktivitet, Uge startDate, Uge slutDate){
        aktivitet1 = aktivitet;
    }

    @When("{Uge} er senere end {Uge}")
    public void start_efter_slut(Uge start, Uge slut){
        startFørSlut = !start.erEfter(slut);
    }

    @Then("tildel {string} datoerne, {Uge} og {Uge} som værende afgrænsede tid for færdiggørelse af projekt")

    @Then("handling feljer med fejlbesked: 'Startdato kan ikke være efter slutdato'")
    public void fejler(){
        if (startFørSlut) {
            System.out.println("Startdato kan ikke være efter slutdato");
        }
    }
}



