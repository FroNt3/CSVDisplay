package org.patrick.CSVDisplay;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReader {
	
    public static List<CSVItem> csvToList(String csvFilePath) throws IOException {
       try (
           Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
       ) {
           CsvToBean<CSVItem> csvToBean = new CsvToBeanBuilder<CSVItem>(reader)
                   .withType(CSVItem.class)
                   .withSeparator(';')
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
}
