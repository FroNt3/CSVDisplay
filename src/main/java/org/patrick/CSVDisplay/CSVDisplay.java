package org.patrick.CSVDisplay;

import java.io.IOException;
import java.util.List;

import javax.swing.SwingUtilities;

/**
 * Contains main method, loads .csv file from path and creates CSVItemTable
 * 
 * @author Patrick Heinrich
 *
 */
public final class CSVDisplay {
    
    /**
     * Loads the .csv file and creates the CSVItemTable
     * 
     * @param args Arguments from the command line are dismissed
     * @throws IOException if the path is invalid
     */
    public static void main(String[] args) throws IOException {
        
        final List<CSVItem> itemList = CSVHandler.csvToList(".\\src\\main\\resources\\Artikel.csv", ';');
        
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new CSVItemTable(itemList);                
            }
            
        });
    }
    
    private CSVDisplay() {        
    }
    
}