package org.patrick.CSVDisplay;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * Creates a table model
 * 
 * @author Patrick Heinrich
 *
 */
public class CSVItemTableModel extends AbstractTableModel {
    
    private static final long serialVersionUID = 1L;
    private final List<CSVItem> csvItemList;
    private final String[] columnNames = new String[] {
            "Hauptartikelnr", "Artikelname", "Hersteller", "Beschreibung", "Materialangaben",
            "Geschlecht", "Produktart", "Ärmel", "Bein", "Kragen", "Herstellung", "Taschenart",
            "Grammatur", "Material", "Ursprungsland", "Bildname"
    };
    
    /**
     * Constructor for the table model
     * 
     * @param csvItemList List of CSVItems to be listed in the table
     */
    public CSVItemTableModel(List<CSVItem> csvItemList) {
        this.csvItemList = csvItemList;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRowCount() {
        return csvItemList.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    /**
     * Makes the cell editable
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getValueAt(int row, int column) {
        CSVItem tmpCSVItem = csvItemList.get(row);
        String value = null;
        int counter = 0;
        for (Field field : CSVItem.class.getDeclaredFields()) {
            if (column == counter) {                
                try {
                    field.setAccessible(true);
                    value = (String) field.get(tmpCSVItem);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            counter++;
        }
        
        return value;        
    }
    
    /**
     * Updates the value of a cell if it's edited
     * 
     * @param value New value for the cell
     * @param row Row of the edited cell
     * @param column Column of the edited cell
     */
    @Override
    public void setValueAt(Object value, int row, int column) {
        CSVItem tmpCSVItem = csvItemList.get(row);
        int counter = 0;
        for (Field field : CSVItem.class.getDeclaredFields()) {
            if (column == counter) {
                try {
                    field.setAccessible(true);
                    field.set(tmpCSVItem, (String) value);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
            counter++;
        }        
    }

}