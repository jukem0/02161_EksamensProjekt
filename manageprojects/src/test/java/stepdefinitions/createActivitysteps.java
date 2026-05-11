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



public class createActivitysteps {
    public static List<Employee> employees = new ArrayList<>();
    public static List<Project> projects = new ArrayList<>();
    private  Project project;
    private  Employee employee;
    
    @Given("følgende medarbejdere findes i systemet:")
    public void følgendeMedarbejdereFindesISystemet(DataTable table) { // bruger en given liste af medarbejdere for at
        List<String> employeeNames = table.asList(String.class);
        for (String name : employeeNames) {
            //String cleanName = name.replace("\"", ""); // fjerner eventuelle anførselstegn fra navnet
            Employee newEmp = new Employee(name);
            employees.add(newEmp);
        }
        // vise hvem er i systemet.
    }

    @Given("følgende projekter findes i systemet:")
    public void følgendeProjekterFindesISystemet(DataTable table) {
        System.out.println("DEBUG -> Antal projekter: " + projects.size() + " | Antal medarbejdere: " + employees.size());

        List<String> projectNames = table.asList(String.class);
        for (String name : projectNames) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).isAvailable()) {
                    employees.get(i).becomeLeaderOf(name);
                    Project newProject = new Project(name, employees.get(i));
                    projects.add(newProject);
                    break;
                }
            }
        }
        System.out.println("DEBUG -> Antal projekter efter: " + projects.size());
    }

    @Given("projektet{string} har en projektleder{string}, eller en ledig medarbejder")
    public void projektet_har_en_projektleder_eller_en_ledig_medarbejder(String projectName, String empName) {
        Project pro = new Project(projectName);
        Employee emp = new Employee(empName);

        
        pro.addActivity("smt",200, new Week(2, 2026),3);
        pro.getActivity(0).addEmployeeToActivity(emp);
    }

 
    @And("et projekt {string} har en projektleder eller en ledig medarbejder")
    public void getProjektAnsvarlig(String projectname) {
        System.out.println("DEBUG -> Antal projekter: " + projects.size() + " | Antal medarbejdere: " + employees.size());
        project = projects.stream().filter(p -> p.getName().equalsIgnoreCase(projectname)).findFirst().orElse(null);
        assert(project != null): "Projektet blev ikke fundet i systemet";        
        //this.employee = employees.stream().filter(e -> e.isAvailable() || e.leaderOf().equals(project.getProjectNr())).findFirst().orElse(null);
        this.employee = employees.stream()
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
            System.out.println(e.getMessage());
        }

    }

    @Then("opret aktivitet med navn {string}")
    public void opretAktivitetSuccess(String actname) {
        assert(project.isActivityInProject(new Activity(actname))): "Aktiviteten blev ikke oprettet, der er noget galt";

    }

    @Given("der findes et projekt med navn {string}")
    public void getprojekt(String projectname) {

        projects.add( new Project(projectname));
        project = projects.stream().filter(p -> p.getName().equalsIgnoreCase(projectname)).findFirst().orElse(null);
        assert(project.getName().equalsIgnoreCase(projectname)): "Projektet blev ikke fundet";

    }

    @And("der findes allerede en aktivitet med navn {string}")
    public void geteksisterendeAktivitet(String actname) {
        assert(project.isActivityInProject(new Activity(actname))): "Aktiviteten blev ikke fundet";
    }

}

