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
public class Parent extends User
{
  private int telephone;
  private int nbrEnfants;
  private int codePostale;
  private String address;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
  private int etat;

    public Parent() 
    {
      this.telephone = 0;
        this.nbrEnfants = 0;
        this.codePostale = 0;
        this.address = "";  
    }

  
    public Parent(int telephone, int nbrEnfants, int codePostale, String address, int cin, String nom, String prenom, String email, String login, String password)
    {
        super(cin, nom, prenom, email, login, password);
        this.telephone = telephone;
        this.nbrEnfants = nbrEnfants;
        this.codePostale = codePostale;
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getNbrEnfants() {
        return nbrEnfants;
    }

    public void setNbrEnfants(int nbrEnfants) {
        this.nbrEnfants = nbrEnfants;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Parent{" + "telephone=" + telephone + ", nbrEnfants=" + nbrEnfants + ", codePostale=" + codePostale + ", address=" + address + ", etat=" + etat + '}';
    }

   
  
  
  
  
}
