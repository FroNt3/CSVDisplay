package org.patrick.CSVDisplay;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Extends JFrame to create a window with a table containing csv data
 * 
 * @author Patrick Heinrich
 *
 */
public class CSVItemTable extends JFrame {
    
    private static final long serialVersionUID = 1L;

    /**
     * Creates a JFrame table from a List of CSVItems
     * 
     * @param csvItemList List of CSVItems to list in the table
     */
    public CSVItemTable(List<CSVItem> csvItemList) {
        
        CSVItemTableModel model = new CSVItemTableModel(csvItemList);
        JTable table = new JTable(model);
        
        this.add(new JScrollPane(table));
        this.setTitle("CSV Display");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
               
    }

}
