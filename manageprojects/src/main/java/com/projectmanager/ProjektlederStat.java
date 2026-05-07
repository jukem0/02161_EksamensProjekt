package com.projectmanager;
import java.util.ArrayList;
import java.util.List;


public class ProjektlederStat {


    public record ProjektlederStat(boolean erProjektLeder, String projektnavn){}

    list<projek> systemProjekter = Projekt.alleProjekter();

    public static ProjektlederStat erProjektleder(String projektnavn, String medarbejder){
        if (systemProjekter.stream().anyMatch(p -> p.getProjektNavn().equalsIgnoreCase(projektnavn) && p.getProjektLeder() != null && p.getProjektLeder().getName().equalsIgnoreCase(medarbejder))) {
            return new ProjektlederStat(true, projektnavn);
        }
        else if (systemProjekter.stream().anyMatch(p->p.getProjektLeder() != null && p.getProjektLeder().getName().equalsIgnoreCase(medarbejder))) {
            String lederProjekt = systemProjekter.stream().filter(p -> p.getProjektLeder() != null && p.getProjektLeder().getName().equalsIgnoreCase(medarbejder)).findFirst().get().getProjektNavn();
            return new ProjektlederStat(false, lederProjekt);
        }
        else{
            return new ProjektlederStat(false, null);
        }
    }
}
