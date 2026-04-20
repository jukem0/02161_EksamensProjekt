package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {
    @Given("medarbejderen har initialerne {string}")
    public void medarbejderen_har_initialerne(String ini) {
        
    }

    @When("når medarbejderen prøver at logge ind")
    public void når_medarbejderen_prøver_at_logge_ind() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("medarbejderen findes ikke og logges derved ikke ind og får beskeden {string}")
    public void medarbejderen_findes_ikke_og_logges_derved_ikke_ind_og_får_beskeden(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("medarbejderen logges ind")
    public void medarbejderen_logges_ind() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
