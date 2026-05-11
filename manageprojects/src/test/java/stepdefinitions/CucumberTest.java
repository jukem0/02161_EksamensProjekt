package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\gusta\\Documents\\DTU_eksamensstuff\\02161_EksamensProjekt\\manageprojects\\src\\test\\resources\\features",
    glue = "stepdefinitions",
    plugin = "pretty"
)
public class CucumberTest {
}