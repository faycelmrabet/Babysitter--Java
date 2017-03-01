/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.entities;

/**
 *
 * @author Fhima
 */
public class User {
    protected int idUser;
    protected int cin;
    protected String nom;
    protected String prenom;
    protected String login;
    protected String password;
    protected String email;

    public User(int idUser, int cin, String nom, String prenom,String email ,String login, String password) {
        this.idUser = idUser;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email=email;
        this.login = login;
        this.password = password;
    }

    public User() 
    {
      this.idUser =0;
        this.cin =0 ;
        this.nom ="";
        this.prenom ="";
        this.email="";
        this.login = "";
        this.password = "";   
    }

    public User(int cin, String nom, String prenom,String email ,String login, String password) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email=email;
        this.login = login;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "idUser=" + idUser + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + ", email=" + email ;
    }

   
    
    
    
}
