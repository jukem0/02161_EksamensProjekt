package com.projectmanager.model;

public class ProjectReport {
    private String projektNr, navn;
    private double budgetteretTid, brugtTid, tidIforhold;

    public ProjectReport(String navn) {
    }

    public String getName() {
        return navn;
    }
}
