package KIT_Einheiten.applikationen;

import KIT_Einheiten.bank.ausgabe.KonsolenAusgabe;
import KIT_Einheiten.bank.eingabe.DateiEingabe;
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
        IEingabe eingabeTest = new DateiEingabe();
        IAusgabe ausgabeTest = new KonsolenAusgabe();

        HashMap<Integer, KontoStamm> konten = eingabeTest.konten();

        ArrayList<Buchung> buchungen = eingabeTest.buchungen();

        for(Buchung buchung : buchungen) {
            KontoStamm konto = konten.get(buchung.getKontonummer());
            String fehler = konto.buchungspruefung(buchung);

            if(fehler.isEmpty()){
                konto.updateSaldo(buchung);
            } else {
                ausgabeTest.fehler(konto, buchung, fehler);
            }
        }

        ausgabeTest.konten(konten);
    }
}
