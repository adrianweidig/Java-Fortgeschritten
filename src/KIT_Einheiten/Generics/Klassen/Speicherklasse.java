package KIT_Einheiten.Generics.Klassen;

/**
 * Datenhaltungsklasse zum Vergleich mit generischer Variante
 *
 * @author Adrian Weidig
 * @since 23.03.2023
 */
public class Speicherklasse {
    /***********************/
    /****** Attribute ******/
    /***********************/

    private int speicher;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /**
     * Erzeugt ein neues Speicherklassenobjekt.
     *
     * @param speicher Speicherwert
     */
    public Speicherklasse(int speicher) {
        this.speicher = speicher;
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    /***********************/
    /** Getter und Setter **/
    /***********************/

    public int getSpeicher() {
        return speicher;
    }

    public void setSpeicher(int speicher) {
        this.speicher = speicher;
    }
}
