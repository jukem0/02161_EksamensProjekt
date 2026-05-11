package stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.projectmanager.services.EmployeesFunctions;
import com.projectmanager.services.RuntimeContext;



public class createActivitysteps {
    private Project project;
    private Employee employee;
    
    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at
        List<String> employeeNames = table.asList(String.class);
        for (String name : employeeNames) {
            //String cleanName = name.replace("\"", ""); // fjerner eventuelle anførselstegn fra navnet
            Employee newEmp = new Employee(name);
            EmployeesFunctions.addEmployee(newEmp);
        }
        // vise hvem er i systemet.
    }

    @Given("følgende projekter findes i systemet:")
    public void følgendeProjekterFindesISystemet(DataTable table) {
        System.out.println("DEBUG -> Antal projekter: " + RuntimeContext.getProjects().size() + " | Antal medarbejdere: " + RuntimeContext.getEmployees().size());

        List<String> projectNames = table.asList(String.class);
        for (String name : projectNames) {
            for (int i = 0; i < RuntimeContext.getEmployees().size(); i++) {
                if (RuntimeContext.getEmployees().get(i).isAvailable()) {
                    RuntimeContext.getEmployees().get(i).becomeLeaderOf(name);
                    Project newProject = new Project(name, RuntimeContext.getEmployees().get(i));
                    com.projectmanager.services.EmployeesFunctions.addProject(newProject);
                    break;
                }
            }
        }
        System.out.println("DEBUG -> Antal projekter efter: " + RuntimeContext.getProjects().size());
    }

    @Given("projektet{string} har en projektleder{string}, eller en ledig medarbejder")
    public void projektet_har_en_projektleder_eller_en_ledig_medarbejder(String projectName, String empName) {
        this.project = RuntimeContext.getProjects().stream()
                .filter(p -> p.getName().equalsIgnoreCase(projectName))
                .findFirst().orElseGet(() -> {
                    Project newProj = new Project(projectName);
                    com.projectmanager.services.EmployeesFunctions.addProject(newProj);
                    return newProj;
                });
        
        this.employee = RuntimeContext.getEmployees().stream()
                .filter(e -> e.getEmployeeName().equalsIgnoreCase(empName))
                .findFirst().orElseGet(() -> {
                    Employee newEmp = new Employee(empName);
                    EmployeesFunctions.addEmployee(newEmp);
                    return newEmp;
                });
        
        this.project.setProjectLeader(this.employee);
        this.employee.becomeLeaderOf(this.project.getProjectNr());
    }

 
    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projectname) {
        System.out.println("DEBUG -> Antal projekter: " + RuntimeContext.getProjects().size() + " | Antal medarbejdere: " + RuntimeContext.getEmployees().size());
        project = RuntimeContext.getProjects().stream().filter(p -> p.getName().equalsIgnoreCase(projectname)).findFirst().orElse(null);
        assert(project != null): "Projektet blev ikke fundet i systemet";        
        //this.employee = employees.stream().filter(e -> e.isAvailable() || e.leaderOf().equals(project.getProjectNr())).findFirst().orElse(null);
        this.employee = RuntimeContext.getEmployees().stream()
        .filter(Employee::isAvailable) // Tjekker kun om de er ledige
        .findFirst().orElse(null);
        assert(employee != null): "Der skal være en projektleder eller en ledig medarbejder for at kunne oprette en aktivitet";
        
        /*assert(project.getName().equalsIgnoreCase(projectname) && project.getProjectLeader() != null && 
        (employee.leaderOf().equals(project.getProjectNr()) || employee.isAvailable())): 
        "Der skal være en projektleder eller en ledig medarbejder for at kunne oprette en aktivitet";*/
    }

    @When("projektleder eller ledig medarbejder opretter aktivitet med navn {string}")
    public void opretAktivitet(String actname){
        try {
            project.addActivity(actname, employee);
        } catch (IllegalArgumentException e) {
            RuntimeContext.setErrorMsg(e.getMessage());
        }
    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String actname) {
        assert(project.isActivityInProject(new Activity(actname))): "Aktiviteten blev ikke oprettet, der er noget galt";

    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projectname) {

        com.projectmanager.services.EmployeesFunctions.addProject(new Project(projectname));
        project = RuntimeContext.getProjects().stream().filter(p -> p.getName().equalsIgnoreCase(projectname)).findFirst().orElse(null);
        assert(project.getName().equalsIgnoreCase(projectname)): "Projektet blev ikke fundet";

    }

    @And("der findes allerede en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String actname) {
        if (!project.isActivityInProject(new Activity(actname))) {
            project.addActivity(actname);
        }
    }

}

