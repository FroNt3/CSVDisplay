package org.patrick.CSVDisplay;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChartItemTest {
    
    private static List<CSVItem> itemList = new ArrayList<CSVItem>();
    private static List<ChartItem> itemTypeList;
    
    @BeforeClass
    public static void loadCSV() throws IOException {        
        itemList = CSVReader.csvToList(".\\src\\test\\resources\\Artikel_Short.csv", ';');
        itemTypeList = ChartItem.getTypeCount(itemList);
    }
    
    @Test
    public void testListSize() throws IOException {
        assertEquals(6, itemTypeList.size());
    }
    
    @Test
    public void testTaschenCount() throws IOException {
        for (ChartItem tmpCharItem : itemTypeList) {
            if (tmpCharItem.getType().equals("Taschen")) {
                assertEquals(2, tmpCharItem.getAbsolute());
                assertEquals(0.2f, tmpCharItem.getPercentage(), 0.01f);
            }
        }       
    }

}
