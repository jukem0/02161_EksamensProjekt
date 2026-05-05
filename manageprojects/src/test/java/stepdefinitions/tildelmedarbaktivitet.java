package stepdefinitions;

im
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tildelmedarbaktivitet {
    @Given("der findes en aktivitet med navn {string} i projektet")
    public boolean findAktivitet(String aktivitetsnavn) {
        if (aktivitetsnavn.equals("Eksisterende Aktivitet")) {
            System.out.println("Aktivitet " + aktivitetsnavn + " findes i projektet.");
            return true;
        } else {
            System.out.println("Aktivitet " + aktivitetsnavn + " findes ikke i projektet.");
            return false;
        }
    }
    @When ("en medarbedjer {string} udpeger en anden medarbejder {string} til at lave aktivitet med navn {string}")
    public void tildelAktivitet(String aktivitetsnavn) {
        
    }
    @Then ("tildel medarbejder {string} til aktivitet med navn {string} skal lykkes")
    public boolean tildelAktivitetSuccess(String aktivitetsnavn) {
        if (findAktivitet(aktivitetsnavn)) {
            System.out.println("Medarbejder er tildelt til aktivitet " + aktivitetsnavn);
            return true;
        } else {
            System.out.println("Tildeling mislykkedes: Aktivitet " + aktivitetsnavn + " findes ikke.");
            return false;
        }
    }    

    @And("medarbejder {string} allerede er tildelt aktivitet med navn {string}")
    public boolean medarbejderAlleredeTildelt(String aktivitetsnavn) {
        if (findAktivitet(aktivitetsnavn)) {
            System.out.println("Medarbejder er allerede tildelt aktivitet " + aktivitetsnavn);
            return true;
        } else {
            System.out.println("Medarbejder er ikke tildelt aktivitet " + aktivitetsnavn);
            return false;
        }
    }
    @Then ("handling fejler med fejlbesked: 'Medarbejder er allerede tildelt til denne aktivitet'")
    public boolean handlingFejler(String aktivitetsnavn) {
        if (medarbejderAlleredeTildelt(aktivitetsnavn)) {
            System.out.println("Handling fejler med fejlbesked: 'Medarbejder er allerede tildelt til denne aktivitet'");
            return true;
        } else {
            System.out.println("Handling lykkes ikke.");
            return false;
        }
    }
}


