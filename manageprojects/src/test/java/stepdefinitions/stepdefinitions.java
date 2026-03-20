package stepdefinitions;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class stepdefinitions {
    
    int a, b, result;

    @Given("I have numbers {int} and {int}")
    public void i_have_numbers(int num1, int num2) {
        a = num1;
        b = num2;
    }

    @When("I add them")
    public void i_add_them() {
        result = a + b;
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }

}
