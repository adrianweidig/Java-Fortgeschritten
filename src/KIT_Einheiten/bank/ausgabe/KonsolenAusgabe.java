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
     * Zeigt die Fehlerausgabe an, falls eine Buchung nicht den Richtlinien entspricht.
     *
     * @param konto   das zugehörige Konto, not null
     * @param buchung die zugehörige Buchung, not null
     * @param fehler  der Fehlerstring, not null
     */
    @Override
    public void fehler(KontoStamm konto, Buchung buchung, String fehler) {
        System.out.println("Buchung in Höhe " + buchung.getBetrag() + " für das Konto " + konto.getKontonummer() + " ( " + konto.getClass().getSimpleName() + " ) konnte nicht durchgeführt werden!\n" + fehler);
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

        // Alternative lediglich Zugriff auf die Werte:
        // for (KontoStamm konto : konten.values()) {
        //     System.out.println(konto.getInfo());
        // }
    }
    /***********************/
    /** Getter und Setter **/
    /***********************/
}

