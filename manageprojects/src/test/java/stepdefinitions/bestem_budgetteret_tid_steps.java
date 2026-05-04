package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bestem_budgetteret_tid_steps {
    @Given("en en medarbejder {medarbejder} findes i systemet")
    public void en_medarbejder_finds_i_systemet(String medarbejder) {
        // Implementation for checking if an employee exists in the system
    }
    @And("denne medarbejder {medarbejder} er projektleder for et projekt {projekt}")
    public void denne_medarbejder_er_projektleder_for_et_projekt(String medarbejder, String projekt) {
        // Implementation for checking if an employee is a project leader for a project
    }
    @When("medarbejderen {medarbejder} bestemmer budgetteret tid {float} for en aktivitet {aktivitet} i projektet {projekt}, som positivt decimaltal eller heltal")
    public void medarbejder_forsøger_at_budgettere_tid(String medarbejder, float budget, String aktivitet, String projekt) {
        // Implementation for attempting to budget time for an activity in a project
    }
    @Then("budgettering af tid for aktiviteten {aktivitet} i projektet {projekt} skal lykkes")
    public void budgettering_af_tid_skal_lykkes(String aktivitet, String projekt) {
        // Implementation for verifying that budgeting time for the activity in the project is successful
    }
    @When("en medarbejder {medarbejder} bestemmer budgetteret tid {float} for en aktivitet {aktivitet} i projektet {projekt}, som andet end et positivt decimaltal eller heltal")
    public void en_medarbejder_bestemmer_budgetteret_tid(String medarbejder, float budget, String aktivitet, String projekt) {
        // Implementation for attempting to budget time for an activity in a project
    }
    @Then("budgettering af tid for aktiviteten {aktivitet} i projektet {projekt} skal fejle med fejlbesked: 'Budgetteret tid skal være et positivt decimaltal eller heltal'")
    public void budgettering_af_tid_skal_feje(String aktivitet, String projekt) {
        // Implementation for verifying that budgeting time for the activity in the project fails with the specified error message
    }
}

*/

