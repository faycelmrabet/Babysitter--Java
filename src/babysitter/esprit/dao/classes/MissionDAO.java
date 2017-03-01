/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.classes;

import babysitter.esprit.dao.interfaces.IMissionDAO;
import babysitter.esprit.entities.Mission;
import babysitter.esprit.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faycel
 */
public class MissionDAO implements IMissionDAO {

    

   
    private Connection connection;
    
    public MissionDAO() {
        connection=DataSource.getInstance().getConnection();
    }
   
    public void insertMission(Mission mission) {
       String requete = "INSERT INTO `mission`(`date`, `description`,`adresse`,`horaire`)VALUES"
                + " (?,?,?,?)";
        
        try
        {
              PreparedStatement ps = connection.prepareStatement(requete);
              ps.setString(1,mission.getDate());
              ps.setString(2,mission.getDescription());
              ps.setString(3,mission.getAdresse());
              ps.setString(4,mission.getHoraire());
              //ps.setInt(5,mission.getIdUser());
              ps.executeUpdate();

        }
        catch (SQLException ex) {
            Logger.getLogger(MissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("validee");
    }

    /**
     *
     * @param mission
     */
    
    public void updateMission(int id ,Mission mission){
        String requete="update  mission set date=? , description=? , adresse=?,horaire=? where `mission`.`idMission`=?";
        try{
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, mission.getDate());
            ps.setString(2, mission.getDescription());
            ps.setString(3, mission.getAdresse());
            ps.setString(4,mission.getHoraire());
            ps.setInt(5, id);
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
             
        }
         catch(SQLException ex){
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    
    public void deleteMission(int id){
        String requete="delete from mission where idMission=?";
        try{
            PreparedStatement ps=connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
              System.out.println("La Mission est supprimée");
        }catch(SQLException ex){
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    @Override
    public Mission findMissionById(int id ){
        Mission mission = new Mission();
        String requete="select * from mission where idMission=?";
        try{
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                mission.setIdMission(resultat.getInt(1));
                mission.setDate(resultat.getString(2));
                mission.setDescription(resultat.getString(3));
                mission.setAdresse(resultat.getString(4));
                mission.setHoraire(resultat.getString(5));
                
            }
        }catch(SQLException ex){
            System.out.println("erreur lors de la recherche de la mission " + ex.getMessage());
            return null;
        }
        return mission;
        
        
    }
    @Override
  public List<Mission> AfficherMission(){
      List<Mission>listemissions = new ArrayList<>();
      String requete="select * from mission";
      try{
          Statement statement=connection.createStatement();
          ResultSet resultat=statement.executeQuery(requete);
          
          while(resultat.next()){
              Mission mission= new Mission();
              mission.setIdMission(resultat.getInt(1));
              mission.setDate(resultat.getString(2));
              mission.setDescription(resultat.getString(1));
              mission.setAdresse(resultat.getString(2));
              mission.setHoraire(resultat.getString(2));
              
              listemissions.add(mission);
          }
          return listemissions;
          
      }
      catch(SQLException ex){
          System.out.println("Erreur lors du chargement des missions " +ex.getMessage());
          return null;
      }
  }
  
    
private static IMissionDAO iMissionDAO;

    public static IMissionDAO getInstance() {
        if (iMissionDAO == null) {
            iMissionDAO = new MissionDAO();
        }
        return iMissionDAO;
    }

  

}
