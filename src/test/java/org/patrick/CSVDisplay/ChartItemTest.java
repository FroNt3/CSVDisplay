package org.patrick.CSVDisplay;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class to test functionalities of ChatItem.class
 * 
 * @author Patrick Heinrich
 *
 */
public class ChartItemTest {
    
    private static List<CSVItem> itemList = new ArrayList<CSVItem>();
    private static List<ChartItem> itemTypeList;
    
    /**
     * Loads the .csv into a List
     * 
     * @throws IOException if the path is invalid
     */
    @BeforeClass
    public static void loadCSV() throws IOException {        
        itemList = CSVHandler.csvToList(".\\src\\test\\resources\\Artikel_Short.csv", ';');
        itemTypeList = ChartItem.getTypeCount(itemList);
    }

    /**
     *  Checks if the correct amount of unique types were added
     */
    @Test
    public void testListSize() {
        assertEquals(6, itemTypeList.size());
    }
    
    /**
     *  Checks if the percentage and absolute count of a type is correct
     */
    @Test
    public void testTaschenCount() {
        for (ChartItem tmpCharItem : itemTypeList) {
            if (tmpCharItem.getType().equals("Taschen")) {
                assertEquals(2, tmpCharItem.getAbsolute());
                assertEquals(0.2f, tmpCharItem.getPercentage(), 0.01f);
            }
        }       
    }

}