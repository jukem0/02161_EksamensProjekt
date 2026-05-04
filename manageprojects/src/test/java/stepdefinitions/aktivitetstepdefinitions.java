package stepdefinitions;


import com.projectmanager.Aktivitet;
import com.projectmanager.Medarbejder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class aktivitetstepdefinitions {
    private Aktivitet oprettetAktivitet;
    
    @Given("en {medarbejder} findes i systemet")
    public boolean getmedarbejder(String medarbejder) {
        for (Medarbejder navn : systemMedarbejdere) {
            if (navn.getName().equalsIgnoreCase(medarbejder)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    @And("et projekt {String} har en projektleder eller en ledig medarbejder {String}")
    public boolean getProjektAnsvarlig(String projekt, String medarbejder) {
        if (getmedarbejder(medarbejder) == true) {
            if (erProjektleder(projekt, medarbejder) == true) {
                System.out.println("Projektleder " + medarbejder + " er tildelt til projektet " + projekt);
                return true;
            } else if (erLedig(medarbejder) == true) {
                System.out.println("Medarbejder " + medarbejder + " er tilgængelig for projektet " + projekt);
                return true;
            } else {
                System.out.println("Ingen projektleder eller ledig medarbejder tilgængelig for projektet " + projekt);
                return false;
                }
            }
            else {
                System.out.println("Medarbejder " + medarbejder + " findes ikke i systemet.");
                return false;
            }
    }
    @When("projektleder eller medarbejder opretter en aktivitet med navn {String}")
    public void opretAktivitet(String aktivitetsnavn) {
        this.oprettetAktivitet = new Aktivitet(aktivitetsnavn);
    }

    @Then("Oprettelse af aktivitet med navn {String} skal lykkes")
    public boolean opretAktivitetSuccess(String aktivitetsnavn) {
        if (this.oprettetAktivitet != null && this.oprettetAktivitet.getNavn().equals(aktivitetsnavn)) {
            System.out.println("aktivitet oprettet: " + aktivitetsnavn);
            return true;
        }
        return false;
    }

    @Given ("der findes et projekt med navn {String} i systemet")
    public void getprojekt(String projekt) {
        System.out.println("Projekt " + projekt + " findes i systemet.");
    }
    @And ("der findes allerede en aktivitet med navn {String} i projektet")
    public boolean geteksisterendeAktivitet(Object activitetsnavn) {
       
        if (activitetsnavn in eksisterendeAktiviteter) {
            return true;
        } else {
            return false;
        }
    }
    @Then("Oprettelse af aktivitet med navn {String} skal fejle")
    public boolean opretAktivitetFailure(String activitetsnavn) {
        if(geteksisterendeAktivitet(activitetsnavn) == true) {
            System.out.println("Fejl: Aktivitet med navn '" + activitetsnavn + "' findes allerede i projektet.");
            return true;
        } else {
                return false;
            }
            
        

    }
}




