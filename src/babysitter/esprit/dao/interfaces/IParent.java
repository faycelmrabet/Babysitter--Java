/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.interfaces;

import babysitter.esprit.entities.Parent;
import java.util.List;

/**
 *
 * @author Fhima
 */
public interface IParent 
{
    public void AjouterParent(Parent p);
     public void SupprimerParent(String mail);
     public void ModifierParent(int id,Parent p);
     public Parent RechercheParent(int id);
     public List<Parent> AfficherParent();
}
