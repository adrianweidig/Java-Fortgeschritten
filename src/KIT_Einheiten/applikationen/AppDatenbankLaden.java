package KIT_Einheiten.applikationen;

import KIT_Einheiten.bank.ausgabe.KonsolenAusgabe;
import KIT_Einheiten.bank.eingabe.DateiEingabe;
import KIT_Einheiten.bank.klassen.*;
import KIT_Einheiten.bank.schnittstellen.IAusgabe;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class AppDatenbankLaden {
    public static void main(String[] args) {
        try {
            // Datumsformatierung
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

            // Ein- und Ausgabeobjekte
            IEingabe eingabe_bankdaten = new DateiEingabe();
            IAusgabe ausgabe_bankdaten = new KonsolenAusgabe();

            // Resultate der Textdatei
            HashMap<Integer, KontoStamm> konten = eingabe_bankdaten.konten();
            ArrayList<Buchung> buchungen = eingabe_bankdaten.buchungen();

            // Datenbankobjekte
            DBZugriff datenbank = new DBZugriff();
            Connection verbindung = datenbank.connectionAufbauen();

            // SQLite spezifisch: Setzt die Autoincrement sequence ALLER Tabellen auf 0
            datenbank.befehl("UPDATE sqlite_sequence SET seq = 0;");

            datenbank.befehl("DELETE FROM Buchung;");
            datenbank.befehl("DELETE FROM Darlehenskonto;");
            datenbank.befehl("DELETE FROM Buchung;");
            datenbank.befehl("DELETE FROM Sparkonto;");
            datenbank.befehl("DELETE FROM Kontostamm");

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

            for (Buchung buchung : buchungen) {
                String sql = "INSERT INTO Buchung(Kontonummer, Betrag, Datum) VALUES('" + buchung.getKontonummer() + "', '" + buchung.getBetrag() + "', '" + formatter.format(buchung.getDatum()) + "');";
                datenbank.befehl(sql);
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
