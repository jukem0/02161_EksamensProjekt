package com.projectmanager;

import java.util.ArrayList;

public class Aktivitet {
    private String navn;
    private int budgetTimer;
    private Uge startUge, slutUge;
    private ArrayList<Medarbejder> tilknyttedeMedarbejdere = new ArrayList<Medarbejder>();

    public Aktivitet(String navn, Uge startUge, Uge slutUge, int budgetgeretTid) {
        this.navn = navn;
        this.startUge = startUge;
        this.slutUge = slutUge;
        budgetTimer = budgetgeretTid;
    }

    public Aktivitet(String navn){
        this.navn = navn;
    }

    public void redigerTidsperiode(Uge startUge, Uge slutUge){
        if (slutUge.erEfter(startUge)) {
            this.startUge = startUge;
            this.slutUge = slutUge;
        }
    }

    public void tilføjMedarbejder(Medarbejder medarbejder) {
        tilknyttedeMedarbejdere.add(medarbejder);
    }

    public void redigerBudgeteretTid(int budgetgeretTid){
        budgetTimer = budgetgeretTid;
    }

}
