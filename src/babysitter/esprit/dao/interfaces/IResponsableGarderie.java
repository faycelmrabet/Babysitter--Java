/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.interfaces;

import babysitter.esprit.entities.ResponsableGarderie;
import java.util.List;


/**
 *
 * @author Jamil
 */
public interface IResponsableGarderie 
{
     public void AjouterResp(ResponsableGarderie r) ;
     public void SupprimerResp(int id);
     public void ModifierResp(int id,ResponsableGarderie r);
     public ResponsableGarderie RechercheResp(int id);
     public List<ResponsableGarderie> AfficherResp();
}
