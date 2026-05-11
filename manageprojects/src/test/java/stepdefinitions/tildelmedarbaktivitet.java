package stepdefinitions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.services.RuntimeContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//lavet af fabrizio

public class tildelmedarbaktivitet {

    private Project project;
    private Employee employee;
    private Activity activity;

    @Given("der findes en aktivitet med navn {string} i projektet {string}")
    public void checkIfActivityInProject(String activityName, String projectName) {
        this.project = RuntimeContext.getProjects().stream()
                .filter(p -> p.getName().equalsIgnoreCase(projectName))
                .findFirst().orElseGet(() -> {
                    Project newProj = new Project(projectName);
                    RuntimeContext.getProjects().add(newProj);
                    return newProj;
                });
        
        if (!this.project.isActivityInProject(new Activity(activityName))) {
            this.project.addActivity(activityName);
        }
        
        this.activity = this.project.getActivityMap().keySet().stream()
                .filter(a -> a.getActivityName().equalsIgnoreCase(activityName))
                .findFirst().orElse(null);
        assertNotNull(this.activity);
    }

    @When("en medarbejder udpeger en anden medarbejder {string} til at være tilknyttet aktivitet med navn {string}")
    public void iTryToAddEmployeeToActivity(String empInitial, String actName) {
        this.employee = RuntimeContext.getEmployees().stream()
                .filter(e -> e.getEmployeeName().equalsIgnoreCase(empInitial))
                .findFirst().orElseGet(() -> {
                    Employee newEmp = new Employee(empInitial);
                    RuntimeContext.getEmployees().add(newEmp);
                    return newEmp;
                });
        
        if (this.activity == null || !this.activity.getActivityName().equals(actName)) {
            // Try to find it in the current project
            if (this.project != null) {
                this.activity = this.project.getActivityMap().keySet().stream()
                    .filter(a -> a.getActivityName().equalsIgnoreCase(actName))
                    .findFirst().orElse(null);
            }
        }

        try {
            if (this.activity != null) {
                this.activity.addEmployeeToActivity(this.employee);
            }
        } catch (Exception e) {
            RuntimeContext.setErrorMsg(e.getMessage());
        }
    }

    @Then("tildel medarbejder {string} til aktivitet med navn {string} skal lykkes")
    public void addEmployeeToActivitySuccess(String empInitial, String activityName) {
        assertNotNull(this.activity);
        assertTrue(this.activity.getEmployees().stream()
                .anyMatch(e -> e.getEmployeeName().equalsIgnoreCase(empInitial)));
    }

    @And("medarbejder {string} allerede er tildelt aktivitet med navn {string}")
    public void medarbejderAlleredeTildelt(String empInitial, String activityName) {
        // Initialize employee if not already set
        if (this.employee == null || !this.employee.getEmployeeName().equalsIgnoreCase(empInitial)) {
            this.employee = RuntimeContext.getEmployees().stream()
                    .filter(e -> e.getEmployeeName().equalsIgnoreCase(empInitial))
                    .findFirst().orElseGet(() -> {
                        Employee newEmp = new Employee(empInitial);
                        RuntimeContext.getEmployees().add(newEmp);
                        return newEmp;
                    });
        }

        // Initialize activity if not already set
        if (this.activity == null || !this.activity.getActivityName().equals(activityName)) {
            if (this.project != null) {
                this.activity = this.project.getActivityMap().keySet().stream()
                        .filter(a -> a.getActivityName().equalsIgnoreCase(activityName))
                        .findFirst().orElse(null);
            }
        }

        if (this.activity != null && this.employee != null) {
            if (!this.activity.getEmployees().contains(this.employee)) {
                this.activity.addEmployeeToActivity(this.employee);
            }
        }
    }
}
