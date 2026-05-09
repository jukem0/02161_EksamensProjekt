package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LavRapportStepDef {

    @Given("en {string} er tilmeldt projekt {string}")
    public void er_tilmeldt_projekt(String medarbejder, String projektNavn) {
    }

    @When("en {string} genererer rapport")
    public void forsøg_generer_rapport(String medarbejder) {
    }

    @When("der ikke er nogle aktivitet i projektet")
    public void projekt_mangler_aktiviteter() {
    }

    @Then("generer rapport ved navn {string}-rapport-uge-{int}")
    public void generer_rapport(String projektNavn, int ugenummer) {
    }

    @Then("handling fejler med fejlbesked: 'ingen aktiviteter i projekt'")
    public void handling_fejler() {
    }
}
