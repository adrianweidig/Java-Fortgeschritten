package KIT_Einheiten.JDBC.app;

import KIT_Einheiten.JDBC.klassen.DBZugriff;

import java.sql.Connection;

/**
 * Testdatei / Maindatei für die ersten Datenbankzugriffe.
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DBApp {
    public static void main(String[] args) {
        DBZugriff zugriff = new DBZugriff();
        Connection verbindung = zugriff.connectionAufbauen();

    }
}

