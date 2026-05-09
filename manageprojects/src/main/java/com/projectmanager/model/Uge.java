package com.projectmanager.model;

public class Uge {
    int ugenummer, aar;

    public Uge(int ugenummer, int aar) {
        this.ugenummer = ugenummer;
        this.aar = aar;
    }

    public boolean erEfter(Uge andenUge) {
        if (andenUge.getAar() > aar) {
            return false;
        } else if (andenUge.getAar() < aar) {
            return true;
        } else if (andenUge.getUgenummer() > ugenummer) {
            return false;
        } else {
            return true;
        }
    }

    public int getUgenummer() {
        return ugenummer;
    }

    public int getAar() {
        return aar;
    }
}
