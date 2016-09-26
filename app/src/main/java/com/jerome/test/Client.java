package com.jerome.test;

import java.util.Map;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Client {
    private String nom;
    private String prenom;
    private Map<String, Compte> comptes;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomComplet() {
        return getNom() + " " + getPrenom();
    }

    public Map<String, Compte> getComptes() {
        return comptes;
    }

    @Override
    public String toString() {
        return "Client{}";
    }

    public void fermeCompte(Compte compte) {
        comptes.remove(compte.getNum());
    }
}
