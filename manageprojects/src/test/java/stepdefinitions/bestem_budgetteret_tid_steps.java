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
    @When("projektleder {medarbejder} forsøger at budgettere tid for en aktivitet {aktivitet} i projektet {projekt}")
    public void projektleder_forsøger_at_budgettere_tid(String medarbejder, String aktivitet, String projekt) {
        // Implementation for attempting to budget time for an activity in a project
    }
    @Then("budgettering af tid for aktiviteten {aktivitet} i projektet {projekt} skal lykkes")
    public void budgettering_af_tid_skal_lykkes(String aktivitet, String projekt) {
        // Implementation for verifying that budgeting time for the activity in the project is successful
    }
    
}
