/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.classes;

import babysitter.esprit.dao.interfaces.IResponsableGarderie;
import babysitter.esprit.entities.ResponsableGarderie;
import babysitter.esprit.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jamil
 */
public class ResponsableGarderieDAO implements IResponsableGarderie
{
    
    private Connection connection;
    
    public ResponsableGarderieDAO()
    {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void AjouterResp(ResponsableGarderie r) {
         String requete ="INSERT INTO  `bd_baby_sitting`.`user` (`login` ,`password` ,`nom` ,`prenom` ,`cin` ,`adresse` ,`codePostale` ,`email` ,`telephone` ,`typeUser`) VALUES (?,?,?,?,?,?,?,?,?,?);" ;
    try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(1, r.getLogin());
            ps.setString(2, r.getPassword());
            ps.setString(3, r.getNom());
            ps.setString(4, r.getPrenom());
            ps.setInt(5, r.getCin());
            ps.setString(6, r.getAdresse());
            ps.setLong(7, r.getCodePostale());
            ps.setString(8, r.getEmail());
            ps.setLong(9, r.getTelephone());
            ps.setString(10,"responsableGarderie"); 
            ps.executeUpdate();
            System.out.println("Ajout responsable garderie effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion du responsable garderie " + ex.getMessage());
        }
    }

    @Override
    public void SupprimerResp(int id) {
        String requete = "DELETE FROM `bd_baby_sitting`.`user` WHERE `user`.`idUser` = ? AND  `user`.`typeUser`='responsableGarderie';";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression Responsable Garderie effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du responsable garderie " + ex.getMessage());
        }
    }

    @Override
    public void ModifierResp(int id, ResponsableGarderie r) {
          String requete = " UPDATE  `bd_baby_sitting`.`user` SET  `login` =?,`password` =?,`nom` =?,`prenom` =?,`cin` =?,`adresse` =?,`codePostale` =?,`email` =?,`telephone` =? WHERE  `user`.`idUser` =? AND `user`.`typeUser`='responsableGarderie';";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, r.getLogin());
            ps.setString(2, r.getPassword());
            ps.setString(3, r.getNom());
            ps.setString(4, r.getPrenom());
            ps.setInt(5, r.getCin());
            ps.setString(6, r.getAdresse());
            ps.setLong(7, r.getCodePostale());
            ps.setString(8, r.getEmail());
            ps.setLong(9, r.getTelephone());
            ps.setInt(10, id);
            ps.executeUpdate();
            System.out.println("Modification responsable garderie effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la Modification du responsable garderie " + ex.getMessage());
        }
    }

    @Override
    public ResponsableGarderie RechercheResp(int id) {
       String requete = "SELECT  `idUser`,`login`, `password`, `nom`, `prenom`,`cin`, `adresse`, `codePostale`, `email`, `telephone` FROM  `user`  WHERE `user`.`typeUser`='responsableGarderie' AND `user`.`idUser`="+id+";";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            IResponsableGarderie resp = ResponsableGarderieDAO.getInstance();
            ResponsableGarderie r = new ResponsableGarderie();
            while (resultat.next()) {
              r.setIdUser(resultat.getInt(1));
                r.setLogin(resultat.getString(2));
               r.setPassword(resultat.getString(3));
               r.setNom(resultat.getString(4));
               r.setPrenom(resultat.getString(5));
               r.setCin(resultat.getInt(6));
               r.setAdresse(resultat.getString(7));
               r.setCodePostale(resultat.getInt(8));
               r.setEmail(resultat.getString(9));
               r.setTelephone(resultat.getInt(10));
               
            }
            return r;
              } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } 
    }

    @Override
    public List<ResponsableGarderie> AfficherResp() {
         List<ResponsableGarderie> listResp = new ArrayList<ResponsableGarderie>();

        String requete = "SELECT  `idUser`,`login`, `password`, `nom`, `prenom`,`cin`, `adresse`, `codePostale`, `email`, `telephone`,'etat' FROM  `user`  WHERE `user`.`typeUser`='responsableGarderie';";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IResponsableGarderie resp = ResponsableGarderieDAO.getInstance();
            while (resultat.next()) {
                ResponsableGarderie r = new ResponsableGarderie();
                 r.setIdUser(resultat.getInt(1));
                r.setLogin(resultat.getString(2));
               r.setPassword(resultat.getString(3));
               r.setNom(resultat.getString(4));
               r.setPrenom(resultat.getString(5));
               r.setCin(resultat.getInt(6));
               r.setAdresse(resultat.getString(7));
               r.setCodePostale(resultat.getInt(8));
               r.setEmail(resultat.getString(9));
               r.setTelephone(resultat.getInt(10));
               r.setEtat(resultat.getInt(11));
                listResp.add(r);
            }
            return listResp;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des news  " + ex.getMessage());
            return null;
    }
    }
   
    public void ModifierEtat(int id, int etat) 
    {
             String requete = " UPDATE  `bd_baby_sitting`.`user` SET etat=? WHERE  `user`.`idUser` =?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, etat);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            System.out.println("Modification Baby Sitter effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la Modification Baby Sitter " + ex.getMessage());
        }
  
    }
     private static ResponsableGarderieDAO iresp;

    public static ResponsableGarderieDAO getInstance() {
        if (iresp == null) {
            iresp = new  ResponsableGarderieDAO();
        }
        return iresp;
    }
}
