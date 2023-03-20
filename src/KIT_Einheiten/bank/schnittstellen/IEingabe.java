package KIT_Einheiten.bank.schnittstellen;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface für die verschiedenen Möglichkeiten der Eingabe
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public interface IEingabe {
    /**
     *
     * @return  , not null
     */
    ArrayList<Buchung> buchungen();

    /**
     * Definiert die grundsätzliche Eingabemöglichkeit diverser Konten
     * und der Möglichkeit diese Konten zu verarbeiten.
     *
     * @return HashMap aller Konten, not null
     */
    HashMap<Integer, KontoStamm> konten();
}
