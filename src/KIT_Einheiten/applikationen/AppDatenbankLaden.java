package KIT_Einheiten.applikationen;

import KIT_Einheiten.bank.ausgabe.KonsolenAusgabe;
import KIT_Einheiten.bank.eingabe.DateiEingabe;
import KIT_Einheiten.bank.eingabe.DatenbankEingabe;
import KIT_Einheiten.bank.klassen.*;
import KIT_Einheiten.bank.schnittstellen.IAusgabe;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Testdatei / Maindatei für die Datenbank im Bankprojekt.
 *
 * @author Adrian Weidig
 * @since 22.03.2023
 */
public class AppDatenbankLaden {
    public static void main(String[] args) {
        datenbankInitialisieren();
        /****************************************************/
        ausgabe();
    }

    public static void datenbankInitialisieren() {
        try {
            // Datumsformatierung
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

            // Ein- und Ausgabeobjekte
            IEingabe eingabe_bankdaten = new DateiEingabe();

            // Resultate der Textdatei
            HashMap<Integer, KontoStamm> konten = eingabe_bankdaten.konten();
            ArrayList<Buchung> buchungen = eingabe_bankdaten.buchungen();

            // Datenbankobjekte
            DBZugriff datenbank = new DBZugriff();
            Connection verbindung = datenbank.connectionAufbauen();

            // SQLite spezifisch: Setzt die Autoincrement sequence ALLER Tabellen auf 0
            datenbank.befehl("UPDATE sqlite_sequence SET seq = 0;");

            // Leeren der Tabellen bei wiederholtem Aufruf des Programmes
            datenbank.befehl("DELETE FROM Buchung;");
            datenbank.befehl("DELETE FROM Darlehenskonto;");
            datenbank.befehl("DELETE FROM Girokonto;");
            datenbank.befehl("DELETE FROM Sparkonto;");
            datenbank.befehl("DELETE FROM Kontostamm");

            // Befüllen der Konten-Tabellen
            for (KontoStamm konto : konten.values()) {
                String kontoart = konto.getClass().getSimpleName();

                // INSERT INTO KontoStamm VALUES(kontonummer, 'kontoinhaber', 'anlagedatum', saldo, 'kontoart');
                String sql = "INSERT INTO KontoStamm VALUES('" + konto.getKontonummer() + "', '" + konto.getKontoinhaber() + "', '" + formatter.format(konto.getDatum()) + "', '" + konto.getSaldo() + "', '" + kontoart + "');";
                datenbank.befehl(sql);

                switch (kontoart) {
                    case "DarlehensKonto":
                        // INSERT INTO Darlehenskonto VALUES(lfdnr, kontonummer, rate);
                        DarlehensKonto darlehensKonto = (DarlehensKonto) konto;
                        sql = "INSERT INTO Darlehenskonto(Kontonummer, Rate) VALUES('" + darlehensKonto.getKontonummer() + "', '" + darlehensKonto.getRate() + "');";
                        break;
                    case "GiroKonto":
                        // INSERT INTO Girokonto VALUES(lfdnr, kontonummer, dispo, sollzins);
                        GiroKonto giroKonto = (GiroKonto) konto;
                        sql = "INSERT INTO Girokonto(Kontonummer, Dispo, Sollzins) VALUES('" + giroKonto.getKontonummer() + "', '" + giroKonto.getDispo() + "', '" + giroKonto.getSollzins() + "');";
                        break;
                    case "SparKonto":
                        // INSERT INTO Darlehenskonto VALUES(lfdnr, kontonummer, habenzins, kuendbetrag, kuenddatum);
                        SparKonto sparKonto = (SparKonto) konto;
                        sql = "INSERT INTO Sparkonto(Kontonummer, Habenzins, Kuendbetrag, Kuenddatum) VALUES('" + sparKonto.getKontonummer() + "', '" + sparKonto.getHabenzins() + "', '" + sparKonto.getKuendbetrag() + "', '" + formatter.format(sparKonto.getKuenddatum()) + "');";
                        break;
                    default:
                        sql = "";
                }

                datenbank.befehl(sql);
            }

            // Befüllen der Buchungstabelle
            for (Buchung buchung : buchungen) {
                //String sql = "INSERT INTO Buchung(Kontonummer, Betrag, Datum) VALUES('" + buchung.getKontonummer() + "', '" + buchung.getBetrag() + "', '" + formatter.format(buchung.getDatum()) + "');";
                //datenbank.befehl(sql);

                // Möglichkeit ohne riesigen Insert String
                String sql = "INSERT INTO Buchung(Kontonummer, Betrag, Datum) VALUES(?,?,?)";
                PreparedStatement statement = verbindung.prepareStatement(sql);
                statement.setInt(1, buchung.getKontonummer());
                statement.setDouble(2, buchung.getBetrag());
                statement.setString(3, formatter.format(buchung.getDatum()));

                statement.execute();
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ausgabe() {
        DatenbankEingabe db_eingabe = new DatenbankEingabe();
        IAusgabe ausgabe = new KonsolenAusgabe();

        HashMap<Integer, KontoStamm> verarbeitete_konten = db_eingabe.konten();


        ArrayList<Buchung> buchungen = db_eingabe.buchungen();

        for (Buchung buchung : buchungen) {
            KontoStamm konto = verarbeitete_konten.get(buchung.getKontonummer());
            String fehler = konto.buchungspruefung(buchung);

            if (fehler.isEmpty()) {
                konto.updateSaldo(buchung);
                db_eingabe.saldoVerbuchen(buchung);
            } else {
                ausgabe.fehler(konto, buchung, fehler);
            }
        }
        ausgabe.konten(verarbeitete_konten);
    }

}
