# CSVDisplay
Code zum Lesen, Anzeigen, Bearbeiten und Schreiben von .csv Dateien.
Eine Programmieraufgabe zum CSV Workflow von United Digital Group.

## Vorab
Die readme Datei ist der Übersicht halber im .md (Markdown) Format geschrieben, Github formatiert die Syntax automatisch.

Leider ist es mir nicht gelungen die Aufgabe vollständig zu lösen. Ich musste mich in dieser Woche unter anderem noch auf Eignungstests und Bewerbungsgespräche vorbereiten, daher blieb nicht ganz so viel Zeit für die Aufgabe wie ich es gerne hätte, ebenso waren einige Themen noch Neuland für mich. Trotzdem hatte ich Spaß an der Aufgabe und habe einiges gelernt. 


## Nicht umgesetzte Funktionen:

- Laden der .csv Datei per Button im GUI, anstatt per Pfad im Code (CSV-Import)
- Implementieren der Methoden von ChartItem um ein graphischen Chart im GUI anzuzeigen 
- Implementieren der listToCSV Methode von CSVHandler an Button im GUI (CSV-Export)
- Responsive UI
- JUnit Tests mit genügender Abdeckung

## Bekannte Bugs

- Die Spalten, der durch die listToCSV Methode erzeugten .csv Datei, sind nach dem Alphabet (bezogen auf den Header) geordnet, anstatt so wie sie eingelesen wurden.
- Aus unbekannten Gründen ist manchmal die Hauptartikelnr. Spalte leer.
> *.\\src\\main\\resources\\Artikel.csv* funktioniert
> *.\\src\\main\\resources\\Artikel_Bug.csv* hat leere 1. Spalte
> Artikel_Bug.csv ist direkt aus der Email
> Artikel.csv ist die Datei aus der Email mit einem Editor geöffnet und wieder abgespeichert.
> Notepad++ sieht keinen Unterschied in beiden Dateien, die aus der Email ist 3 Byte größer

## Benutzte 3rd Party Libraries
### openCSV
openCSV ist eine Library die das Laden, Bearbeiten und Schreiben von .csv Dateien in Java vereinfacht. Mit den Bean Klassen "*CsvToBean* und *BeanToCsv*" lassen sich .csv Zeilen leicht zu Objekten umwandel, sowie Objekte zu .csv Zeilen. Zum Beispiel wird direkt über den Header einer Zeile mittels *@CsvBindByName* erkannt, zu welchem Wert der Inhalt einer Zelle zugewiesen werden muss. Die Builder der Bean Klassen (*CsvToBeanBuilder*, *BeanToCsvBuilder*) ermöglichen einem das lesen und schreiben von .csv Dateien mit individuellen Optionen, wie Seperatoren, custom Quotes, etc. 

### JUnit
JUnit ermöglicht das automatisierte Testen von Klassen und Methoden um sicherzustellen, dass diese sich so verhalten wie erwartet.

## Zeit & Vorgehen


Arbeitsschritt | Zeit (ca.)
------------ | -------------
Informieren über .csv Bearbeitung in Java | 60 Minuten
Einlesen in die openCSV Dokumentation| 45 Minuten
Informieren über GUI Möglichkeiten in Java | 60 Minuten
Informieren über JTable | 30 Minuten
Github Kenntnisse auffrischen | 5 Minuten
Testen der Funktionen von openCSV | 30 Minuten
Testen der Funktionen von JTable | 30 Minuten
Grobe Planung der Implementierung von openCSV | 20 Minuten
Grobe Planung der benötigten Klassen und Funktionen | 30 Minuten
Maven Projekt und Repository erstellen | 5 Minuten
Dependencies einrichten | 5 Minuten
Klasse zum Speichern der Artikel erstellen (CSVItem) | 20 Minuten
Klasse zum Lesen der Artikel erstellen (CSVHandler) |80 Minuten
Klasse zum Berechnen der Verteilung von Produktarten und dessen Speicherung erstellen | 80 Minuten
JUnit Kenntnisse auffrischen | 20 Minuten
Einige JUnit Tests durchführen | 45 Minuten
Einlesen und grobe Planung des GUIs | 60 Minuten
GUI erstellen | 120 Minuten
Schreiben von .csv ermöglichen | 35 Minuten
Testen der Funktionen und Fehlersuche | 45 Minuten
Informieren über Markdown und schreiben der README | 110 Minuten