package org.patrick.CSVDisplay;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CSVItemTableModel extends AbstractTableModel{
    
    private final List<CSVItem> csvItemList;
    private final String[] columnNames = new String[] {
            "Hauptartikelnr","Artikelname","Hersteller","Beschreibung","Materialangaben",
            "Geschlecht","Produktart","Ärmel","Bein","Kragen","Herstellung","Taschenart",
            "Grammatur","Material","Ursprungsland","Bildname"
    };
    
    public CSVItemTableModel(List<CSVItem> csvItemList) {
        this.csvItemList = csvItemList;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return csvItemList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CSVItem tmpCSVItem = csvItemList.get(rowIndex);
        List<String> tmpCSVItemList = new ArrayList<String>();
        try {
            tmpCSVItemList = tmpCSVItem.toList();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (columnIndex < tmpCSVItemList.size()) {
            return tmpCSVItemList.get(columnIndex);
        } else {
            return null;
        }       
        
    }

}
