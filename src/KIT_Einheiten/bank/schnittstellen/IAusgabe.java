package KIT_Einheiten.bank.schnittstellen;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;

import java.util.HashMap;

/**
 * Interface für die verschiedenen Möglichkeiten der Ausgabe.
 * Die exakte Beschreibung, sowie Implementierungen sind in
 * den jeweiligen Klassen zu sehen.
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public interface IAusgabe {

    /**
     *
     * @param konto
     * @param buchung
     * @param fehler
     */
    void fehler(KontoStamm konto, Buchung buchung, String fehler);

    /**
     * Definiert eine grundsätzliche Ausgabe aller Konten.
     *
     * @param konten HashMap aller Konten
     */
    void konten(HashMap<Integer, KontoStamm> konten);

}

