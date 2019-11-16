package org.patrick.CSVDisplay;

import com.opencsv.bean.CsvBindByName;

public class Item {
	
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


	
	
}
