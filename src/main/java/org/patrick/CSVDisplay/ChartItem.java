package org.patrick.CSVDisplay;

import java.util.ArrayList;
import java.util.List;

public class ChartItem {
    
    private String type = "";
    private int absolute = 0;
    private float percentage = 0f; 
    
    public ChartItem(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public int getAbsolute() {
        return absolute;
    }

    public float getPercentage() {
        return percentage;
    }
    
    private void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    
    private void increaseAbsolute() {
        this.absolute += 1;
    }

    public static List<ChartItem> getTypeCount(List<CSVItem> itemList) {
        List<ChartItem> listedData = new ArrayList<ChartItem>();
        float itemTotal = itemList.size();
                
        for (CSVItem csvItem : itemList) {
            boolean duplicate = false;
            for (ChartItem tmpChartItem : listedData) {;
                if (tmpChartItem.getType().equals(csvItem.getType())) {
                    duplicate = true;
                    tmpChartItem.increaseAbsolute();;
                }
            }
            if (!duplicate) {
                ChartItem tmpChartItem = new ChartItem(csvItem.getType());
                tmpChartItem.increaseAbsolute();                
                listedData.add(tmpChartItem);
            }        
        }        
        
        for (ChartItem tmpChartItem : listedData) {    
            float chartItemAbsolute = tmpChartItem.getAbsolute();
            float percentage = chartItemAbsolute / itemTotal;
            tmpChartItem.setPercentage(percentage);          
        }
        
        return listedData;
    }    
    
}