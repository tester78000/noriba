package com.example.farid.noriba.model;

/**
 * Created by farid on 21/01/2018.
 */

public class User {
    private String login ;
    private String pass ;
    private String nom ;
    private String prenom ;
    private String type ;

    public User(String login, String pass, String nom, String prenom, String type) {
        this.login = login;
        this.pass = pass;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public User setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public User setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public User setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getType() {
        return type;
    }

    public User setType(String type) {
        this.type = type;
        return this;
    }
}
