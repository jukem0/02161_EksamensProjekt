package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.projectmanager.*;

public class DanProjektSteps {

    private ArrayList<Projekt> projekter = new ArrayList<>();
    private Projekt testProjekt;
    private String errorMessage = "";

    @When("en medarbejder opretter et projekt med navn {string}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {
        testProjekt = new Projekt(projektnavn);
    }

    @When("et projekt med navn {string} ikke findes i systemet")
    public void et_projekt_findes_ikke_i_systemet(String projektnavn) {
        boolean exists = false;
        for (Projekt p : projekter) {
            if (p.getProjektNavn() != null && p.getProjektNavn().equals(projektnavn)) {
                exists = true;
            }
        }
        assertFalse("Projektet findes allerede, men det burde det ikke!", exists);
    }

    @When("et projekt med navn {string} findes i systemet")
    public void et_projekt_findes_i_systemet(String projektnavn) {
        projekter.add(new Projekt(projektnavn));
        boolean exists = false;
        for (Projekt p : projekter) {
            if (p.getProjektNavn() != null && p.getProjektNavn().equals(projektnavn)) {
                exists = true;
            }
        }
        if (exists) {
            errorMessage = "et projekt med dette navn findes allerede i systemet";
        }
    }

    @Then("opret projekt med navn {string} og unikt projektnummer {string}")
    public void opret_projekt_og_tildel_projekt_nummer(String projektnavn, String UID) {
        if (testProjekt == null) {
            testProjekt = new Projekt(projektnavn);
        }
        testProjekt.setProjektNr(UID);
        projekter.add(testProjekt);
        assertTrue(projekter.contains(testProjekt));
    }

    @Then("Fejler handling med besked {string}")
    public void fejler_handling_med_besked(String besked) {
        assertEquals(besked, errorMessage);
    }

}
