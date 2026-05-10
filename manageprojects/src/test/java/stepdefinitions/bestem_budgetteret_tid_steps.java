package stepdefinitions;

import java.time.Year;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

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
                selectedIndex = i;
                assertEquals(employee, projects.get(i).getProjectLeader());
            }
        }
    }

    @When("medarbejderen bestemmer {double} til {string} som positivt decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_positivt_decimaltal_eller_heltal_som_slutter_i_og_varer(
            double budgetTime, String aktivitetsNavn, Integer endWeek, Integer amountWeek) {
        projects.get(selectedIndex).addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
    }

    @When("medarbejderen bestemmer {double} til {string} som negativt decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_negativt_decimaltal_eller_heltal_som_slutter_i_og_varer(
            double budgetTime, String aktivitetsNavn, Integer endWeek, Integer amountWeek) {
        projects.get(selectedIndex).addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
    }

    @Then("tildel aktiviteten mængde af budgetteret tid rundet op til nærmeste halve {double}")
    public void tildel_mængde_af_budgetteret_tid_rundet_op_til_naermeste_halve(double time) {
        assertEquals(time, projects.get(selectedIndex).getActivity(0).getBudgetTime());
    }

}
