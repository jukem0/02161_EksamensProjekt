package com.projectmanager;

import java.util.List;

import static com.projectmanager.Projekt.aktiviteter;

public class ProjektFunktioner {

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
    
    public void genererProjektRapport() {

    }

    public List<Projekt> alleProjekter(){
        return null;
    }

}
