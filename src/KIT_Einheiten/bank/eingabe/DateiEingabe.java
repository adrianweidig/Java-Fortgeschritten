package KIT_Einheiten.bank.eingabe;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DateiEingabe implements IEingabe {

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
    public ArrayList<Buchung> buchungen() {
        return null;
    }

    @Override
    public HashMap<Integer, KontoStamm> konten() {
        return null;
    }
    /***********************/
    /** Getter und Setter **/
    /***********************/
}
