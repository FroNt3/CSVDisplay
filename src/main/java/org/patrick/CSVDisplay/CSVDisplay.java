package org.patrick.CSVDisplay;

import java.io.IOException;
import java.util.List;

import javax.swing.SwingUtilities;

public class CSVDisplay {
    public static void main( String[] args ) throws IOException {
        final List<CSVItem> itemList = CSVReader.csvToList(".\\src\\main\\resources\\Artikel_Short.csv", ';');
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CSVItemTable(itemList);
            }
        });
    }
}
