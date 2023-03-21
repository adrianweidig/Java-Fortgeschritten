package KIT_Einheiten.JDBC.app;

import KIT_Einheiten.JDBC.klassen.DBZugriff;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBApp {
    public static void main(String[] args) {
        DBZugriff zugriff = new DBZugriff();
        Connection verbindung = zugriff.connectionAufbauen();

    }
}

