package stepdefinitions;

import com.projectmanager.Aktivitet;
import com.projectmanager.Medarbejder;
import com.projectmanager.Main;
import com.projectmanager.Projekt;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class aktivitetstepdefinitions {
    private final List<Aktivitet> oprettedeAktiviteter = Main.projekter.aktiviteter;

    private String opretFejlbesked;

    private final List<Medarbejder> systemMedarbejdere = Main.systemMedarbejdere;

    private String valgtProjekt;
    private String aktuelMedarbejder;
    public record ProjektlederStat(boolean erProjektLeder, String projektnavn){}

    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at vise hvem er i systemet.
        System.out.println("Følgende medarbejdere findes i systemet:" + table.asList());
        // Liste er allerede initialiseret med systemets medarbejdere; denne step er kun til reference.
    }

    @Given("en {string} findes i systemet")
    public void getmedarbejder(String medarbejder) {
        medarbejder = medarbejder.replace("\"", "");
        this.aktuelMedarbejder = medarbejder;
        assert findMedarbejder(medarbejder) : "Medarbejder " + medarbejder + " findes ikke i systemet.";
    }

    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projekt) {
        valgtProjekt = projekt.replace("\"", "");
        var status = erProjektleder(valgtProjekt, aktuelMedarbejder);
        assert (status.erProjektLeder() || erLedig(aktuelMedarbejder)) : 
            "Medarbejder " + aktuelMedarbejder + " er hverken projektleder eller ledig for projektet " + valgtProjekt;
    }

    @When("projektleder eller ledig medarbejder opretter aktivitet med navn {string}")
    public void opretAktivitet(String aktivitetsnavn) {
        aktivitetsnavn = aktivitetsnavn.replace("\"", "");
        
        oprettedeAktiviteter.add(new Aktivitet(aktivitetsnavn));
        opretFejlbesked = null;
    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String aktivitetsnavn) {
        aktivitetsnavn = aktivitetsnavn.replace("\"", "");
        System.out.println("Aktivitet oprettet med navn: " + aktivitetsnavn);
        if (oprettedeAktiviteter.stream().noneMatch(a -> a.getNavn().equals(aktivitetsnavn))) {
            throw new AssertionError("Aktivitet blev ikke oprettet med navnet: " + aktivitetsnavn);
        }
    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projekt) {
        valgtProjekt = projekt.replace("\"", "");
        assert Main.projekter.stream().anyMatch(p -> p.getProjektNavn().equals(valgtProjekt)) : "Projekt " + valgtProjekt + " findes ikke i systemet.";
    }

    @And("der findes allerede en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String aktivitetsnavn) {
        aktivitetsnavn = aktivitetsnavn.replace("\"", "");
        if (oprettedeAktiviteter.stream().anyMatch(a -> a.getNavn().equals(aktivitetsnavn))) {
            opretFejlbesked = "denne aktivitet findes allerede";
        }
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
    
    public ProjektlederStat erProjektleder(String projektnavn, String medarbejder){
        boolean result = false;
        return new ProjektlederStat(result, projektnavn);
    }
    

    public static boolean erLedig(String medarbejder) {
        // TODO: Implementer logik for tjek om medarbejder er ledig
        return true;
    }
}
