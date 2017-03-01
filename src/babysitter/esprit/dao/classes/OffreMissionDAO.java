/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babysitter.esprit.dao.classes;
import babysitter.esprit.dao.interfaces.IoffreMissionDAO;
import babysitter.esprit.entities.OffreMission;
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
 * @author sassouki
 */
public class OffreMissionDAO implements IoffreMissionDAO{
    private static Object ioffreMissionDAO;
     private final Connection connection;
    public OffreMissionDAO() {
        connection = DataSource.getInstance().getConnection();
}
    public void insertOffreMission(OffreMission oM ) {
        String requete = "insert into offremission (date,description,adresse,horaire) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           
            ps.setString(1, oM.getDate());
            ps.setString(2, oM.getDescription());
            ps.setString(3, oM.getAdresse());
            ps.setString(4, oM.getHoraire());
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OffreMissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void updateOffreMission(int id,OffreMission oM) {
        String requete = "update offremission set date=? ,description=?, adresse=?, horaire=?  where idOffre=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(5, id);
            ps.setString(1, oM.getDate());
            ps.setString(2, oM.getDescription());
            ps.setString(3, oM.getAdresse());
            ps.setString(4, oM.getHoraire());
           
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    public void deleteOffreMission(String adresse) {
        String requete = "delete from offremission  where adresse=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, adresse);
            ps.executeUpdate();
            System.out.println("Offre mission supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
     public OffreMission findoffreMissionById(int id) {
        OffreMission oM = new OffreMission();
        String requete = "select * from offremission where idOffre="+id+";";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
               
                oM.setIdOffre(resultat.getInt(1));
                oM.setDate(resultat. getString(2));
                oM.setDescription(resultat.getString(3));
                oM.setAdresse(resultat.getString(4));
                oM.setHoraire(resultat.getString(5));
                
              
            }
            return oM;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
     }
     
    public List<OffreMission> AfficherOffreMission() 
    {
         List<OffreMission> listOffreMission = new ArrayList<OffreMission>();

        String requete = "select * from `bd_baby_sitting`.`offremission`";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IoffreMissionDAO offreMission = OffreMissionDAO.getInstance();
            while (resultat.next()) {
                OffreMission oM = new OffreMission();
                oM.setIdOffre(resultat.getInt(1));
                oM.setDate(resultat.getString(2));
                oM.setDescription(resultat.getString(3));
                oM.setAdresse(resultat.getString(4));
                oM.setHoraire(resultat.getString(5));
                
                
                listOffreMission.add(oM);
            }
            return listOffreMission;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des news  " + ex.getMessage());
            return null;
        }
    }
      private static IoffreMissionDAO ioffreMission;

    public static IoffreMissionDAO getInstance() {
        if (ioffreMission == null) {
            ioffreMission = new OffreMissionDAO();
        }
        return ioffreMission;
    }

    @Override
    public void insertfichebabysitter(OffreMission oM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
     

    
    
