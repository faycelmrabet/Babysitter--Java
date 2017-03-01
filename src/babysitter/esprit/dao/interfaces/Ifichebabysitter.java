/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.interfaces;

import babysitter.esprit.entities.FicheBabySitter;
import java.util.List;

/**
 *
 * @author Rahma
 */
public interface Ifichebabysitter {
    
    
    
     public void insertfichebabysitter(FicheBabySitter  fiche );
    public void updateFiche(FicheBabySitter  fiche,int id);
      public void DeleteFiche(int id) ;
      public FicheBabySitter FindFiche(int id);
        public List<FicheBabySitter> Afficherfichebabysitter();
    
}
