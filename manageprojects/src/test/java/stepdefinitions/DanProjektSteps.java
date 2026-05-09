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
import com.projectmanager.model.Projekt;

public class DanProjektSteps {

    @When("en medarbejder opretter et projekt med navn {string}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {
    }

    @When("et projekt med navn {string} ikke findes i systemet")
    public void et_projekt_findes_ikke_i_systemet(String projektnavn) {
    }

    @When("et projekt med navn {string} findes i systemet")
    public void et_projekt_findes_i_systemet(String projektnavn) {
    }

    @Then("opret projekt med navn {string} og unikt projektnummer {string}")
    public void opret_projekt_og_tildel_projekt_nummer(String projektnavn, String UID) {
    }

    @Then("Fejler handling med besked {string}")
    public void fejler_handling_med_besked(String besked) {
    }

}
