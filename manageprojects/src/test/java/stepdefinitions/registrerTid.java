package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registrertid(){
    @Given("en medarbejder {medarbejder} findes i systemet"){
        // Implementation for checking if an employee exists in the system
    }
    @When("medarbejderen {medarbejder} registrerer tid {float} for en aktivitet {aktivitet} i projektet {projekt}, som positivt decimaltal eller heltal"){
        // Implementation for attempting to register time for an activity in a project
    }
    @Then("registrering af tid for aktiviteten {aktivitet} i projektet {projekt} skal lykkes")
    public void registrering_af_tid_skal_lykkes(String aktivitet, String projekt) {
        // Implementation for verifying that registering time for the activity in the project is successful
    }
    @And("tiden indtastet er negativt"){
    public void tiden_indtastet_er_negativ() {
        // Implementation for checking if the entered time is negative
    }
}
    @Then("handling fejler med fejlbesked: 'Tiden kan ikke indtastes som negativ'"){
        // Implementation for verifying that the action fails with the specified error message
    }

}
*/

