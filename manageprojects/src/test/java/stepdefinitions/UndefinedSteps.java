package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UndefinedSteps {

    // aktivitetertid.feature steps
    @Given("en {string} findes i systemet")
    public void en_medarbejder_findes_i_systemet(String medarbejder) {
        throw new io.cucumber.java.PendingException();
    }

    @Given("at {string} er projektleder under {string}")
    public void at_medarbejder_er_projektleder_under(String medarbejder, String projektnavn) {
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} bestemmer start- og sluttid til {string} som datoer {string}, {string}")
    public void medarbejder_bestemmer_start_og_sluttid(String medarbejder, String aktivitet, String startdato, String slutdato) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("tildel {string} datoerne, {string} og {string} som værende afgrænsede tid for færdiggørelse af projekt")
    public void tildel_datoer(String aktivitet, String startdato, String slutdato) {
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} er senere end {string}")
    public void er_senere_end(String start, String slut) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("handling fejler med fejlbesked: {string}")
    public void handling_fejler_med_fejlbesked(String fejlbesked) {
        throw new io.cucumber.java.PendingException();
    }

    // bestembudgetterettid.feature steps
    @When("{string} bestemmer budgetteret tid til {string} som positivt decimaltal eller heltal")
    public void bestemmer_budgetteret_tid(String medarbejder, String aktivitet) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("tildel {string} mængde af budgetteret tid rundet op til nærmeste halve")
    public void tildel_budgetteret_tid(String aktivitet) {
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} bestemmer budgetteret tid, {string}, til {string} som andet end decimal- eller heltal")
    public void bestemmer_budgetteret_tid_forkert(String medarbejder, String budget, String aktivitet) {
        throw new io.cucumber.java.PendingException();
    }

    // opretaktivitet.feature steps - færdiggjort i aktivitetstepdefinitions.java

    // registreretid.feature steps
    @When("en {string} indtaster deres tid brugt på et projekt som decimaltal eller heltal")
    public void indtaster_tid_brugt(String medarbejder) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("Under {string} findes tiden brugt af {string} rundet op til nærmeste halve")
    public void under_findes_tiden_brugt(String aktivitet, String medarbejder) {
        throw new io.cucumber.java.PendingException();
    }

    @And("tiden indtastet er negativt")
    public void tiden_er_negativt() {
        throw new io.cucumber.java.PendingException();
    }

    // tildelmedarbejder.feature steps
    @When("en medarbejder {string} udpeger en anden medarbejder {string} til at lave aktivitet med {string}")
    public void medarbejder_udpeger_anden(String medarbejder1, String medarbejder2, String aktivitet) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("tildel medarbejder {string} til aktivitet med navn {string} skal lykkes")
    public void tildel_medarbejder_til_aktivitet_skal_lykkes(String medarbejder, String aktivitet) {
        throw new io.cucumber.java.PendingException();
    }

    @When("en anden medarbjeder udpeger {string} til at lave aktivitet med {string}")
    public void anden_udpeger_til_aktivitet(String medarbejder, String aktivitet) {
        throw new io.cucumber.java.PendingException();
    }

    @And("{string} er allerede tildelt aktivitet")
    public void medarbejder_allerede_tildelt(String medarbejder) {
        throw new io.cucumber.java.PendingException();
    }

    // tildelprojektleder.feature steps

    // genererrapport.feature steps
    @Given("en {string} er tilmeldt projekt {string}")
    public void er_tilmeldt_projekt(String medarbejder, String projektnavn) {
        throw new io.cucumber.java.PendingException();
    }

    @When("en {string} genererer rapport")
    public void genererer_rapport(String medarbejder) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("generer rapport ved navn {string}-rapport-uge-{int}")
    public void generer_rapport_ved_navn(String projektnavn, int uge) {
        throw new io.cucumber.java.PendingException();
    }

    @And("der ikke er nogle aktiviteter i projektet")
    public void der_ikke_er_aktiviteter(String projektnavn) {
        throw new io.cucumber.java.PendingException();
    }

    // danprojekt.feature steps
    @When("en medarbejder opretter et projekt med navn {string}")
    public void medarbejder_opretter_projekt(String projektnavn) {
        throw new io.cucumber.java.PendingException();
    }

    @And("et projekt med navn {string} ikke findes i systemet")
    public void projekt_ikke_findes(String projektnavn) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("opret projekt med navn {string} og unikt projektnummer {string}")
    public void opret_projekt_med_nummer(String projektnavn, String nummer) {
        throw new io.cucumber.java.PendingException();
    }

    @And("et projekt med navn {string} findes i systemet")
    public void projekt_findes(String projektnavn) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("Fejler handling med besked {string}")
    public void fejler_handling_med_besked(String besked) {
        throw new io.cucumber.java.PendingException();
    }
}
