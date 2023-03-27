package KIT_Einheiten.Serialisierung;

import java.io.Serializable;

/**
 * Simple Datenhaltungsklasse zur persistenten Speicherung
 * in einer Datei.
 */
public class Person implements Serializable {
    /***********************/
    /****** Attribute ******/
    /***********************/

    private String vorname;
    private String nachname;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /**
     * Absolut notwendig für die Nutzung der XML Serialisierung,
     * da die XMLEncoder Klasse einen expliziten Defaultkonstruktor
     * aller zu serialisierenden Objekte verlangt.
     */
    public Person() {
        this("", "");
    }

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    /***********************/
    /** Getter und Setter **/
    /***********************/

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
