/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.classes;

import babysitter.esprit.dao.interfaces.Ifichebabysitter;
import babysitter.esprit.entities.FicheBabySitter;
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
 * @author Rahma
 */



public class FicheBabySitterDAO implements Ifichebabysitter {
    
     private Connection connection;

    private FicheBabySitterDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    
     @Override
 public void insertfichebabysitter(FicheBabySitter  fiche ) {
        String requete = "insert into fichebabysitter ( `nom`, `titre`, `experience`, `consigne`) VALUES (?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           
            ps.setString(1, fiche.getNom());
            ps.setString(2, fiche.getTitre());
            ps.setString(3, fiche.getExperience());
            ps.setString(4, fiche.getConsigne());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FicheBabySitterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
  public void updateFiche(FicheBabySitter  fiche,int id) {
  String requete = "UPDATE `fichebabysitter` SET `nom`=?,`titre`=?,`experience`=?,`consigne`=? WHERE `idFiche`=?;";

        try {
           PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.setString(2, fiche.getNom());
            ps.setString(3, fiche.getTitre());
            ps.setString(4, fiche.getExperience());
            ps.setString(5, fiche.getConsigne());
            ps.executeUpdate();
            System.out.println("Modification effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la Modification " + ex.getMessage());
        }
    }

     @Override
    public void DeleteFiche(int id) 
    {
        String requete = "delete from `bd_baby_sitting`.`fichebabysitter` where idFiche=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

      public FicheBabySitter FindFiche(int id) 
    {
         FicheBabySitter fiche= new FicheBabySitter();
     String requete = "select * from `bd_baby_sitting`.`fichebabysitter` where `idFiche` ="+id+";";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            Ifichebabysitter fichebabysitter = FicheBabySitterDAO.getInstance();
          
          //  fichebabysitter fiche= new fichebabysitter();
            while (resultat.next()) {

                fiche.setIdFiche(resultat.getInt(1));
                fiche.setNom(resultat.getString(2));
                fiche.setTitre(resultat.getString(3));
                fiche.setExperience(resultat.getString(4));
                fiche.setConsigne(resultat.getString(5));
            }
            return fiche;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }   
    }

    //
     @Override
   public List<FicheBabySitter> Afficherfichebabysitter() 
    {
         List<FicheBabySitter> listFichebabysitter = new ArrayList<FicheBabySitter>();

        String requete = "select * from `bd_baby_sitting`.`fichebabysitter`";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Ifichebabysitter fichebabysitter = FicheBabySitterDAO.getInstance();
            while (resultat.next()) {
                FicheBabySitter fiche = new FicheBabySitter();
                fiche.setIdFiche(resultat.getInt(1));
                fiche.setNom(resultat.getString(2));
                fiche.setTitre(resultat.getString(3));
                fiche.setExperience(resultat.getString(4));
                fiche.setConsigne(resultat.getString(5));
                listFichebabysitter.add(fiche);
            }
            return  listFichebabysitter ;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des news  " + ex.getMessage());
            return null;
        }
    }

   private static FicheBabySitterDAO ifichebabysitter;

    public static FicheBabySitterDAO getInstance() {
        if (ifichebabysitter== null) {
            ifichebabysitter = new FicheBabySitterDAO  ();
        }
        return  ifichebabysitter ;
    }

    

}


