/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.dao.classes;

import babysitter.esprit.dao.interfaces.IBabySitter;
import babysitter.esprit.entities.BabySitter;
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
 * @author Fhima
 */
public class BabySitterDAO implements IBabySitter {
     private Connection connection;

    public BabySitterDAO() 
    {
        connection = DataSource.getInstance().getConnection();
    }
     
    @Override
    public void AjouterBabySitter(BabySitter bs) {
       String requete ="INSERT INTO `bd_baby_sitting`.`user` (`login`, `password`, `nom`, `prenom`, `dateNaissance`, `cin`, `adresse`, `codePostale`, `email`, `telephone`,`typeUser`,etat) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);" ;
    try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(1, bs.getLogin());
            ps.setString(2, bs.getPassword());
            ps.setString(3, bs.getNom());
            ps.setString(4, bs.getPrenom());
            ps.setString(5, bs.getDateNaissance());
            ps.setInt(6, bs.getCin());
            ps.setString(7, bs.getAdresse());
            ps.setInt(8, bs.getCodePostale());
            ps.setString(9, bs.getEmail());
            ps.setInt(10, bs.getTelephone());
            ps.setString(11,"babySitter"); 
            ps.setInt(12,0);
            ps.executeUpdate();
            System.out.println("Ajout Baby Sitter effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion du Baby Sitter " + ex.getMessage());
        }
    
    }

    @Override
    public void SupprimerBabySitter(int id) {
        String requete = "DELETE FROM `bd_baby_sitting`.`user` WHERE `user`.`idUser` = ? AND  `user`.`typeUser`='babySitter';";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression Baby Sitter effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du Baby Sitter " + ex.getMessage());
        }
    }

    @Override
    public void ModifierBabySitter(int id, BabySitter bs) {
        
        String requete = " UPDATE  `bd_baby_sitting`.`user` SET  `login` =?,`password` =?,`nom` =?,`prenom` =?,`dateNaissance` =?,`cin` = ?,`adresse` = ?,`codePostale` =?,`email` =?,`telephone` =? WHERE  `user`.`idUser` =?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(11, id);
            ps.setString(1, bs.getLogin());
            ps.setString(2, bs.getPassword());
            ps.setString(3, bs.getNom());
            ps.setString(4, bs.getPrenom());
            ps.setString(5, bs.getDateNaissance());
            ps.setInt(6, bs.getCin());
            ps.setString(7, bs.getAdresse());
            ps.setInt(8, bs.getCodePostale());
            ps.setString(9, bs.getEmail());
            ps.setInt(10, bs.getTelephone());
            ps.executeUpdate();
            System.out.println("Modification Baby Sitter effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la Modification Baby Sitter " + ex.getMessage());
        }
    }

    @Override
    public BabySitter RechercheBabySitter(int id) 
    {
     String requete = "SELECT  `idUser`,`login`, `password`, `nom`, `prenom`, `dateNaissance`, `cin`, `adresse`, `codePostale`, `email`, `telephone`,etat FROM  `user`  WHERE `user`.`typeUser`='babySitter' AND `user`.`idUser`="+id+";";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            IBabySitter babysitter = BabySitterDAO.getInstance();
            BabySitter bs = new BabySitter();
            while (resultat.next()) {

                bs.setIdUser(resultat.getInt(1));
                bs.setLogin(resultat.getString(2));
                bs.setPassword(resultat.getString(3));
                bs.setNom(resultat.getString(4));
                bs.setPrenom(resultat.getString(5));
                bs.setDateNaissance(resultat.getString(6));
                bs.setCin(resultat.getInt(7));
                bs.setAdresse(resultat.getString(8));
                bs.setCodePostale(resultat.getInt(9));
                bs.setEmail(resultat.getString(10));
                bs.setTelephone(resultat.getInt(11));
                bs.setEtat(resultat.getInt(12));
            }
            return bs;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }   
    }

    @Override
    public List<BabySitter> AfficherBabySitter() {
        List<BabySitter> listBabySitter = new ArrayList<BabySitter>();

        String requete = "SELECT  `idUser`,`login`, `password`, `nom`, `prenom`, `dateNaissance`, `cin`, `adresse`, `codePostale`, `email`, `telephone`,etat FROM  `user`  WHERE `user`.`typeUser`='babySitter';";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IBabySitter babysitter = BabySitterDAO.getInstance();
            while (resultat.next()) {
                BabySitter bs = new BabySitter();
                bs.setIdUser(resultat.getInt(1));
                bs.setLogin(resultat.getString(2));
                bs.setPassword(resultat.getString(3));
                bs.setNom(resultat.getString(4));
                bs.setPrenom(resultat.getString(5));
                bs.setDateNaissance(resultat.getString(6));
                bs.setCin(resultat.getInt(7));
                bs.setAdresse(resultat.getString(8));
                bs.setCodePostale(resultat.getInt(9));
                bs.setEmail(resultat.getString(10));
                bs.setTelephone(resultat.getInt(11));
                bs.setEtat(resultat.getInt(12));
                listBabySitter.add(bs);
            }
            return listBabySitter;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des news  " + ex.getMessage());
            return null;
    }
    }
        private static BabySitterDAO ibabysitter;

    public static BabySitterDAO getInstance() {
        if (ibabysitter == null) {
            ibabysitter = new  BabySitterDAO();
        }
        return ibabysitter;
    }

    @Override
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
}
