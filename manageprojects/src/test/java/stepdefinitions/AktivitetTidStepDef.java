package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.projectmanager.app.Main;
import com.projectmanager.model.Projekt;
import com.projectmanager.model.Uge;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AktivitetTidStepDef {
    int aktivitetIndex = -1;
    boolean startFørSlut;
    Uge startDato, slutDato;
    Projekt tempProjekt = null;

    // @Given("en {string} findes i systemet")
    // public boolean getmedarbejder(String medarbejder) {
    // // Implementation for checking if an employee exists in the system
    // return false;
    // }

    @Given("at {string} er projektleder under projekt {string}")
    public void er_projektleder(String medarbejder, String projekt) {
        for (Projekt p : Main.getProjekter()) {
            if (p.getProjektNavn().equalsIgnoreCase(projekt)) {
                tempProjekt = p;
            }
        }
        if (tempProjekt != null) {
            assertTrue(tempProjekt.getProjektLeder().getName().equalsIgnoreCase(medarbejder),
                    "Medarbejder " + medarbejder + " er ikke projektleder i projektet " + projekt);
        }
    }

    @When("{string} bestemmer start- og sluttid til {string} som datoer {Uge}, {Uge}")
    public void bestem_start_og_slut(String medarbejder, String aktivitet, Uge startDate, Uge slutDate) {
        for (int x = 0; x < tempProjekt.getAktiviteter().size(); x++) {
            if (tempProjekt.getAktiviteter().get(x).getName().equalsIgnoreCase(aktivitet)) {
                aktivitetIndex = x;
            }
        }
        startDato = startDate;
        slutDato = slutDate;
        assertFalse(aktivitetIndex == -1, "Ingen aktivitet med navn " + aktivitet + " fundet");
    }

    @When("{Uge} er senere end {Uge}")
    public void start_efter_slut(Uge start, Uge slut) {
        assertFalse(start.erEfter(slut), "Startdato er efter slutdato");
    }

    @Then("tildel {string} datoerne, {Uge} og {Uge} som værende afgrænsede tid for færdiggørelse af projekt")
    public void tildelDatoer() {
        tempProjekt.getAktiviteter().get(aktivitetIndex).redigerTidsperiode(startDato, slutDato);
    }

    @Then("handling feljer med fejlbesked: 'Startdato kan ikke være efter slutdato'")
    public void fejler() {
        if (startFørSlut) {
            System.out.println("Startdato kan ikke være efter slutdato");
        }
    }
}
