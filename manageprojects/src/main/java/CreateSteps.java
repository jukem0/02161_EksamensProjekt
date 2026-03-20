import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CreateSteps {

    private Employee employee;

    public CreateSteps(Emplyee employee) {
        this.emplyee = employee;


        @Given("^that the employees \"([^\"]*)\" have avaible time$", (String arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        });

    }





}
