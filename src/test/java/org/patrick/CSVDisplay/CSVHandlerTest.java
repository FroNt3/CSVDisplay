package org.patrick.CSVDisplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CSVHandlerTest {
    
    private static List<CSVItem> itemList = new ArrayList<CSVItem>();
    
    @BeforeClass
    public static void loadCSV() throws IOException {        
        itemList = CSVHandler.csvToList(".\\src\\test\\resources\\Artikel_Short.csv", ';');        
    }
    
    @Test
    public void testListSize() throws IOException {
        assertEquals(10, itemList.size());
    }
    
    @Test
    public void testDismissHeader() throws IOException {
        assertNotEquals("Hauptartikelnr", itemList.get(0).getId());
    }

}
