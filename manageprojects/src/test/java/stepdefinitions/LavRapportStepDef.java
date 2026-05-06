package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.projectmanager.Projekt;
import com.projectmanager.ProjektRapport;
import com.projectmanager.Medarbejder;

import com.projectmanager.*;

public class LavRapportStepDef {

    boolean harAktiviteter;

    // @Given("en {string} findes i systemet")
    // public void en_medarbejder_findes_i_systemet(String medarbejder){
    //     if (medarbejder.exists()) { //I know this sounds cooked but don't know how to write it well without the actual implementation of the Medarbejder class
    //         System.out.println("Medarbejder " + medarbejder + " findes i systemet.");
    //     } else {
    //         System.out.println("Medarbejder " + medarbejder + " findes ikke i systemet.");
    //     }
    // }

    @Given("en {string} er tilmeldt projekt {string}")
    public void er_tilmeldt_projekt(String medarbejder, String projektNavn){
        Projekt projekt = findProjekt(projektNavn); 
        ArrayList<Medarbejder> liste = projekt.getTilmeldte();
        for (Medarbejder m : liste) {
            if (medarbejder.equals(m)) {
                return true;
            }
        }
        return false;
    }

    @When("en {string} genererer rapport")
    public void forsøg_generer_rapport(String medarbejder){
        if (harAktiviteter) {
            return true;
        }
    }

    @When("der ikke er nogle aktivitet i projektet")
    public void projekt_mangler_aktiviteter(){
        if (projekt.get_aktiviteter().get_size() < 1) {
            harAktiviteter = false;
            return false;
        }
    }

    @Then("generer rapport ved navn {string}-rapport-uge-{int}")
    public void generer_rapport(String projektNavn, int ugenummer){
        ProjektRapport projektRapport = new ProjektRapport(projektNavn + "-rapport-uge-" + ugenummer);
        return projektRapport;
    }

    @Then("handling fejler med fejlbesked: 'ingen aktiviteter i projekt'")
    public void handling_fejler(){
        System.out.println("ingen aktiviteter i projekt");
    }
}




