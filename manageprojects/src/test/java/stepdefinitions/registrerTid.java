package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registrerTid{
    @Given("en medarbejder {string} findes i systemet")
    public void en_medarbejder_finds_i_systemet(String medarbejder) {

    }
        // Implementation for checking if an employee exists in the system
    
    @When("medarbejderen {string} registrerer tid {float} for en aktivitet {string} i projektet {string}, som positivt decimaltal eller heltal")
        // Implementation for attempting to register time for an activity in a project
    

    @Then("registrering af tid for aktiviteten {string} i projektet {string} skal lykkes")
    public void registrering_af_tid_skal_lykkes(String aktivitet, String projekt) {
        // Implementation for verifying that registering time for the activity in the
        // project is successful
    }
    @And("tiden indtastet er negativt")

    public void tiden_indtastet_er_negativ() {
        // Implementation for checking if the entered time is negative
    }
    @Then("handling fejler med fejlbesked: 'Tiden kan ikke indtastes som negativ'")
    public void Tid_indtast_fejl() {
        // Implementation for verifying that the action fails with the specified error
        // message
    }
// Implementation for verifying that the action fails with the specified error
// message


}
