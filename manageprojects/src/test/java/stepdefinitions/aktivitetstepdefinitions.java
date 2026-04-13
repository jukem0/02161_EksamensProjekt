package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class aktivitetstepdefinitions {
    

    @Given("en medarbejder {Medarbejder} findes i systemet")
    public Object getmedarbejder(Object medarbejder) {
        // Implementation for setting up the employee in the system
        Medarbejder curmedarb = new Medarbejder(medarbejder);
        return curmedarb;   
    }
    @And("et projekt {String} har en projektleder {String} eller en ledig medarbejder {String}")
    public void getprojektledighed(String projekt, String projektLeder, String ledigMedarbejder) {
        
        if (projektLeder.equals("Projektleder")) {
                System.out.println("Projektleder " + projektLeder + " er tildelt til projektet " + projekt);
            } else if (ledigMedarbejder.equals("Ledig Medarbejder")) {
                System.out.println("Medarbejder " + ledigMedarbejder + " er tilgængelig for projektet " + projekt);
            } else {
                System.out.println("Ingen projektleder eller ledig medarbejder tilgængelig for projektet " + projekt);
            }
        
    }
    @When("projektleder eller medarbejder opretter en aktivitet med navn {String}")
    public Aktivitet opretAktivitet(String aktivitetsnavn) {
        

        Aktivitet aktivitet = new Aktivitet(aktivitetsnavn);
        return aktivitet;
    }

    @Then("Oprettelse af aktivitet med navn {String} skal lykkes")
    public boolean  opretAktivitetSuccess(Object aktivitetsnavn) {
        
        if (geteksisterendeAktivitet(aktivitetsnavn) == null) {
            System.out.println("aktivitet oprettet: " + aktivitetsnavn);
            return true;
        } else {
                return false;
        }
    }

    @Given ("der findes et projekt med navn {String} i systemet")
    public void getprojekt(String projekt) {
        // Implementation for setting up the project in the system
        System.out.println("Projekt " + projekt + " findes i systemet.");
    }
    @And ("der findes allerede en aktivitet med navn {String} i projektet")
    public String geteksisterendeAktivitet(Object activitetsnavn) {
       
        if (activitetsnavn.equals("Eksisterende Aktivitet")) {
            return "Aktivitet findes allerede";
        } else {
            return null;
        }
    }
    @Then("Oprettelse af aktivitet med navn {String} skal fejle")
    public boolean opretAktivitetFailure(String activitetsnavn) {
        if(geteksisterendeAktivitet(activitetsnavn) != null) {
            System.out.println("Fejl: Aktivitet med navn '" + activitetsnavn + "' findes allerede i projektet.");
            return true;
        } else {
                return false;
            }
            
        

    }
}

