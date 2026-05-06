package com.projectmanager;

import java.util.ArrayList;

public class Projekt {
    private String projektNr, projektNavn;
    private int startUge;
    public static ArrayList<Aktivitet> aktiviteter = new ArrayList<Aktivitet>();

    public Projekt(String pnavn) {
        this.projektNavn = pnavn;
    }
    
    public void tilføjAktivitet() {

    }

    public void tildelLeder() {

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