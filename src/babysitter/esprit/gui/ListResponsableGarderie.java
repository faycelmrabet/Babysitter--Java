/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.gui;

import babysitter.esprit.dao.classes.ResponsableGarderieDAO;
import babysitter.esprit.dao.interfaces.IResponsableGarderie;
import babysitter.esprit.entities.ResponsableGarderie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sassouki
 */
public class ListResponsableGarderie extends AbstractTableModel {
    String[] header = {"idUser","login", "password", "nom", "prenom","cin", "adresse", "codePostale", "email", "telephone","etat"};
    List<ResponsableGarderie> v_resp=new ArrayList<ResponsableGarderie>();
     public ListResponsableGarderie(){
         IResponsableGarderie Redao= ResponsableGarderieDAO.getInstance();
    v_resp=Redao.AfficherResp();
    System.out.println(v_resp);
    
    
}
    @Override
    public int getRowCount() {
        return v_resp.size();
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
                return v_resp.get(rowIndex).getIdUser();
            
            case 1:
                return v_resp.get(rowIndex).getLogin();
            case 2:
                return v_resp.get(rowIndex).getPassword();
            case 3:
                return v_resp.get(rowIndex).getNom();
                case 4:
                return v_resp.get(rowIndex).getPrenom();
                    case 5:
                        return v_resp.get(rowIndex).getCin();
                    case 6:
                return v_resp.get(rowIndex).getAdresse();
                        case 7:
                return v_resp.get(rowIndex).getCodePostale();
                            case 8:
                return v_resp.get(rowIndex).getEmail();
                                case 9:
                return v_resp.get(rowIndex).getTelephone();
                                    
                                         case 10:
                return v_resp.get(rowIndex).getEtat();
                                        
            default:
                
                return null;
        }

    }

}

    

 
    

