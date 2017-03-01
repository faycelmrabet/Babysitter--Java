/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.interfaces;

import babysitter.esprit.entities.BabySitter;

import java.util.List;

/**
 *
 * @author Fhima
 */
public interface IBabySitter 
{
 public void AjouterBabySitter(BabySitter bs);
     public void SupprimerBabySitter(int id);
     public void ModifierBabySitter(int id,BabySitter bs);
     public void ModifierEtat(int id,int etat);
     public BabySitter RechercheBabySitter(int id);
     public List<BabySitter> AfficherBabySitter();
        
}
