/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.entities;


/**
 *
 * @author sassouki
 */
public class OffreMission {
    
    private int idOffre;

   
    private String date;
    private String description;
    private String adresse;
    private String horaire;
   

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

   

   
     public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
     public OffreMission()
    {
        this.idOffre=0;
        this.date = "";
        this.description= "";
        this.adresse= "";
        this.horaire= "";
       
        
    }
    public OffreMission(String date,String description,String adresse,String horaire ) {
        
        this.date = date;
        this.description= description;
        this.adresse= adresse;
        this.horaire= horaire;
        
    } 

    @Override
    public String toString() {
        return "OffreMission{" + "idOffre=" + idOffre + ", date=" + date + ", description=" + description + ", adresse=" + adresse + ", horaire=" + horaire + '}';
    }

   

  

    
    
    
}
