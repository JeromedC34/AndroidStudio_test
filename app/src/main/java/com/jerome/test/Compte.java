package com.jerome.test;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Compte {
    private Client client;
    private double solde;
    private String num;

    public String getNum() {
        return num;
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }
    public Compte(Client client) {
        this.client = client;
        this.solde = 0;
    }
    public Compte(Client client, double solde) {
        this.client = client;
        this.solde = solde;
    }
    public void crédite(double montant) {
        this.solde = this.solde + solde;
    }
    public void dédite(double montant) {
        this.solde = this.solde - solde;
    }
    @Override
    public String toString() {
        return "Compte{" +
                "client=" + client +
                ", solde=" + solde +
                ", num=" + num +
                '}';
    }

    public void setClient(Client client) {
        this.client = client;
    }



    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
