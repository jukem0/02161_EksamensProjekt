package stepdefinitions;

import com.projectmanager.Aktivitet;
import com.projectmanager.Medarbejder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aktivitetstepdefinitions {
    private Aktivitet oprettetAktivitet;
    private String opretFejlbesked;
    private final List<Medarbejder> systemMedarbejdere = new ArrayList<>(Arrays.asList(
        new Medarbejder("huba"),
        new Medarbejder("wilo"),
        new Medarbejder("anda")
    ));
    private final Set<String> eksisterendeAktiviteter = new HashSet<>();
    private String valgtProjekt;
    private String aktueltMedarbejder;

    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at vise hvem er i systemet.
        // Liste er allerede initialiseret med systemets medarbejdere; denne step er kun til reference.
    }

    @Given("en {string} findes i systemet")
    public void getmedarbejder(String medarbejder) {
        medarbejder = medarbejder.replace("\"", "");
        this.aktueltMedarbejder = medarbejder;
        assert findMedarbejder(medarbejder) : "Medarbejder " + medarbejder + " findes ikke i systemet.";
    }

    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projekt) {
        valgtProjekt = projekt.replace("\"", "");
        assert (erProjektleder(valgtProjekt, aktueltMedarbejder) || erLedig(aktueltMedarbejder)) : 
            "Medarbejder " + aktueltMedarbejder + " er hverken projektleder eller ledig for projektet " + valgtProjekt;
    }

    @When("projektleder eller {string} opretter aktivitet med navn {string}")
    public void opretAktivitet(String medarbejder, String aktivitetsnavn) {
        medarbejder = medarbejder.replace("\"", "");
        aktivitetsnavn = aktivitetsnavn.replace("\"", "");
        assert findMedarbejder(medarbejder) : "Medarbejder " + medarbejder + " findes ikke i systemet.";
        if (eksisterendeAktiviteter.contains(aktivitetsnavn)) {
            oprettetAktivitet = null;
            opretFejlbesked = "denne aktivitet findes allerede";
            return;
        }
        oprettetAktivitet = new Aktivitet(aktivitetsnavn);
        opretFejlbesked = null;
    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String aktivitetsnavn) {
        aktivitetsnavn = aktivitetsnavn.replace("\"", "");
        if (oprettetAktivitet == null || !oprettetAktivitet.getNavn().equals(aktivitetsnavn)) {
            throw new AssertionError("Aktivitet blev ikke oprettet med navnet: " + aktivitetsnavn);
        }
    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projekt) {
        valgtProjekt = projekt.replace("\"", "");
    }

    @And("projektet har en projektleder, eller en ledig medarbejder")
    public void projektetHarEnProjektlederEllerEnLedigMedarbejder() {
        if (systemMedarbejdere.isEmpty()) {
            throw new AssertionError("Ingen medarbejdere er tilgængelige til projektet " + valgtProjekt);
        }
    }

    @And("der findes en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String aktivitetsnavn) {
        aktivitetsnavn = aktivitetsnavn.replace("\"", "");
        eksisterendeAktiviteter.add(aktivitetsnavn);
    }

    @Then("handling fejler med fejlbesked: {string}")
    public void opretAktivitetFailure(String fejlbesked) {
        fejlbesked = fejlbesked.replace("\"", "");
        assert opretFejlbesked != null : "Der var ingen fejl ved oprettelse af aktivitet, men der blev forventet en.";
        assert opretFejlbesked.equals(fejlbesked) : "Forventet fejlbesked '" + fejlbesked + "', men fik '" + opretFejlbesked + "'.";
    }

    private boolean findMedarbejder(String medarbejder) {
        return systemMedarbejdere.stream().anyMatch(m -> m.getName().equalsIgnoreCase(medarbejder));
    }

    private boolean erProjektleder(String projekt, String medarbejder) {
        // TODO: Implementer logik for at tjekke om medarbejder er projektleder for det givne projekt
        return false;
    }

    private boolean erLedig(String medarbejder) {
        // TODO: Implementer logik for tjek om medarbejder er ledig
        return true;
    }
}




