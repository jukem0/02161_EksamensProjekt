package stepdefinitions;

import static org.junit.Assert.assertEquals;

import com.projectmanager.Aktivitet;
import com.projectmanager.Main;
import com.projectmanager.Projekt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bestem_budgetteret_tid_steps {

    String errormessage = "";

    private Projekt getPro(String projekt) {
        Projekt TempProjekt = null;
        for (Projekt p : Main.getProjekter()) {
            if (p.getProjektNavn().equalsIgnoreCase(projekt)) {
                TempProjekt = p;
            }
        }
        return TempProjekt;
    }

    private Aktivitet getAkt(String aktivitet, Projekt projekt) {
        Aktivitet tempAkt = null;
        for (Aktivitet p : projekt.getAktiviteter()) {
            if (p.getName().equalsIgnoreCase(aktivitet)) {
                tempAkt = p;
            }
        }
        return tempAkt;
    }

    @Given("en en medarbejder {string} findes i systemet")
    public void en_medarbejder_finds_i_systemet(String medarbejder) {

        assert (Main.erLedig(medarbejder)) : "Medarbejder " + medarbejder + " er ikke ledig.";
    }

    @And("denne medarbejder {string} er projektleder for et projekt {string}")
    public void denne_medarbejder_er_projektleder_for_et_projekt(String medarbejder, String projekt) {

        assert (Main.erProjektleder(projekt, medarbejder).erProjektLeder());
    }

    @When("medarbejderen {string} bestemmer budgetteret tid {float} for en aktivitet {string} i projektet {string}, som positivt decimaltal eller heltal")
    public void medarbejder_forsøger_at_budgettere_tid(String medarbejder, float budget, String aktivitet,
            String projekt) {

        Projekt TempProjekt = getPro(projekt);
        Aktivitet tempAkt = getAkt(aktivitet, TempProjekt);

        if (budget > 0) {
            tempAkt.redigerBudgeteretTid(budget);
        }
    }

    @Then("budgettering af tid for aktiviteten {string} i projektet {string} skal lykkes")
    public void budgettering_af_tid_skal_lykkes(String aktivitet, String projekt) {

        Projekt TempProjekt = getPro(projekt);
        Aktivitet tempAkt = getAkt(aktivitet, TempProjekt);

        tempAkt.redigerBudgeteretTid(4);

        assertEquals(tempAkt.getBudgetTime(), 4);
    }

    @When("en medarbejder {string} bestemmer budgetteret tid {float} for en aktivitet {string} i projektet {string}, som andet end et positivt decimaltal eller heltal")
    public void en_medarbejder_bestemmer_budgetteret_tid(String medarbejder, float budget, String aktivitet,
            String projekt) {

        Projekt TempProjekt = getPro(projekt);
        Aktivitet tempAkt = getAkt(aktivitet, TempProjekt);

        if (budget <= 0) {
            errormessage = "Budgetteret tid skal være et positivt decimaltal eller heltal";
        }
    }

    @Then("budgettering af tid for aktiviteten {string} i projektet {string} skal fejle med fejlbesked: 'Budgetteret tid skal være et positivt decimaltal eller heltal'")
    public void budgettering_af_tid_skal_feje(String aktivitet, String projekt) {

        String besked = "Budgetteret tid skal være et positivt decimaltal eller heltal";
        assertEquals(errormessage, besked);
    }
}
