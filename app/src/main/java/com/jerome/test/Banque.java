package com.jerome.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Banque {
    private Map<String, Client> clients;
    private Map<String, Compte> comptes;

    public Banque() {
        clients = new HashMap<>();
        comptes = new HashMap<>();
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public Map<String, Compte> getComptes() {
        return comptes;
    }

    public Client getClient(String nom, String prenom) {
        Client result = null;
        for (String key : clients.keySet()) {
            if (clients.get(key).getNom().equals(nom) && clients.get(key).getPrenom().equals(prenom)) {
                result = clients.get(key);
                break;
            }
        }
        return result;
    }

    public Compte getCompte(String num) {
        Compte result = null;
        for (String key : comptes.keySet()) {
            if (comptes.get(key).getNum().equals(num)) {
                result = comptes.get(key);
                break;
            }
        }
        return result;
    }

    public void ajouteClient(Client client) {
        clients.put(client.getNomComplet(), client);
    }

    public Client ajouteClient(String nom, String prenom) {
        Client result = new Client(nom, prenom);
        clients.put(result.getNomComplet(), result);
        return result;
    }

    public void supprimeClient(Client client) {
        for (String key : client.getComptes().keySet()) {
            fermeCompte(client.getComptes().get(key));
        }
        clients.remove(client.getNomComplet());
    }

    public void supprimeClient(String nom, String prenom) {
        supprimeClient(getClient(nom, prenom));
    }

    public Compte ouvreCompte(Client client) {
        return ouvreCompte(client, 0);
    }

    public Compte ouvreCompte(Client client, double depot) {
        Compte result = new Compte(client, depot);
        comptes.put(result.getNum(), result);
        return result;
    }

    public Compte ouvreCompte(String nom, String prenom) {
        Client client = ajouteClient(nom, prenom);
        Compte result = ouvreCompte(client);
        return result;
    }

    public Compte ouvreCompte(String nom, String prenom, double depot) {
        Client client = ajouteClient(nom, prenom);
        Compte result = ouvreCompte(client, depot);
        return result;
    }

    public void fermeCompte(String num) {
        Compte compte = comptes.get(num);
        fermeCompte(compte);
    }

    public void fermeCompte(Compte compte) {
        Client client = compte.getClient();
        client.fermeCompte(compte);
        comptes.remove(compte.getNum());
    }

    @Override
    public String toString() {
        return "Banque{}";
    }
}
