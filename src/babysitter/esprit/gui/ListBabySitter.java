/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.gui;

import babysitter.esprit.dao.classes.BabySitterDAO;
import babysitter.esprit.dao.interfaces.IBabySitter;
import babysitter.esprit.entities.BabySitter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sassouki
 */
public class ListBabySitter extends AbstractTableModel {
    String[] header = {"idUser","login", "password", "nom", "prenom", "dateNaissance", "cin", "adresse", "codePostale", "email", "telephone","etat"};
    List<BabySitter> v_baby=new ArrayList<BabySitter>();
     public ListBabySitter(){
         IBabySitter bdao= BabySitterDAO.getInstance();
    v_baby=bdao.AfficherBabySitter();
    System.out.println(v_baby);
    
    
}
    @Override
    public int getRowCount() {
        return v_baby.size();
    }

    @Override
    public int getColumnCount() {
         return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (columnIndex) {
            case 0:
                return v_baby.get(rowIndex).getIdUser();
            case 1:
                return v_baby.get(rowIndex).getLogin();
            case 2:
                return v_baby.get(rowIndex).getPassword();
            case 3:
                return v_baby.get(rowIndex).getNom();
                case 4:
                return v_baby.get(rowIndex).getPrenom();
                    case 5:
                return v_baby.get(rowIndex).getDateNaissance();
                    
                    case 6:
                return v_baby.get(rowIndex).getCin();
                    case 7:
                return v_baby.get(rowIndex).getAdresse();
                    case 8:
                return v_baby.get(rowIndex).getCodePostale();
                    case 9:
                return v_baby.get(rowIndex).getEmail();
                    case 10:
                return v_baby.get(rowIndex).getTelephone();
                                    
                    case 11:
                return v_baby.get(rowIndex).getEtat();
            default:
                
                return null;
        }

    }

}

    

    

