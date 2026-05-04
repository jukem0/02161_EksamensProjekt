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

    @Given("en {medarbejder} findes i systemet")
    public boolean getmedarbejder(String medarbejder) {
    }

    @Given("at {medarbejder} er projektleder under projekt {String/Projekt}")
    public void er_projektleder(Medarbejder medarbejder){
        return medarbejder.getLeader()
    }

    @When("{medarbejder} bestemmer start- og sluttid til {String/Aktivitet} som datoer {LocalDate}, {LocalDate}")
    public void bestem_start_og_slut(Medarbejder medarbejder, Aktivitet aktivitet, LocalDate startDate, LocalDate slutDate){
        aktivitet1 = aktivitet;
    }

    @When("{LocalTime} er senere end {LocalTime}")
    public void start_efter_slut(LocalDate start, LocalDate slut){
        startFørSlut = !start.isAfter(slut);
    }

    @Then("tildel {String/Aktivitet} datoerne, {LocalDate} og {LocalDate} som værende afgrænsede tid for færdiggørelse af projekt")

    @Then("handling feljer med fejlbesked: \"Startdato kan ikke være efter slutdato\"")
    public void fejler(){
        if (startFørSlut) {
            System.out.println("Startdato kan ikke være efter slutdato");
        }
    }
}

*/

