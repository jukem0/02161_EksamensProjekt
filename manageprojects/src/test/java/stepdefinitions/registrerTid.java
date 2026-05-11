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

    @When("en {string} indtaster deres tid brugt på en {string} i et {string} som decimaltal eller heltal {double}")
    public void en_indtaster_deres_tid(String medarbejder, String activityName, String projectName, double timer) {
        
        emp = new Employee(medarbejder);
        act = new Activity(activityName, 20.1, new Week(5, 2026),1);
        pro = new Project(projectName);
        EmployeesFunctions empfun = new EmployeesFunctions();

        try {
            empfun.addEmployeeToActivity(emp, act, pro);
            empfun.registerTime(emp,pro,act,timer);
            
        } catch (Exception e){
            fejlbesked = e.toString();
        }
    }

    @Then("Under {string} findes {double} brugt af {string} rundet op til nærmeste halve")
    public void under_aktivitet_findes_tiden(String aktivitetNavn, double timer, String  medarbejderNavn) throws Exception {
        if(pro.getTimeSpendPerPersonActivity(act, emp) == timer) {

            pro.getTimeSpendPerPersonActivity(act, emp);
            
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