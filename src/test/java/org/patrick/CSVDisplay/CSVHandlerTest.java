package org.patrick.CSVDisplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class to test functionalities of the CSVHandler.class
 * 
 * @author Patrick Heinrich
 *
 */
public class CSVHandlerTest {
    
    private static List<CSVItem> itemList = new ArrayList<CSVItem>();
    
    /**
     * Loads the .csv file into a list
     * 
     * @throws IOException if the path is wrong
     */
    @BeforeClass
    public static void loadCSV() throws IOException {        
        itemList = CSVHandler.csvToList(".\\src\\test\\resources\\Artikel_Short.csv", ';');        
    }
    
    /**
     * Checks if all size of the list is as expected
     */
    @Test
    public void testListSize() {
        assertEquals(10, itemList.size());
    }
    
    /**
     * Makes sure the header was not added to the list
     */
    @Test
    public void testDismissHeader() {
        assertNotEquals("Hauptartikelnr", itemList.get(0).getId());
    }

}