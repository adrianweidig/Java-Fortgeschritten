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
