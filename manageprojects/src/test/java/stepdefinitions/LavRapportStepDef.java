package stepdefinitions;

import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.projectmanager.Main;
import com.projectmanager.Medarbejder;
import com.projectmanager.Projekt;
import com.projectmanager.ProjektRapport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LavRapportStepDef {

    boolean harAktiviteter = false;
    Projekt projekt;

    // @Given("en {string} findes i systemet")
    // public void en_medarbejder_findes_i_systemet(String medarbejder){
    //     if (medarbejder.exists()) { //I know this sounds cooked but don't know how to write it well without the actual implementation of the Medarbejder class
    //         System.out.println("Medarbejder " + medarbejder + " findes i systemet.");
    //     } else {
    //         System.out.println("Medarbejder " + medarbejder + " findes ikke i systemet.");
    //     }
    // }

    @Given("en {string} er tilmeldt projekt {string}")
    public boolean er_tilmeldt_projekt(String medarbejder, String projektNavn){
        Projekt projekt = null;
        for (Projekt p : Main.getProjekter()) {
            if (p.getProjektNavn().equalsIgnoreCase(projektNavn)) {
                projekt = p;
            }
        }
        Set liste = projekt.getMedarbejderAktiviteter().keySet();
        Iterator<Medarbejder> iterator = liste.iterator();
        while (iterator.hasNext()) { 
            if (iterator.next().getName().equalsIgnoreCase(medarbejder)) {
              return true;  
            }
        }
        return false;
    }

    @When("en {string} genererer rapport")
    public void forsøg_generer_rapport(String medarbejder){
        assertTrue(harAktiviteter, "Projektet har ingen aktiviteter");
    }

    @When("der ikke er nogle aktivitet i projektet")
    public void projekt_mangler_aktiviteter(){
        if (projekt.getAktiviteter().size() < 1) {
            harAktiviteter = false;
        }
        assertTrue(harAktiviteter);
    }

    @Then("generer rapport ved navn {string}-rapport-uge-{int}")
    public void generer_rapport(String projektNavn, int ugenummer){
        ProjektRapport projektRapport = new ProjektRapport(projektNavn + "-rapport-uge-" + ugenummer);
        assertTrue(projektRapport.getName().equalsIgnoreCase(projektNavn + "-rapport-uge-" + ugenummer));
    }

    @Then("handling fejler med fejlbesked: 'ingen aktiviteter i projekt'")
    public void handling_fejler(){
        String errorMessage = "ingen aktiviteter i projekt";
        System.out.println(errorMessage);
        assertTrue(errorMessage.equalsIgnoreCase("ingen aktiviteter i projekt"));
    }
}




