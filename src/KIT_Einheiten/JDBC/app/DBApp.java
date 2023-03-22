package KIT_Einheiten.JDBC.app;

import KIT_Einheiten.JDBC.klassen.DBZugriff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Testdatei / Maindatei für die ersten Datenbankzugriffe.
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DBApp {
    public static void main(String[] args) {
        DBZugriff datenbank = new DBZugriff();
        Connection verbindung = datenbank.connectionAufbauen();
        String sql = "";

        String[][] daten = {{"Armenti", "Ingolstadt"},
                {"Huber", "Dresden"},
                {"Mayer", "München"}};

        datenbank.befehl("DELETE FROM telefon");
        datenbank.befehl("DELETE FROM adressen");


        int zaehler = 1;

        for (String[] zeile : daten) {
            // INSERT INTO adressen VALUES (1, 'Huber', 'Goethestr. 12');
            sql = "INSERT INTO adressen VALUES(" + zaehler + ", '" + zeile[0] + "', '" + zeile[1] + "')";

            System.out.println(sql);

            int anzahl_betroffener_zeilen = datenbank.befehl(sql);

            System.out.println("Betroffene Zeilen: " + anzahl_betroffener_zeilen + "\n");

            zaehler++;
        }

        ResultSet ergebnis = datenbank.lesen("SELECT * FROM adressen");

        try {
            System.out.println("---------------------");
            System.out.println("ID\tName\tStraße");
            System.out.println("---------------------");

            while (ergebnis.next()) {
                int id = ergebnis.getInt("pk_id");
                String name = ergebnis.getString("name");
                String strasse = ergebnis.getString("strasse");

                System.out.println(id+"\t"+name+"\t"+strasse);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

