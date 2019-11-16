package org.patrick.CSVDisplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CSVReaderTest {
    
    private static List<CSVItem> itemList = new ArrayList<CSVItem>();
    
    @BeforeClass
    public static void loadCSV() throws IOException {        
        itemList = CSVReader.csvToList(".\\src\\test\\resources\\Artikel_Short.csv", ';');        
    }
    
    @Test
    public void testListSize() throws IOException {
        assertEquals(itemList.size(), 10);
    }
    
    @Test
    public void testDismissHeader() throws IOException {
        assertNotEquals(itemList.get(0).getId(), "Hauptartikelnr");
    }

}
