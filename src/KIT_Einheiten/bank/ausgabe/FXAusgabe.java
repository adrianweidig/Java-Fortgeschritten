package KIT_Einheiten.bank.ausgabe;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;
import KIT_Einheiten.bank.schnittstellen.IAusgabe;

import java.util.HashMap;

/**
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
    @Override
    public void fehler(KontoStamm konto, Buchung buchung, String fehler) {

    }

    @Override
    public void konten(HashMap<Integer, KontoStamm> konten) {

    }
    /***********************/
    /** Getter und Setter **/
    /***********************/
}
