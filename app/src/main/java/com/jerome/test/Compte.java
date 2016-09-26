package com.jerome.test;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Compte {
    private Client client;
    private double solde;
    private String num;

    public Compte(Client client) {
        this(client, 0);
    }

    public Compte(Client client, double solde) {
        this.client = client;
        this.solde = solde;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void credite(double montant) {
        this.solde = this.solde + solde;
    }

    public void dedite(double montant) {
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
}
