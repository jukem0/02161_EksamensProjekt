package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Year;
import java.util.ArrayList;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bestem_budgetteret_tid_steps {
    ArrayList<Project> projects = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>(CreateProjectSteps.employees);
    int selectedIndex;

    // @Given i CreateProjectSteps

    @Given("at {string} er projektleder under {string}")
    public void denne_medarbejder_er_projektleder_for_et_projekt(String employee, String project) {
        for (int i = 0; i < projects.size(); i++) {
            Project newProject = new Project(project, employees.get(i));
            projects.add(newProject);
            if (projects.get(i).getProjectLeader().getEmployeeName().equals(employee)) {
                assertEquals(employee, projects.get(i).getProjectLeader());
                selectedIndex = i;
            }
        }
    }

    @When("medarbejderen bestemmer {double} til {string} som positivt decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_positivt_decimaltal_eller_heltal_som_slutter_i_og_varer(
            double budgetTime, String aktivitetsNavn, Integer endWeek, Integer amountWeek) {
        projects.get(selectedIndex).addActivity(new Activity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek),employees.get(selectedIndex));
        assertEquals(selectedIndex, selectedIndex);
    }

    @When("medarbejderen bestemmer {double} til {string} som decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_negativt_decimaltal_eller_heltal_som_slutter_i_og_varer(
            double budgetTime, String aktivitetsNavn, Integer endWeek, Integer amountWeek) {
        projects.get(selectedIndex).addActivity(
                new Activity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek),
                employees.get(selectedIndex));
    }

    @Then("tildel {string} mængde af budgetteret tid rundet op til nærmeste halve")
    public void tildel_mængde_af_budgetteret_tid_rundet_op_til_naermeste_halve(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
