package babysitter.esprit.dao.classes;

import babysitter.esprit.dao.interfaces.IParent;
import babysitter.esprit.entities.Parent;
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
public class ParentDAO implements IParent
{
    private Connection connection;

    public ParentDAO() 
    {
        connection = DataSource.getInstance().getConnection();
    }
    

    @Override
    public void AjouterParent(Parent p) {
         String requete ="INSERT INTO  `bd_baby_sitting`.`user` (`login` ,`password` ,`nom` ,`prenom` ,`cin` ,`adresse` ,`codePostale` ,`email` ,`telephone` ,`nbreEnfant` ,`typeUser`) VALUES (?,?,?,?,?,?,?,?,?,?,?);" ;
    try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(1, p.getLogin());
            ps.setString(2, p.getPassword());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getPrenom());
            ps.setInt(5, p.getCin());
            ps.setString(6, p.getAddress());
            ps.setInt(7, p.getCodePostale());
            ps.setString(8, p.getEmail());
            ps.setInt(9, p.getTelephone());
            ps.setInt(10, p.getNbrEnfants());
            ps.setString(11,"parent"); 
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    @Override
    public void SupprimerParent(String mail) 
    {
        String requete = "DELETE FROM `bd_baby_sitting`.`user` WHERE `user`.`email` = ? AND  `user`.`typeUser`='parent';";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, mail);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public void ModifierParent(int id, Parent p) 
    {
         String requete = " UPDATE  `bd_baby_sitting`.`user` SET  `login` =?,`password` =?,`nom` =?,`prenom` =?,`cin` =?,`adresse` =?,`codePostale` =?,`email` =?,`telephone` =?,`nbreEnfant` =? WHERE  `user`.`idUser` =? AND `user`.`typeUser`='parent';";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, p.getLogin());
            ps.setString(2, p.getPassword());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getPrenom());
            ps.setInt(5, p.getCin());
            ps.setString(6, p.getAddress());
            ps.setInt(7, p.getCodePostale());
            ps.setString(8, p.getEmail());
            ps.setInt(9, p.getTelephone());
            ps.setInt(10, p.getNbrEnfants());
            ps.setInt(11, id);
            ps.executeUpdate();
            System.out.println("Modification effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la Modification " + ex.getMessage());
        }
    }

    @Override
    public Parent RechercheParent(int id)
    {
        String requete = "SELECT  `idUser`,`login`, `password`, `nom`, `prenom`,`cin`, `adresse`, `codePostale`, `email`, `telephone`,`nbreEnfant` FROM  `user`  WHERE `user`.`typeUser`='parent' AND `user`.`idUser`="+id+";";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            IParent parent = ParentDAO.getInstance();
            Parent p = new Parent();
            while (resultat.next()) {
              p.setIdUser(resultat.getInt(1));
                p.setLogin(resultat.getString(2));
               p.setPassword(resultat.getString(3));
               p.setNom(resultat.getString(4));
               p.setPrenom(resultat.getString(5));
               p.setCin(resultat.getInt(6));
               p.setAddress(resultat.getString(7));
               p.setCodePostale(resultat.getInt(8));
               p.setEmail(resultat.getString(9));
               p.setTelephone(resultat.getInt(10));
               p.setNbrEnfants(resultat.getInt(11));
            }
            return p;
              } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } 
    }
    

    @Override
    public List<Parent> AfficherParent() 
    {
         List<Parent> listParent = new ArrayList<Parent>();

        String requete = "SELECT  `idUser`,`login`, `password`, `nom`, `prenom`,`cin`, `adresse`, `codePostale`, `email`, `telephone`,`nbreEnfant`,'etat' FROM  `user`  ;";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IParent parent = ParentDAO.getInstance();
            while (resultat.next()) {
                Parent p = new Parent();
                 p.setIdUser(resultat.getInt(1));
                 p.setLogin(resultat.getString(2));
                 p.setPassword(resultat.getString(3));
                  p.setNom(resultat.getString(4));
                  p.setPrenom(resultat.getString(5));
                  p.setCin(resultat.getInt(6));
                 p.setAddress(resultat.getString(7));
                  p.setCodePostale(resultat.getInt(8)); 
                 p.setEmail(resultat.getString(9));
                 p.setTelephone(resultat.getInt(10));
                  p.setNbrEnfants(resultat.getInt(11));
                  p.setEtat(resultat.getInt(12));
                 
               
               
              
               
              
                listParent.add(p);
            }
            return listParent;
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
    
     private static ParentDAO iparent;

    public static ParentDAO getInstance() {
        if (iparent == null) {
            iparent = new  ParentDAO();
        }
        return iparent;
    }
    
}
