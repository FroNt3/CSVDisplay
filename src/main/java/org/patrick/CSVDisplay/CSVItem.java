package org.patrick.CSVDisplay;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

/**
 * Objects hold information about an item
 * 
 * @author Patrick Heinrich
 *
 */
public class CSVItem {
    
    @CsvBindByName(column = "Hauptartikelnr")
    private String id = "";

    @CsvBindByName(column = "Artikelname")
    private String name = "";
    
    @CsvBindByName(column = "Hersteller")
    private String manufacturer = "";
    
    @CsvBindByName(column = "Beschreibung")
    private String description = "";
    
    @CsvBindByName(column = "Materialangaben")
    private String materials = "";
    
    @CsvBindByName(column = "Geschlecht")
    private String gender = "";
    
    @CsvBindByName(column = "Produktart")
    private String type = "";
    
    @CsvBindByName(column = "Ärmel")
    private String sleeve = "";
    
    @CsvBindByName(column = "Bein")
    private String leg = "";
    
    @CsvBindByName(column = "Kragen")
    private String collar = "";
    
    @CsvBindByName(column = "Herstellung")
    private String manufacturing = "";
    
    @CsvBindByName(column = "Taschenart")
    private String pocketType = "";
    
    @CsvBindByName(column = "Grammatur")
    private String grammage = "";
    
    @CsvBindByName(column = "Material")
    private String material = "";
    
    @CsvBindByName(column = "Ursprungsland")
    private String originCountry = "";
    
    @CsvBindByName(column = "Bildname")
    private String imageFileName = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public String getCollar() {
        return collar;
    }

    public void setCollar(String collar) {
        this.collar = collar;
    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }

    public String getPocketType() {        
        return pocketType;
    }

    public void setPocketType(String pocketType) {
        this.pocketType = pocketType;
    }

    public String getGrammage() {
        return grammage;
    }

    public void setGrammage(String grammage) {
        this.grammage = grammage;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }   
    
    public List<String> toList() throws IllegalArgumentException, IllegalAccessException {
        List<String> tmpList = new ArrayList<String>();
        
        for (Field field : CSVItem.class.getDeclaredFields()) {
            tmpList.add((String) field.get(this));
        }  
        
        return tmpList;
    }
    
}