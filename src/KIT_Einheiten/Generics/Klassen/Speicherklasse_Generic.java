package KIT_Einheiten.Generics.Klassen;

/**
 * Datenhaltungsklasse in generischer Form
 *
 * @author Adrian Weidig
 * @since 23.03.2023
 */
public class Speicherklasse_Generic<T> {
    /***********************/
    /****** Attribute ******/
    /***********************/

    private T speicher;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /**
     * Erzeugt ein neues generisches Speicherobjekt.
     *
     * @param speicher Speichertyp
     */
    public Speicherklasse_Generic(T speicher) {
        this.speicher = speicher;
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    // Diverse Methoden sind möglich
    // dabei ist zu beachten, dass entweder der
    // festgelegte Typ genutzt wird aber auch
    // so verarbeitet wird. Dies kann zur Laufzeit
    // bereits festgestellt werden, ob dies überhaupt
    // möglich ist, da ein spezieller Typ verlangt wird.

    // Methoden, welche rein generisch sind dürfen
    // dann aber auch nur die Möglichkeiten nutzen,
    // welche für alle Klassen allgemeingültig sind
    // ggf. super oder extends nutzen, um entsprechende
    // Funktionalitäten festzulegen.

    /***********************/
    /** Getter und Setter **/
    /***********************/

    public T getSpeicher() {
        return speicher;
    }

    public void setSpeicher(T speicher) {
        this.speicher = speicher;
    }
}
