package KIT_Einheiten.JDBC.klassen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klasse für geregelten Zugriff auf Datenbanken.
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DBZugriff {

    /***********************/
    /****** Attribute ******/
    /***********************/

    private Connection conn = null;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    public Connection connectionAufbauen() {
        String db_name = "DBStart.db";
        String db_path = "E:\\Programmierung\\Java\\Kit_Fortgeschritten_1\\src\\KIT_Einheiten\\JDBC\\resources\\" + db_name;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
        } catch (ClassNotFoundException | SQLException ce) {
            System.err.println(ce.getClass().getName() + ": " + ce.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return conn;
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/


}
