/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.entities;

/**
 *
 * @author Jamil
 */
public class ResponsableGarderie extends User
{
private String adresse;
private long codePostale;
private long telephone;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
private int etat;

    public ResponsableGarderie() 
    {
        this.adresse = "";
        this.codePostale = 0;
        this.telephone = 0;
    }

    public ResponsableGarderie(String adresse, long codePostale, long telephone, int cin, String nom, String prenom, String email, String login, String password) {
        super(cin, nom, prenom, email, login, password);
        this.adresse = adresse;
        this.codePostale = codePostale;
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(long codePostale) {
        this.codePostale = codePostale;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "ResponsableGarderie{" + "adresse=" + adresse + ", codePostale=" + codePostale + ", telephone=" + telephone + ", etat=" + etat + '}';
    }

    
  

}
