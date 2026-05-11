package stepdefinitions;

import com.projectmanager.model.Activity;
import com.projectmanager.model.Employee;
import com.projectmanager.model.Project;
import com.projectmanager.model.Week;
import com.projectmanager.services.EmployeesFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registrerTid {
    //@Given lånt fra CreateProjectStepsDef

    private String errorMessageActAlrExist;
    private Project pro;
    private Employee emp;
    private Activity act;
    private String fejlbesked;
    private Activity actName;

    @When("en {string} indtaster deres tid brugt på en {string} i et {string} som decimaltal eller heltal {double}")
    public void en_indtaster_deres_tid(String medarbejder, String activityName, String projectName, double timer) {
        
        emp = new Employee(medarbejder);
        act = new Activity(activityName, 20.1, new Week(5, 2026),1);
        pro = new Project(projectName);

        actName = new Activity(activityName);

        try {
            EmployeesFunctions.addEmployeeToActivity(emp, act, pro);
            EmployeesFunctions.registerTime(emp,pro,act,timer);
            
        } catch (Exception e){
            fejlbesked = e.toString();
        }
    }

    @Then("Under {string} findes {double} brugt af {string} rundet op til nærmeste halve")
    public boolean under_aktivitet_findes_tiden(String aktivitetNavn, double timer, String  medarbejderNavn) throws Exception {
        double timeSpend = pro.getTimeSpendPerPersonActivity(actName, emp);

        if(Math.abs(timeSpend - timer) < 0.0001) {

            return true;
            
        } else {
            errorMessageActAlrExist = "Time not found";
            throw new Exception(errorMessageActAlrExist);
        }
    }

    @Then("handling fejler med fejlbesked at {string}")
    public void handling_fejler(String tidNegativt) throws Exception{
        if (fejlbesked != tidNegativt){
            throw new Exception(fejlbesked);
        }
    }
}