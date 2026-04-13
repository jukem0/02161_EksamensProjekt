package stepdefinitions;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.projectmanager.Medarbejder;

public class DanProjektSteps {
    
    @Given("en {medarbejder} findes i systemet")
    public void en_medarbejder_findes_i_systemet(String medarbejder) {
        Medarbejder huba = new Medarbejder(medarbejder);
    }

    @When("et projekt med navn {projektnavn} ikke findes i systemet")
    public void et_projekt_findes_ikke_i_systemet(String projektnavn) {
        assertEquals(projektnavn, projektnavne.contains(projektnavn));
    }

    @When("en medarbejder opretter et projekt med navn {projektnavn}")
    public void en_medarbejder_opretter_et_projekt(String projektnavn) {
        projektnavne.add(projektnavn);
    }

    @Then("opret projekt med navn {projektnavn} og unikt projektnummer")
    public void opret_projekt_og_tildel_projekt_nummer(String projektnavn) {

    }
}
