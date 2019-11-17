package org.patrick.CSVDisplay;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * 
 * Class to parse .csv files to a List or write a .csv file from a list
 * 
 * @author Patrick Heinrich 
 *
 */
public class CSVHandler {
    
    /**
     * Parses a .csv file into a List of CSVItems
     * 
     * @param csvFilePath the path to the .csv file
     * @param seperator char which separator the values of the .csv file (generally ',' or ';')
     * @return the .csv file parsed into a List of CSVItems
     * @throws IOException if the path or file is wrong
     */
    public static List<CSVItem> csvToList(String csvFilePath, char separator) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        ) {
            CsvToBean<CSVItem> csvToBean = new CsvToBeanBuilder<CSVItem>(reader)
                    .withType(CSVItem.class)
                    .withSeparator(separator)
                    .build();
            
            Iterator<CSVItem> csvItemIterator = csvToBean.iterator();
            List<CSVItem> ItemList = new ArrayList<CSVItem>();
            
            while (csvItemIterator.hasNext()) {
                CSVItem item = csvItemIterator.next();
                ItemList.add(item);
            }
            
            return ItemList;
        }        
    }
    
    /**
     * Parses a .csv file with standard separator ',' into a List of CSVItems 
     * 
     * @param csvFilePath the path to the .csv file
     * @return the .csv file parsed into a List of CSVItems
     * @throws IOException if the path or file is wrong
     */
    public static List<CSVItem> csvToList(String csvFilePath) throws IOException {
        return csvToList(csvFilePath, ',');
    }
    
    
    /**
     * Writes a .csv file from a List of CSVItems
     * 
     * @param csvItemList List of CSVItems to create the file from
     * @param path Path to save the .csv to
     * @throws IOException if the IO operation fail
     * @throws CsvDataTypeMismatchException When the provided value can not be converted to the required type
     * @throws CsvRequiredFieldEmptyException When a field marked as required is empty
     */
    public static void listToCSV(List<CSVItem> csvItemList, String path) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(path));
        ) {
            StatefulBeanToCsv<CSVItem> beanToCsv = new StatefulBeanToCsvBuilder<CSVItem>(writer)
                    .withSeparator(';')
                    .build();
            
            beanToCsv.write(csvItemList);
        }        
    }   
    
}