package stepdefinitions;

import com.projectmanager.model.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class createActivitysteps {

    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at
        // vise hvem er i systemet.
    
    }

    // @Given("en {string} findes i systemet")
    // public void getmedarbejder(String medarbejder) {

    // }

    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projectname, Project project) {
        assert(project.getName().equalsIgnoreCase(projectname) && (project.getProjektLeder() != null || project.getAvailableEmployees().size() > 0));
    }

    @When("projektleder eller ledig medarbejder opretter aktivitet med navn {string}")
    public void opretAktivitet(String aktivitetsnavn) {

    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String aktivitetsnavn) {

    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projekt) {

    }

    @And("der findes allerede en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String aktivitetsnavn) {

    }

    @Then("handling fejler med fejlbesked: {string}")
    public void opretAktivitetFailure(String fejlbesked) {

    }

}
