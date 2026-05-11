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
    ArrayList<Employee> employees = new ArrayList<>();
    int selectedIndex = 0;

    // @Given i CreateProjectSteps

    @Given("at {string} er projektleder under {string}")
    public void denne_medarbejder_er_projektleder_for_et_projekt(String employee, String project) {
        projects.add(new Project(project));
        employees.add(new Employee(employee));
        System.out.println("Employees");
    }

    @When("medarbejderen bestemmer {double} til {string} som positivt decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_positivt_decimaltal_eller_heltal_som_slutter_i_og_varer(
<<<<<<< HEAD
            double budgetTime, String aktivitetsNavn, int endWeek, int amountWeek) {
        projects.get(0).addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
        System.out.println(projects.get(0).getActivity(0).getActivityName());
=======
            double budgetTime, String aktivitetsNavn, Integer endWeek, Integer amountWeek) {

            projects.add(new Project("2601"));
        projects.get(selectedIndex).addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
>>>>>>> 0e3ed8a6abeae0aaf3a1d7b8ef0f87152203e997

    }

    @When("medarbejderen bestemmer {double} til {string} som negativt decimaltal eller heltal, som slutter i {int} og varer {int}")
    public void medarbejderen_bestemmer_budgetteret_tid_til_som_negativt_decimaltal_eller_heltal_som_slutter_i_og_varer(
<<<<<<< HEAD
            double budgetTime, String aktivitetsNavn, int endWeek, int amountWeek) {
        projects.get(0).addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
=======
            double budgetTime, String aktivitetsNavn, Integer endWeek, Integer amountWeek) {
                projects.add(new Project("2601"));
        projects.get(selectedIndex).addActivity(aktivitetsNavn, budgetTime, new Week(endWeek, Year.now().getValue()), amountWeek);
>>>>>>> 0e3ed8a6abeae0aaf3a1d7b8ef0f87152203e997
    }

    @Then("tildel aktiviteten mængde af budgetteret tid rundet op til nærmeste halve {double}")
    public void tildel_mængde_af_budgetteret_tid_rundet_op_til_naermeste_halve(double time) {
        assertEquals(time, projects.get(0).getActivity(0).getBudgetTime(), 0.25);
    }

    @Then("aktivitet får budgetteret tid {int}")
    public void aktivitet_faar_budgetteret_tid(int time) {
        assertEquals(time, projects.get(0).getActivity(0).getBudgetTime(),0.25);
    }

}
