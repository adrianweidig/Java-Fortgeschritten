package KIT_Einheiten.bank.schnittstellen;

import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public interface IEingabe {
    public ArrayList<Buchung> buchungen();

    public HashMap<Integer, KontoStamm> konten();
}
