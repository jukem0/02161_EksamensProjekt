package stepdefinitions;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tildel_projektleder_steps {

    String error="";

    @And("en medarbejder {string} er ledig")
    public void ledigcheck(String medarbejder) {

        Employee emp = new Employee(medarbejder);
        assert(emp.isAvailable());
    }

    @When("en anden medarbejder {string} udpeger medarbejder {string} som projektLeder for projekt {string}")
    public void udpegning(String udpeger, String medarbejder, String projekt) {
        
        Employee uemp = new Employee(udpeger);
        Employee emp = new Employee(medarbejder);
        Project pro = new Project(projekt);

        uemp.assignProjectleader(projekt,emp);
    }

    @Then("tildel medarbejder {string} som projektleder for projekt {string} skal lykkes")
    public void tildelProjektlederSuccess(String medarbejder, String projekt) {

        Employee uemp = new Employee("plac");
        Employee emp = new Employee(medarbejder);
        Project pro = new Project(projekt);

        uemp.assignProjectleader(projekt,emp);

        assert (pro.getProjectLeader().getEmployeeName().equalsIgnoreCase(medarbejder));
    }

    @And("medarbejder {string} allerede er projektleder for et andet projekt med navn {string}")
    public void medarbejderErProjektlederForAndetProjekt(String medarbejder, String projekt) {

        Employee uemp = new Employee("plac");
        Employee emp = new Employee(medarbejder);
    
        uemp.assignProjectleader(projekt,emp);
        try {
            uemp.assignProjectleader("pro2",emp); 
        } catch (Exception e) {
            error = e.getMessage();
        }
           
    }

    @Then("handling fejler med fejlbesked: 'Medarbejder er allerede projektleder for et andet projekt'")
    public void tildelPLFejler(String medarbejder) {
        assert (error.equalsIgnoreCase("Medarbejder er allerede projektleder for et andet projekt"));
    }


    @Given("en {string} er projektleder i et andet projekt med navn {string}")
    public void en_er_projektleder_i_et_andet_projekt_med_navn(String string, String string2) {
        assert ("smt"== new Activity(string2));
    }

    @Then("fejler handling med fejlbesked: \"denne medarbejder er allerede projektleder i \"Website\"\"")
    public void fejler_handling_med_fejlbesked_denne_medarbejder_er_allerede_projektleder_i_website() {
       
    }
}
