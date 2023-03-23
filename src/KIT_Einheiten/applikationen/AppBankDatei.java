package KIT_Einheiten.applikationen;

import KIT_Einheiten.bank.ausgabe.KonsolenAusgabe;
import KIT_Einheiten.bank.eingabe.DatenbankEingabe;
import KIT_Einheiten.bank.klassen.Buchung;
import KIT_Einheiten.bank.klassen.KontoStamm;
import KIT_Einheiten.bank.schnittstellen.IAusgabe;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Testdatei / Maindatei für das Bankprojekt
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class AppBankDatei {
    public static void main(String[] args) {
        // Je nach Bedarf ob via Datenbank oder direkt über die Datei jeweilige IEingabe auskommentieren
        // IEingabe eingabeTest = new DateiEingabe();
        IEingabe eingabe_datenbank = new DatenbankEingabe();

        IAusgabe ausgabeTest = new KonsolenAusgabe();


        //HashMap<Integer, KontoStamm> konten = eingabeTest.konten();
        HashMap<Integer, KontoStamm> konten = eingabe_datenbank.konten();

        //ArrayList<Buchung> buchungen = eingabeTest.buchungen();
        ArrayList<Buchung> buchungen = eingabe_datenbank.buchungen();

        for (Buchung buchung : buchungen) {
            KontoStamm konto = konten.get(buchung.getKontonummer());
            String fehler = konto.buchungspruefung(buchung);

            if (fehler.isEmpty()) {
                konto.updateSaldo(buchung);
            } else {
                ausgabeTest.fehler(konto, buchung, fehler);
            }
        }

        ausgabeTest.konten(konten);
    }
}
