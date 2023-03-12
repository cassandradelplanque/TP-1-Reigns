package main;


public class Jauge {


    protected String nom;

    protected int valeur;

    public Jauge(String nom){
        this.nom = nom;
        this.valeur = 15 + (int)(Math.random() * (35 - 15));
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getValeur() {
        return valeur;
    }


    public void setValeur(int valeur) {
        this.valeur = valeur;
    }



}
