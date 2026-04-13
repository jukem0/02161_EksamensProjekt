package stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.projectmanager.Medarbejder;
import com.projectmanager.Projekt;

public class DanProjektSteps {

    ArrayList<Projekt> projekter = new ArrayList<>();
    private Projekt testProjekt;
    private Medarbejder testMedarbejder;

    @Given("en {string} findes i systemet")
    public void en_medarbejder_findes_i_systemet(String medarbejder) {
        testMedarbejder.setName(medarbejder);
    }

    @When("et projekt med navn {string} ikke findes i systemet")
    public void et_projekt_findes_ikke_i_systemet(String projektnavn) {
        assertFalse(projekter.contains(projektnavn));
    }

    @When("en medarbejder opretter et projekt med navn {string}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {
        projekter.add(testProjekt);
    }

    @Then("opret projekt med navn {string} og unikt projektnummer {string}")
    public void opret_projekt_og_tildel_projekt_nummer(String projektnavn, String UID) {
        testProjekt.setProjektNr(UID);
    }

    @Given("følgende medarbejdere findes i systemet:")
    public void følgende_medarbejdere_findes_i_systemet(io.cucumber.datatable.DataTable dataTable) {
        ArrayList<String> medarbejdere_som_findes = new ArrayList<>();
        medarbejdere_som_findes.add("huba");
        medarbejdere_som_findes.add("ambe");
        medarbejdere_som_findes.add("joni");
        throw new io.cucumber.java.PendingException();
    }

    @Given("en [medarbejder] findes i systemet")
    public void en_medarbejder_findes_i_systemet() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("en [medarbejder] opretter et projekt med navn [projektnavn]")
    public void en_medarbejder_opretter_et_projekt_med_navn_projektnavn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("et projekt med navn [projektnavn] ikke findes i systemet")
    public void et_projekt_med_navn_projektnavn_ikke_findes_i_systemet() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("opret projekt med navn [projektnavn] og unikt projektnummer")
    public void opret_projekt_med_navn_projektnavn_og_unikt_projektnummer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
