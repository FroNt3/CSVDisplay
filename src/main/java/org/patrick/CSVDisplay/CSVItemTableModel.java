package org.patrick.CSVDisplay;

import java.lang.reflect.Field;
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
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public Object getValueAt(int row, int column) {
        CSVItem tmpCSVItem = csvItemList.get(row);
        List<String> tmpCSVItemList = new ArrayList<String>();
        try {
            tmpCSVItemList = tmpCSVItem.toList();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (column < tmpCSVItemList.size()) {
            return tmpCSVItemList.get(column);
        } else {
            return null;
        }        
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        CSVItem tmpCSVItem = csvItemList.get(row);
        int i = 0;
        for (Field field : CSVItem.class.getDeclaredFields()) {
            if (column == i) {
                try {
                    field.setAccessible(true);
                    field.set(tmpCSVItem, (String) value);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
            i++;
        }
        
    }

}
