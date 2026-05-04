package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.*;

import com.projectmanager.Aktivitet;
import com.projectmanager.Medarbejder;

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

    @When("{string} bestemmer start- og sluttid til {string} som datoer {LocalDate}, {LocalDate}")
    public void bestem_start_og_slut(String medarbejder, Aktivitet aktivitet, LocalDate startDate, LocalDate slutDate){
        aktivitet1 = aktivitet;
    }

    @When("{LocalDate} er senere end {LocalDate}")
    public void start_efter_slut(LocalDate start, LocalDate slut){
        startFørSlut = !start.isAfter(slut);
    }

    @Then("tildel {string} datoerne, {LocalDate} og {LocalDate} som værende afgrænsede tid for færdiggørelse af projekt")

    @Then("handling feljer med fejlbesked: 'Startdato kan ikke være efter slutdato'")
    public void fejler(){
        if (startFørSlut) {
            System.out.println("Startdato kan ikke være efter slutdato");
        }
    }
}

*/

