package com.projectmanager;

import java.util.List;

public class Medarbejder {
    private String initialer;
    private boolean erLedig = true;

    public Medarbejder(String ini) {
        this.initialer = ini;
    }

    public boolean erLedig(){
        return erLedig;
    }

    public void registrerTid() {

    }

    public void seTimer() {

    }

    public void blivProjektLeder() {
        
    }

    public String getName() {
        return initialer;
    }

    public void setName(String name) {
        this.initialer = name;
    }

    public List<Medarbejder> ledigeMedarbejder (){
        return null;
    }
    
    public List<Medarbejder> alleMedarbejders (){
        return null;
    }
}
