package com.projectmanager;

public class Projekt {
    private String projektNr, projektNavn;
    private int startUge;

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

}