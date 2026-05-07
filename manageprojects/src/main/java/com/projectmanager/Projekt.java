package com.projectmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Projekt {
    private String projektNr, projektNavn;
    private int startUge;
    public static List<Aktivitet> aktiviteter = new ArrayList<>(); 
    // java kan af en eller anden grund bedre lide når <> er angivet på højre side, i stedet for gentagelsen af hvad der står på venstre side
    // for at undgå at skulle rette alle steder hvor der bruges arraylist, hvis vi skal skifte, kan vi oprette vores lister med list interfacet. 

    private Medarbejder projektLeder;

    private Map<Medarbejder, List<Aktivitet>> medarbejderAktiviteter = new HashMap<>();

    //Lav map med medarbejder som "key" og liste over tilnkyttede aktiviteter som værdi der kan returneres.

    public Projekt(String pnavn) {
        this.projektNavn = pnavn;
    }
    
    public void tilføjAktivitet(String navn) {
        Aktivitet tempAktivitet = new Aktivitet(navn);
        aktiviteter.add(tempAktivitet);
    }

    public void tilføjAktivitet(String navn, Uge startUge, Uge slutUge, int budgetgeretTid){
        Aktivitet tempAktivitet = new Aktivitet(navn, startUge, slutUge, budgetgeretTid);
        aktiviteter.add(tempAktivitet);
    }

    public void tildelLeder() {

    }

    public Medarbejder getProjektLeder(){
        return projektLeder;
    }
    
    public void genererProjektRapport() {

    }

    public void setProjektNr(String Nr) {
        this.projektNr = "26"+Nr;
    }

    public String getProjektNavn() {
        return this.projektNavn;
    }

    public String getProjektNr() {
        return this.projektNr;
    }

    public List<Aktivitet> getAktiviteter(){
        return aktiviteter;
    }

    public Map<Medarbejder, List<Aktivitet>> getMedarbejderAktiviteter(){
        return medarbejderAktiviteter;
    }

}