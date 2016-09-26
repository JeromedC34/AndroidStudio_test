package com.jerome.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Banque {
    public Banque() {
    }

    public List<Client> getClients() {
        List<Client> result = new ArrayList<>();
        return result;
    }

    public List<Compte> getComptes() {
        List<Compte> result = new ArrayList<>();
        return result;
    }

    public Client getClient(String nom, String prenom) {
        Client result = new Client();
        return result;
    }
    public Compte getCompte(String num) {
        Compte result = new Compte();
        return result;
    }
    public Client ajouteClient(Client client) {
        Client result = new Client();
        return result;
    }
    public Client ajouteClient(String nom, String prenom) {
        Client result = new Client();
        return result;
    }
    public Client supprimeClient(Client client) {
        Client result = new Client();
        return result;
    }
    public Client supprimeClient(String nom, String prenom) {
        Client result = new Client();
        return result;
    }
    public Compte ouvreCompte(Client client) {
        Compte result = new Compte();
        return result;
    }
    public Compte ouvreCompte(Client client, double dépot) {
        Compte result = new Compte();
        return result;
    }
    public Compte ouvreCompte(String nom, String prenom) {
        Compte result = new Compte();
        return result;
    }
    public Compte ouvreCompte(String nom, String prenom, double dépot) {
        Compte result = new Compte();
        return result;
    }
    public Compte fermeCompte(String num) {
        Compte result = new Compte();
        return result;
    }
    public Compte fermeCompte(Compte compte) {
        Compte result = new Compte();
        return result;
    }
    @Override
    public String toString() {
        return "Banque{}";
    }
}
