package stepdefinitions;

import java.time.Year;

import static org.junit.Assert.assertEquals;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Week;
import com.projectmanager.services.RuntimeContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bestem_budgetteret_tid_steps {

    @When("medarbejderen bestemmer {double} til {string} som positivt decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_positivt_decimaltal_eller_heltal_som_slutter_i_og_varer(
            double budgetTime, String aktivitetsNavn, int endWeek, int amountWeek) {
        RuntimeContext.getLastUsedProject().addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
    }

    @When("medarbejderen bestemmer {double} til {string} som negativt decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_negativt_decimaltal_eller_heltal_som_slutter_i_og_varer(
            double budgetTime, String aktivitetsNavn, int endWeek, int amountWeek) {
        RuntimeContext.getLastUsedProject().addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
    }

    @Then("tildel aktiviteten mængde af budgetteret tid rundet op til nærmeste halve {double}")
    public void tildel_mængde_af_budgetteret_tid_rundet_op_til_naermeste_halve(double time) {
        Activity lastAct = RuntimeContext.getLastCreatedActivity();
        assertEquals(time, lastAct.getBudgetTime(), 0.25);
    }

    @Then("aktivitet får budgetteret tid {int}")
    public void aktivitet_faar_budgetteret_tid(int time) {
        Activity lastAct = RuntimeContext.getLastCreatedActivity();
        assertEquals(time, lastAct.getBudgetTime(), 0.25);
    }

}
