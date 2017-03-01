/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.entities;

/**
 *
 * @author Rahma
 */
public class FicheBabySitter {
    
   private int idFiche;
    private String titre;
    private String nom;
    private String experience;
    private String consigne;

    public FicheBabySitter() {
        
         this.idFiche= 0;
         this.titre = "";
        this.nom = "";
        this.experience = "";
        this.consigne = "";
        
        
    }

    public FicheBabySitter(int idFiche, String titre, String nom, String experience, String consigne) {
        
        this.idFiche = idFiche;
        this.titre = titre;
        this.nom = nom;
        this.experience = experience;
        this.consigne = consigne;
    }

    

    public int getIdFiche() {
        return idFiche;
    }

  

    public String getTitre() {
        return titre;
    }

    public String getNom() {
        return nom;
    }

    public String getExperience() {
        return experience;
    }

    public String getConsigne() {
        return consigne;
    }

    public void setIdFiche(int idFiche) {
        this.idFiche = idFiche;
    }

    

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }
    
    
    
    
    
}
