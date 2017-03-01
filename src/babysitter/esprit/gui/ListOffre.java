/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babysitter.esprit.gui;

import babysitter.esprit.dao.classes.OffreMissionDAO;
import babysitter.esprit.dao.interfaces.IoffreMissionDAO;
import babysitter.esprit.entities.OffreMission;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sassouki
 */
public class ListOffre extends AbstractTableModel{

    String [] header={"adresse", "date","description", "horaire"};
    List<OffreMission> OM=new ArrayList<OffreMission>();
    
    public ListOffre() {
        IoffreMissionDAO OMdao=OffreMissionDAO.getInstance();
        OM=OMdao.AfficherOffreMission();
        System.out.println(OM);
    
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    
    
    @Override
    public int getRowCount() {
        return OM.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0: 
                return OM.get(rowIndex).getAdresse();
            case 1: 
                return OM.get(rowIndex).getDate();
            case 2: 
                return OM.get(rowIndex).getDescription();
            case 3: 
                return OM.get(rowIndex).getHoraire();
            default:
                return null;
        }
    }
    
}

