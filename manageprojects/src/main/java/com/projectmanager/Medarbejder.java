package com.projectmanager;

public class Medarbejder {
    private String initialer;
    private Boolean erledig = true;

    public Medarbejder(String ini) {
        this.initialer = ini;
    }

    public void registrerTid() {

    }

    public void seTimer() {

    }

    public void blivProjektLeder() {
        
    }

    public boolean erLedig(){
        return erledig;
    }

    public String getName() {
        return initialer;
    }

    public void setName(String name) {
        this.initialer = name;
    }
}
