package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class aktivitetstepdefinitions {
    
    int a, b, result;

    @Given("en medarbejder {String} findes i systemet")
    public void getmedarbejder(String employee) {
        // Implementation for setting up the employee in the system
    }
    @And("et projekt {String} har en projektleder {String} eller en ledig medarbejder {String}")
    public void getprojektledighed(String project, String projectManager, String availableEmployee) {
        // Implementation for setting up the project with a project manager or an available employee
    }
    @When("projektleder eller medarbejder opretter en aktivitet med navn {String}")
    public void opretAktivitet(String activityName) {
        // Implementation for creating an activity with the given name
    }

    @Then("Oprettelse af aktivitet med navn {String} skal lykkes")
    public void opretAktivitetSuccess(String activityName) {
        // Implementation for verifying that the activity creation was successful
    }

    @Given ("der findes et projekt med navn {String} i systemet")
    public void getprojekt(String project) {
        // Implementation for setting up the project in the system
    }
    @And("projektet har en projektleder eller en ledig medarbejder")
    public void getprojektledighed(String projectManager, String availableEmployee) {
        // Implementation for setting up the project with a project manager or an available employee
    }
    @And ("der findes allerede en aktivitet med navn {String} i projektet")
    public void geteksisterendeAktivitet(String activityName) {
        // Implementation for setting up an existing activity in the project
    }
    @Then("Oprettelse af aktivitet med navn {String} skal fejle")
    public void opretAktivitetFailure(String activityName) {
        // Implementation for verifying that the activity creation failed
    }
}

