package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.projectmanager.*;
import com.projectmanager.app.Main;

public class tildel_projektleder_steps {
    Main.ProjektlederStat status;
    private String fejlbesked;

    private boolean statusconfirm = true;

    @And("en medarbejder {string} er ledig")
    public void ledigcheck(String medarbejder) {
        assert (Main.erLedig(medarbejder)) : "Medarbejder " + medarbejder + " er ikke ledig.";
    }

    @When("en anden medarbejder {string} udpeger medarbejder {string} som projektLeder for projekt {string}")
    public void udpegning(String udpeger, String medarbejder, String projekt) {
        status = Main.erProjektleder(projekt, medarbejder);
        if (!status.erProjektLeder() && status.projektnavn() == null) {
            assert (udpeger.appointPL(projekt, medarbejder)) : "Tildeling mislykkedes: Medarbejder " + medarbejder
                    + " findes ikke i systemet eller er ikke ledig.";
            statusconfirm = true;
        } else if (status.erProjektLeder() && status.projektnavn().equals(projekt)) {
            assert (udpeger.appointPL(projekt, medarbejder)) : "Tildeling mislykkedes: Medarbejder " + medarbejder
                    + " er allerede projektleder for projekt " + projekt;
            statusconfirm = true;
        } else if (status.erProjektLeder() && !status.projektnavn().equals(projekt)) {
            statusconfirm = false;
        }
    }

    @Then("tildel medarbejder {string} som projektleder for projekt {string} skal lykkes")
    public void tildelProjektlederSuccess(String medarbejder, String projekt) {
        assert (status.erProjektLeder())
                : "Tildeling mislykkedes: Medarbejder " + medarbejder + " findes ikke i systemet.";
        System.out.println("Medarbejder " + medarbejder + " er nu projektleder for projekt " + projekt);
        status = Main.erProjektleder(projekt, medarbejder);
        assert (status.erProjektLeder() && status.projektnavn().equals(projekt))
                : "Tildeling mislykkedes: Medarbejder " + medarbejder + " er ikke projektleder for projekt " + projekt;
    }

    @And("medarbejder {string} allerede er projektleder for et andet projekt med navn {string}")
    public void medarbejderErProjektlederForAndetProjekt(String medarbejder, String projekt) {
        status = Main.erProjektleder(projekt, medarbejder);
        statusconfirm = true;
        assert (!status.erProjektLeder() && status.projektnavn() != null && !status.projektnavn().equals(projekt))
                : "Der er gået noget galt: enten er medarbejder " + medarbejder
                        + " ikke projektleder for noget projekt, eller så er de projektleder for det samme projekt "
                        + projekt;
        statusconfirm = false;
    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede projektleder for et andet projekt'")
    public void tildelPLFejler(String medarbejder) {
        if (statusconfirm == false) {
            assert (!status.erProjektLeder()) : "Handling fejler med fejlbesked: Medarbejder " + medarbejder
                    + " er allerede projektleder for projekt " + status.projektnavn();
        }
    }

}
