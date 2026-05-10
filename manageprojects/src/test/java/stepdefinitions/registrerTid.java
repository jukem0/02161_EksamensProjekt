package stepdefinitions;

import com.projectmanager.model.Employee;
import com.projectmanager.services.EmployeesFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registrerTid {

    // @Given("følgende medarbejdere findes i systemet:")
    // public void følgende_medarbejdere_findes_i_systemet(DataTable dataTable) {
    // }

    @When("en {string} indtaster deres tid brugt på et projekt som decimaltal eller heltal {double}")
    public void en_indtaster_deres_tid(String medarbejder, double timer) {
        
        Employee emp = new Employee(medarbejder);

        EmployeesFunctions empfun = new EmployeesFunctions();
        empfun.registerTime(timer); //emp,pro,act


    }

    @Then("Under {string} findes tiden brugt af {string} rundet op til nærmeste halve")
    public void under_aktivitet_findes_tiden(String aktivitetNavn, String medarbejderNavn) throws Exception {
    }

    // @Then("handling fejler med fejlbesked: {string}")
    // public void handling_fejler_med_fejlbesked(String expectedError) {

    // }
}
