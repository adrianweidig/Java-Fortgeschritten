package KIT_Einheiten.JDBC.klassen;

import java.sql.*;

/**
 * Klasse für geregelten Zugriff auf Datenbanken.
 * Wichtige Quelle zum
 * <a href="https://www.youtube.com/watch?v=-MDPYDi01dM">Hinzufügen des JDBC Treibers in IntelliJ</a>:
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DBZugriff {

    /***********************/
    /****** Attribute ******/
    /***********************/

    private Connection sql_verbindung = null;
    private Statement sql_query = null;

    private ResultSet sql_ergebnisse = null;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    /**
     * Baut die Verbindung zur Datenbank auf.
     *
     * @return die Datenbankverbindung.
     * @throws ClassNotFoundException , wenn JDBC nicht gefunden werden kann.
     * @throws SQLException , wenn falsche SQL Verbindungssyntax.
     */
    public Connection connectionAufbauen() throws ClassNotFoundException, SQLException {
        String db_name = "DBStart.db";
        String db_path = "E:\\Programmierung\\Java\\Kit_Fortgeschritten_1\\src\\KIT_Einheiten\\JDBC\\resources\\" + db_name;


        Class.forName("org.sqlite.JDBC");
        sql_verbindung = DriverManager.getConnection("jdbc:sqlite:" + db_path);


        return sql_verbindung;
    }

    /**
     * Methode zum lesenden Zugriff auf die Datenbank.
     *
     * @param sql Auszuführender SQL Query, not null
     * @return das Ergebnis des Query, may be null
     */
    public ResultSet lesen(String sql) {
        try {
            // Öffnet die Möglichkeit ein SQL Query auszuführen
            sql_query = sql_verbindung.createStatement();

            // Führt den SQL Query in Form des Strings (in SQL Form) aus
            sql_query.execute(sql);

            // Gibt das Ergebnis des Query zurück
            sql_ergebnisse = sql_query.getResultSet();

            // Verbindet execute() und getResultSet()
            // sql_ergebnisse = sql_query.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sql_ergebnisse;
    }

    /**
     * Methode zum schreibenden Zugriff auf die Datenbank.
     *
     * @param sql Auszuführender SQL Query, not null
     * @return das Ergebnis des Query, may be null
     */
    public int befehl(String sql) {
        Integer ergebnis = null;

        try {
            // Öffnet die Möglichkeit ein SQL Query auszuführen
            sql_query = sql_verbindung.createStatement();

            // Führt den SQL Query in Form des Strings (in SQL Form) aus
            ergebnis = sql_query.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ergebnis;
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/


}
