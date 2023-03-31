package KIT_Einheiten.bank.eingabe;

import KIT_Einheiten.bank.klassen.*;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * Einlesen von Informationen über eine Datenbank
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DatenbankEingabe implements IEingabe {

    /***********************/
    /****** Attribute ******/
    /***********************/
    // Datenbankobjekte
    DBZugriff datenbank = new DBZugriff();
    Connection verbindung = null;

    // Datumsverarbeitung
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    private Date aktuellesDatum = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

    /***********************/
    /**** Konstruktor ******/
    /***********************/
    public DatenbankEingabe() {
        try {
            verbindung = datenbank.connectionAufbauen();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    /**
     * @return , not null
     */
    @Override
    public ArrayList<Buchung> buchungen() {
        ArrayList<Buchung> buchungen = new ArrayList<>();


        try {
            String sql = "SELECT * FROM Buchung";
            ResultSet ergebnisse = datenbank.lesen(sql);

            while (ergebnisse.next()) {
                Buchung buchung = new Buchung();

                double betrag = ergebnisse.getDouble("Betrag");
                int kontonummer = ergebnisse.getInt("Kontonummer");
                Date datum = formatter.parse(ergebnisse.getString("Datum"));

                buchung.setBetrag(betrag);
                buchung.setKontonummer(kontonummer);
                buchung.setDatum(datum);

                buchungen.add(buchung);

            }


        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }

        return buchungen;
    }


    public void initialisiere_standards(KontoStamm konto) {
        try {
            String sql = "SELECT * FROM KontoStamm WHERE Kontonummer=" + konto.getKontonummer();
            ResultSet ergebnisse = datenbank.lesen(sql);

            while (ergebnisse.next()) {
                String kontoinhaber = ergebnisse.getString("Kontoinhaber");
                Date eroeffnungsDatum = formatter.parse(ergebnisse.getString("AnlageDatum"));
                double saldo = ergebnisse.getDouble("Saldo");

                konto.setKontoinhaber(kontoinhaber);
                konto.setDatum(eroeffnungsDatum);
                konto.setSaldo(saldo);

            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @return , not null
     */
    @Override
    public HashMap<Integer, KontoStamm> konten() {
        HashMap<Integer, KontoStamm> konten = new HashMap<>();

        try {
            String sql = "SELECT * FROM Girokonto";
            ResultSet ergebnisse = datenbank.lesen(sql);

            while (ergebnisse.next()) {
                int kontonummer = ergebnisse.getInt("Kontonummer");
                double dispo = ergebnisse.getDouble("Dispo");
                double sollzins = ergebnisse.getDouble("Sollzins");

                GiroKonto giroKonto = new GiroKonto();

                // Kontospezifische Bearbeitung
                giroKonto.setKontonummer(kontonummer);
                giroKonto.setDispo(dispo);
                giroKonto.setSollzins(sollzins);

                initialisiere_standards(giroKonto);

                konten.put(kontonummer, giroKonto);
            }

            sql = "SELECT * FROM Sparkonto";
            ergebnisse = datenbank.lesen(sql);

            while (ergebnisse.next()) {
                int kontonummer = ergebnisse.getInt("Kontonummer");
                double habenzins = ergebnisse.getDouble("Habenzins");
                double kuendbetrag = ergebnisse.getDouble("kuendbetrag");
                Date kuenddatum = formatter.parse(ergebnisse.getString("Kuenddatum"));

                SparKonto sparKonto = new SparKonto();

                // Kontospezifische Bearbeitung
                sparKonto.setKontonummer(kontonummer);
                sparKonto.setHabenzins(habenzins);
                sparKonto.setKuendbetrag(kuendbetrag);
                sparKonto.setKuenddatum(kuenddatum);

                initialisiere_standards(sparKonto);

                konten.put(kontonummer, sparKonto);
            }

            sql = "SELECT * FROM Darlehenskonto";
            ergebnisse = datenbank.lesen(sql);

            while (ergebnisse.next()) {
                int kontonummer = ergebnisse.getInt("Kontonummer");
                double rate = ergebnisse.getDouble("Rate");

                DarlehensKonto darlehensKonto = new DarlehensKonto();

                // Kontospezifische Bearbeitung
                darlehensKonto.setKontonummer(kontonummer);
                darlehensKonto.setRate(rate);

                initialisiere_standards(darlehensKonto);

                konten.put(kontonummer, darlehensKonto);
            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }

        return konten;
    }

    public ArrayList<String> getTables() {
        ArrayList<String> tabellen = new ArrayList<>();
        String sql = "SELECT\n name\n FROM\n sqlite_master\n WHERE\n type ='table' AND\n name NOT LIKE 'sqlite_%'\n AND name NOT LIKE 'KontoStamm';";

        ResultSet result = datenbank.lesen(sql);
        try {
            while (result.next()) {
                tabellen.add(result.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tabellen;
    }

    public void saldoVerbuchen(Buchung buchung) {
        String sql = "UPDATE KontoStamm SET Saldo=Saldo+" + buchung.getBetrag() + " WHERE Kontonummer=" + buchung.getKontonummer();
        datenbank.befehl(sql);
    }

    public void addAccount() {

    }
    /***********************/
    /** Getter und Setter **/
    /***********************/
}

