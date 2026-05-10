package stepdefinitions;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;
import com.projectmanager.services.EmployeesFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registrerTid {

    @When("en {string} indtaster deres tid brugt på en aktivitet {string} i projekt {string} som decimaltal eller heltal {double}")
    public void en_indtaster_deres_tid(String medarbejder,String activityName, String projectName, double timer) {
        
        Employee emp = new Employee(medarbejder);
        Activity act = new Activity(activityName, 20.1, new Week(5, 2026),1);
        Project pro = new Project(projectName);
        EmployeesFunctions empfun = new EmployeesFunctions();

        empfun.registerTime(emp,pro,act,timer);
    }

    @Then("Under {string} findes tiden{double} brugt af {string} rundet op til nærmeste halve")
    public void under_aktivitet_findes_tiden(String aktivitetNavn, Double time, String medarbejderNavn) throws Exception {
        
        
    }

}
