/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.interfaces;

import babysitter.esprit.entities.OffreMission;
import java.util.List;

/**
 *
 * @author sassouki
 */
public interface IoffreMissionDAO {

    public void insertOffreMission(OffreMission c);
     public void updateOffreMission(int id,OffreMission oM);
     public void deleteOffreMission(String adresse);
     public List<OffreMission> AfficherOffreMission();
      public OffreMission findoffreMissionById(int id);

    public void insertfichebabysitter(OffreMission oM);

    
}
