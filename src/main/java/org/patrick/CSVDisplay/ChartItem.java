package org.patrick.CSVDisplay;

import java.util.ArrayList;
import java.util.List;

public class ChartItem {
    
    public static List<ArrayList<Object>> getTypeCount(List<CSVItem> itemList) {
        List<ArrayList<Object>> listedData = new ArrayList<ArrayList<Object>>();
        float itemTotal = itemList.size();
                
        for (CSVItem csvItem : itemList) {
            boolean duplicate = false;
            for (ArrayList<Object> tmpList : listedData) {;
                if (tmpList.get(0).toString().equals(csvItem.getType())) {
                    duplicate = true;
                    tmpList.set(1, (int) tmpList.get(1) + 1);
                }
            }
            if (!duplicate) {
                ArrayList<Object> tmpList = new ArrayList<Object>();
                tmpList.add(csvItem.getType());
                tmpList.add(1);
                listedData.add(tmpList);
            }        
        }        
        
        for (ArrayList<Object> tmpList : listedData) {    
            float itemSpecific = (int) tmpList.get(1);
            float percentage = itemSpecific / itemTotal;
            tmpList.add(percentage);            
        }
        
        return listedData;
    }    
    
}