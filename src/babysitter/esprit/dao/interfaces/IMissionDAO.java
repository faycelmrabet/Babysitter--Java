/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.interfaces;

import babysitter.esprit.entities.Mission;
import java.util.List;

/**
 *
 * @author Faycel
 */
public interface IMissionDAO {
    public void insertMission(Mission mission);
    public void updateMission(int id, Mission mission);
    public void deleteMission(int id );
    public Mission findMissionById(int id);
    public List<Mission> AfficherMission();
    
    
    
}
