package KIT_Einheiten.bank.schnittstellen;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;

import java.util.HashMap;

/**
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public interface IAusgabe {
    void fehler(KontoStamm konto, Buchung buchung, String fehler);

    void konten(HashMap<Integer, KontoStamm> konten);

}

