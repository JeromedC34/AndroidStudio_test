package com.jerome.test;

import java.util.List;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Client {
    private String nom;
    private String prénom;

    public Client(String nom, String prénom) {
        this.nom = nom;
        this.prénom = prénom;
    }

    public String getNomComplet() {
        return getNom() + " " + getPrénom();
    }
    public List<Compte> getComptes(){

    }
    @Override
    public String toString() {
        return "Client{}";
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }
}
