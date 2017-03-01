/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.gui;

import babysitter.esprit.dao.classes.ParentDAO;
import babysitter.esprit.dao.interfaces.IParent;
import babysitter.esprit.entities.Parent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sassouki
 */
public class ListParent extends JComponent{
    String[] header = {"idUser","login", "password", "nom","prenom","cin","adresse","code postale","email","telephone","nre_enfants","etat"};
    List<Parent> v_parent=new ArrayList<Parent>();
     public ListParent(){
    IParent pdao= ParentDAO.getInstance();
    v_parent=pdao.AfficherParent();
    System.out.println(v_parent);
    
    
}
        public int getRowCount() {
        return v_parent.size();
    }

        public int getColumnCount() {
         return header.length;
    }

        public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (columnIndex) {
            case 0:
                return v_parent.get(rowIndex).getIdUser();
            
            case 1:
                return v_parent.get(rowIndex).getLogin();
            case 2:
                return v_parent.get(rowIndex).getPassword();
            case 3:
                return v_parent.get(rowIndex).getNom();
                case 4:
                return v_parent.get(rowIndex).getPrenom();
                    case 5:
                        return v_parent.get(rowIndex).getCin();
                    case 6:
                return v_parent.get(rowIndex).getAddress();
                        case 7:
                return v_parent.get(rowIndex).getCodePostale();
                            case 8:
                return v_parent.get(rowIndex).getEmail();
                                case 9:
                return v_parent.get(rowIndex).getTelephone();
                                    case 10:
                return v_parent.get(rowIndex).getNbrEnfants();
                                         case 11:
                return v_parent.get(rowIndex).getEtat();
                                        
            default:
                
                return null;
        }

    }

}

    

