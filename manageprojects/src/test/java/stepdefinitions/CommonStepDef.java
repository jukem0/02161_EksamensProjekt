package stepdefinitions;

import com.projectmanager.services.RuntimeContext;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class CommonStepDef {

    @Then("handling fejler med fejlbesked: {string}")
    public void handling_fejler_med_fejlbesked(String expectedMsg) {
        assertEquals(expectedMsg, RuntimeContext.getErrorMsg());
    }
}
