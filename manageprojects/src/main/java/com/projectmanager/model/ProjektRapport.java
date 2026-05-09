package com.projectmanager.model;

public class ProjektRapport {
    private String projektNr, navn;
    private double budgetteretTid, brugtTid, tidIforhold;

    public ProjektRapport(String navn) {
    }

    public String getName() {
        return navn;
    }
}
