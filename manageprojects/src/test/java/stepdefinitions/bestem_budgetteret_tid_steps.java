package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bestem_budgetteret_tid_steps {
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Project> projects = new ArrayList<>();

    @Given("en medarbejder {string} findes i systemet")
    public void en_medarbejder_finds_i_systemet(String employee) {
        Employee newEmp = new Employee(employee);
        employees.add(newEmp);
    }

    @And("at {string} er projektleder under {string}")
    public void denne_medarbejder_er_projektleder_for_et_projekt(String empplyee, String project) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeName().equals(empplyee)) {
                Project newProject = new Project(project);
                projects.add(newProject);
                employees.get(i).becomeLeaderOf(projects.get(i).getProjectNr());

            }
        }

        if (FuckCucumber.getEmployee(empplyee) != null && FuckCucumber.getProject(project) != null) {

            Employee employee = FuckCucumber.getEmployee(empplyee);
            Project projectCheck = FuckCucumber.getProject(project);

            assert (employee.getEmployeeName().equalsIgnoreCase(projectCheck.getProjectLeader().getEmployeeName()));
        }
    }

    @When("medarbejderen {string} bestemmer budgetteret tid {float} for en aktivitet {string} i projektet {string}, som positivt decimaltal eller heltal")
    public void medarbejder_forsøger_at_budgettere_tid(String empplyee, float budget, String activity, String project) { //

        if (FuckCucumber.getEmployee(empplyee) != null && FuckCucumber.getProject(project) != null) {

            Employee actualEmp = FuckCucumber.getEmployee(empplyee);
            Project actualPro = FuckCucumber.getProject(project);

            if (FuckCucumber.getActivity(actualEmp, actualPro) != null) {
                Activity actualAct = FuckCucumber.getActivity(actualEmp, actualPro);

                actualAct.setBudgetTime(budget);

                assert (actualAct.getBudgetTime() == budget);
            }
        }

    }

    @Then("budgettering af tid {double} for aktiviteten {string} i projektet {string} skallykkes")
    public void budgettering_af_tid_skal_lykkes(Double time, String activity, String project) {

    }

    @When("en medarbejder {string} bestemmer budgetteret tid {float} for enaktivitet {string} i projektet {string}, som andet end et positivt decimaltal eller heltal")
    public void en_medarbejder_bestemmer_budgetteret_tid(String empplyee, float budget, String aktivitet,
            String project) {

        if (FuckCucumber.getEmployee(empplyee) != null && FuckCucumber.getProject(project) != null) {

            Employee actualEmp = FuckCucumber.getEmployee(empplyee);
            Project actualPro = FuckCucumber.getProject(project);

            if (FuckCucumber.getActivity(actualEmp, actualPro) != null) {
                Activity actualAct = FuckCucumber.getActivity(actualEmp, actualPro);
                String mes = "";

                try {
                    actualAct.setBudgetTime(budget);
                } catch (Exception e) {
                    mes = e.getMessage();
                }

                assert ("Budgetteret tidskal væreet positivtdecimaltal eller heltal".equalsIgnoreCase(mes));
            }
        }
    }

    @Then("budgettering af tid for aktiviteten {string} i projektet {string} skalfejle med fejlbesked:'Budgetteret tidskal væreet positivtdecimaltal eller heltal'")
    public void budgettering_af_tid_skal_feje(String aktivitet, String projekt) {

    }
}
