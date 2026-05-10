package stepdefinitions;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bestem_budgetteret_tid_steps {

    @Given("en en medarbejder {string} findes i systemet")
    public void en_medarbejder_finds_i_systemet(String medarbejder) {

    }

    @And("denne medarbejder {string} er projektleder for et projekt {string}")
    public void denne_medarbejder_er_projektleder_for_et_projekt(String empplyee, String project) {
        if (FuckCucumber.getEmployee(empplyee) != null && FuckCucumber.getProject(project)!=null) {

            Employee employee = FuckCucumber.getEmployee(empplyee);
            Project projectCheck = FuckCucumber.getProject(project);

            assert (employee.getEmployeeName().equalsIgnoreCase(projectCheck.getProjectLeader().getEmployeeName()));
        }
    }

    @When("medarbejderen {string} bestemmer budgetteret tid {float} for enaktivitet {string} i projektet {string}, som positivt decimaltal eller heltal")
    public void medarbejder_forsøger_at_budgettere_tid(String empplyee, float budget, String activity, String project) { //
        
        if (FuckCucumber.getEmployee(empplyee) != null && FuckCucumber.getProject(project)!= null) {

            Employee actualEmp = FuckCucumber.getEmployee(empplyee);
            Project actualPro = FuckCucumber.getProject(project);

            if (FuckCucumber.getActivity(actualEmp, actualPro)!= null){
                Activity actualAct = FuckCucumber.getActivity(actualEmp, actualPro);
                
                actualAct.setBudgetTime(budget);

                assert (actualAct.getBudgetTime() == budget);   
            }
        }
    }

    @Then("budgettering af tid for aktiviteten {string} i projektet {string} skallykkes")
    public void budgettering_af_tid_skal_lykkes(String aktivitet, String projekt) {
    }

    @When("en medarbejder {string} bestemmer budgetteret tid {float} for enaktivitet {string} i projektet {string}, som andet end et positivt decimaltal eller heltal")
    public void en_medarbejder_bestemmer_budgetteret_tid(String medarbejder, float budget, String aktivitet, //
            String projekt) {
    }

    @Then("budgettering af tid for aktiviteten {string} i projektet {string} skalfejle med fejlbesked:'Budgetteret tidskal væreet positivtdecimaltal eller heltal'")
    public void budgettering_af_tid_skal_feje(String aktivitet, String projekt) {
    }
}
