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
	
    public static List<Item> csvToList(String csvFilePath) throws IOException {
       try (
           Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
       ) {
           CsvToBean<Item> csvToBean = new CsvToBeanBuilder<Item>(reader)
                   .withType(Item.class)
                   .withSeparator(';')
                   .build();

           Iterator<Item> csvItemIterator = csvToBean.iterator();
           List<Item> ItemList = new ArrayList<Item>();

           while (csvItemIterator.hasNext()) {
               Item item = csvItemIterator.next();
               ItemList.add(item);
           }
           
           return ItemList;           
       }
   }
}
