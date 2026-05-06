package com.projectmanager;

import java.util.ArrayList;
import java.util.HashMap;

public class Projekt {
    private String projektNr, projektNavn;
    private int startUge;
    public static ArrayList<Aktivitet> aktiviteter = new ArrayList<Aktivitet>();

    private Medarbejder projektLeder;

    private HashMap<Medarbejder, ArrayList<Aktivitet>> medarbejderAktiviteter = new HashMap<Medarbejder, ArrayList<Aktivitet>>();

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

}