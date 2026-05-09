package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import com.projectmanager.app.Main;
import com.projectmanager.model.Aktivitet;
import com.projectmanager.model.Medarbejder;
import com.projectmanager.model.Projekt;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class registrerTid {
    private String errorMessage = "";
    private double testTid = 0;

    @Given("følgende medarbejdere findes i systemet:")
    public void følgende_medarbejdere_findes_i_systemet(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String initialer = row.get("medarbejder").replace("\"", "");
            if (!Main.findMedarbejder(initialer)) {
                Main.systemMedarbejdere.add(new Medarbejder(initialer));
            }
        }
    }

    @Given("en {string} findes i systemet")
    public void en_medarbejder_findes_i_systemet(String medarbejder) {
        String ini = medarbejder.replace("\"", "");
        assertTrue(Main.findMedarbejder(ini), "Medarbejder " + ini + " findes ikke");
    }

    @When("en {string} indtaster deres tid brugt på et projekt som decimaltal eller heltal {double}")
    public void en_indtaster_deres_tid(String medarbejder, double timer) {
        this.testTid = timer;
    }

    @Then("Under {string} findes tiden brugt af {string} rundet op til nærmeste halve")
    public void under_aktivitet_findes_tiden(String aktivitetNavn, String medarbejderNavn) throws Exception {
        String actName = aktivitetNavn.replace("\"", "");
        String mName = medarbejderNavn.replace("\"", "");

        // Find eller opret projekt og aktivitet for at testen kan køre
        Projekt p;
        if (Main.systemProjekter.isEmpty()) {
            p = new Projekt("TestProjekt");
            Main.systemProjekter.add(p);
        } else {
            p = Main.systemProjekter.get(0);
        }

        Aktivitet a = p.getAktiviteter().stream()
                .filter(act -> act.getName().equalsIgnoreCase(actName))
                .findFirst()
                .orElseGet(() -> {
                    p.tilføjAktivitet(actName);
                    return p.getAktiviteter().get(p.getAktiviteter().size() - 1);
                });

        a.registrerTid(mName, testTid);

        double expected = Math.ceil(testTid * 2) / 2.0;
        assertEquals(expected, a.getRegistreretTid(mName), 0.001);
    }

    @Then("handling fejler med fejlbesked: {string}")
    public void handling_fejler_med_fejlbesked(String expectedError) {
        // Vi skal simulere handlingen her for at fange fejlen
        try {
            Projekt p = new Projekt("ErrorTest");
            p.tilføjAktivitet("TestAct");
            p.getAktiviteter().get(0).registrerTid("test", testTid);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals(expectedError.replace("\"", ""), errorMessage);
    }
}
