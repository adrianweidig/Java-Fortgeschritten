package KIT_Einheiten.bank.ausgabe;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;
import KIT_Einheiten.bank.schnittstellen.IAusgabe;

import java.util.HashMap;

/**
 * Ausgabe via JavaFx 8
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class FXAusgabe implements IAusgabe {
    /***********************/
    /****** Attribute ******/
    /***********************/

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    /**
     *
     * @param konto
     * @param buchung
     * @param fehler
     */
    @Override
    public void fehler(KontoStamm konto, Buchung buchung, String fehler) {

    }

    /**
     *
     * @param konten
     */
    @Override
    public void konten(HashMap<Integer, KontoStamm> konten) {

    }
    /***********************/
    /** Getter und Setter **/
    /***********************/
}
