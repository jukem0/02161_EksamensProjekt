package com.projectmanager;

import java.util.ArrayList;

public class Aktivitet {
    private String navn;
    private float budgetTimer;
    private Uge startUge, slutUge;
    private ArrayList<Medarbejder> tilknyttedeMedarbejdere = new ArrayList<Medarbejder>();
    private java.util.Map<String, Double> registreretTid = new java.util.HashMap<>();

    public Aktivitet(String navn, Uge startUge, Uge slutUge, float budgetgeretTid) {
        this.navn = navn;
        this.startUge = startUge;
        this.slutUge = slutUge;
        budgetTimer = budgetgeretTid;
    }

    public Aktivitet(String navn) {
        this.navn = navn;
    }

    public void redigerTidsperiode(Uge startUge, Uge slutUge) {
        if (slutUge.erEfter(startUge)) {
            this.startUge = startUge;
            this.slutUge = slutUge;
        }
    }

    public void tilføjMedarbejder(Medarbejder medarbejder) {
        tilknyttedeMedarbejdere.add(medarbejder);
    }

    public void redigerBudgeteretTid(float budgetgeretTid) {
        budgetTimer = budgetgeretTid;
    }

    public String getName() {
        return navn;
    }

    public float getBudgetTime() {
        return budgetTimer;
    }

    public void registrerTid(String medarbejderNavn, double tid) throws Exception {
        if (tid < 0) {
            throw new Exception("Tiden kan ikke indtastes som negativt");
        }
        // Rund op til nærmeste halve time
        double afrundetTid = Math.ceil(tid * 2) / 2.0;
        double nuværendeTid = registreretTid.getOrDefault(medarbejderNavn, 0.0);
        registreretTid.put(medarbejderNavn, nuværendeTid + afrundetTid);
    }

    public double getRegistreretTid(String medarbejderNavn) {
        return registreretTid.getOrDefault(medarbejderNavn, 0.0);
    }

    public Uge getStartUge() {
        return startUge;
    }

    public Uge getSlutUge() {
        return slutUge;
    }
}
