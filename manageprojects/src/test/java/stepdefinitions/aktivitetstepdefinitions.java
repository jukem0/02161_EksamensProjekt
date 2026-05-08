package stepdefinitions;

import com.projectmanager.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

public class aktivitetstepdefinitions {
    private final List<Projekt> projekter = Main.getProjekter();
    // lav en getter metode for at få adgang til aktiviteter fra enhver projekt-#

    private String opretFejlbesked;

    private final List<Medarbejder> systemMedarbejdere = Main.getMedarbejdere();

    private String valgtProjekt;
    private String aktuelMedarbejder;

    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at
                                                                       // vise hvem er i systemet.
        System.out.println("Følgende medarbejdere findes i systemet:" + table.asList());
        // Liste er allerede initialiseret med systemets medarbejdere; denne step er kun
        // til reference.
    }

    @Given("en {string} findes i systemet")
    public void getmedarbejder(String medarbejder) {
        assert Main.findMedarbejder(medarbejder) : "Medarbejder " + medarbejder + " findes ikke i systemet.";
        this.aktuelMedarbejder = medarbejder;
    }

    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projekt) {
        var status = Main.erProjektleder(valgtProjekt, aktuelMedarbejder);
        assert (status.erProjektLeder() || Main.erLedig(aktuelMedarbejder)) : "Medarbejder " + aktuelMedarbejder
                + " er hverken projektleder eller ledig for projektet " + valgtProjekt;
        this.valgtProjekt = projekt;
    }

    @When("projektleder eller ledig medarbejder opretter aktivitet med navn {string}")
    public void opretAktivitet(String aktivitetsnavn) {
        assert (oprettedeAktiviteter.stream().noneMatch(a -> a.getNavn().equals(aktivitetsnavn)))
                : "Aktivitet " + aktivitetsnavn + " findes allerede i projektet " + valgtProjekt;
        System.out.println("Opretter aktivitet med navn: " + aktivitetsnavn);

    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String aktivitetsnavn) {
        oprettedeAktiviteter.add(new Aktivitet(aktivitetsnavn));
        System.out.println("Aktivitet oprettet med navn: " + aktivitetsnavn);
        opretFejlbesked = null;
    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projekt) {
        valgtProjekt = projekt;
        assert Main.projekter.stream().anyMatch(p -> p.getProjektNavn().equals(valgtProjekt))
                : "Projekt " + valgtProjekt + " findes ikke i systemet.";
    }

    @And("der findes allerede en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String aktivitetsnavn) {
        assert (oprettedeAktiviteter.stream().anyMatch(a -> a.getNavn().equals(aktivitetsnavn)))
                : "Aktivitet " + aktivitetsnavn + " findes ikke i projektet " + valgtProjekt;
    }

    @Then("handling fejler med fejlbesked: {string}")
    public void opretAktivitetFailure(String fejlbesked) {
        assert opretFejlbesked != null : "Der var ingen fejl ved oprettelse af aktivitet, men der blev forventet en.";
        assert opretFejlbesked.equals(fejlbesked)
                : "Forventet fejlbesked '" + fejlbesked + "', men fik '" + opretFejlbesked + "'.";
    }

}
