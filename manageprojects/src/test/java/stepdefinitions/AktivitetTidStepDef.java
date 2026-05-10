// package stepdefinitions;

// import static org.junit.jupiter.api.Assertions.*;

// import com.projectmanager.app.*;
// import com.projectmanager.model.*;

// import io.cucumber.java.en.*;

// public class AktivitetTidStepDef {
// int aktivitetIndex = -1;
// boolean startFørSlut;
// Week startDato, slutDato;
// Project tempProjekt = null;
// String errorMessage = "Startdato kan ikke være efter slutdato";

// @Given("at {string} er projektleder under projekt {string}")
// public void er_projektleder(String medarbejder, String projekt) {
// for (Project p : .getProjekter()) {
// if (p.getProjektNavn().equalsIgnoreCase(projekt)) {
// tempProjekt = p;
// }
// }
// if (tempProjekt != null) {
// assertTrue(tempProjekt.getProjektLeder().getName().equalsIgnoreCase(medarbejder),
// "Medarbejder " + medarbejder + " er ikke projektleder i projektet " +
// projekt);
// }
// }

// @When("{string} bestemmer start- og sluttid til {string} som datoer {Week},
// {Week}")
// public void bestem_start_og_slut(String medarbejder, String aktivitet, Week
// startDate, Week slutDate) {
// }

// @When("{Week} er senere end {Week}")
// public void start_efter_slut(Week start, Week slut) {
// }

// @Then("tildel {string} datoerne, {Week} og {Week} som værende afgrænsede tid
// for færdiggørelse af projekt")
// public void tildelDatoer() {

// }

// @Then("handling feljer med fejlbesked: 'Startdato kan ikke være efter
// slutdato'")
// public void fejler() {

// }
// }
