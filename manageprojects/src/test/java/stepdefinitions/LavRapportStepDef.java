package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.projectmanager.Projekt;
import com.projectmanager.ProjektRapport;
import com.projectmanager.Medarbejder;

public class LavRapportStepDef {

    boolean harAktiviteter;

    @Given("en {medarbejder} findes i systemet")
    public void en_medarbejder_findes_i_systemet(Medarbejder medarbejder){
        if (medarbejder.exists()) { //I know this sounds cooked but don't know how to write it well
            return true;
        }
    }

    @Given("en {medarbejder} er tilmeldt projekt {projekt}")
    public void er_tilmeldt_projekt(Medarbejder medarbejder, Projekt projekt){
        ArrayList<> liste = projekt.getTilmeldte();
        for (Medarbejder medarb : liste) {
            if (medarbejder.equals(medarb)) {
                return true;
            }
        }
        return false;
    }

    @When("en {medarbejder} genererer rapport")
    public void forsøg_generer_rapport(Medarbejder medarbejder){
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

    @Then("generer rapport ved navn {String}-rapport-uge-{Integer}")
    public void generer_rapport(String projektNavn, int ugenummer){
        ProjektRapport projektRapport = new ProjektRapport(projektNavn + "-rapport-uge-" + ugenummer);
        return projektRapport;
    }

    @Then("handling fejler med fejlbesked: \"ingen aktiviteter i projekt\"")
    public void handling_fejler(){
        System.out.println("ingen aktiviteter i projekt");
    }
}

