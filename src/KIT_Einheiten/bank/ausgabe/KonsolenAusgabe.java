package KIT_Einheiten.bank.ausgabe;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;
import KIT_Einheiten.bank.schnittstellen.IAusgabe;

import java.util.HashMap;
import java.util.Map;

/**
 * Ausgabe via Konsole
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class KonsolenAusgabe implements IAusgabe {

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
     * @param konto  , not null
     * @param buchung  , not null
     * @param fehler  , not null
     */
    @Override
    public void fehler(KontoStamm konto, Buchung buchung, String fehler) {

    }

    /**
     * Iteriert über eine HashMap mit erstellten Konten und gibt diese aus.
     *
     * @param konten Die auszugebenden Konten, not null
     */
    @Override
    public void konten(HashMap<Integer, KontoStamm> konten) {
        for (Map.Entry<Integer, KontoStamm> konto : konten.entrySet()) {
            System.out.println(konto.getValue().getInfo());
        }
    }
    /***********************/
    /** Getter und Setter **/
    /***********************/
}

