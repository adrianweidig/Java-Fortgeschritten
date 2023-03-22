package Eigene_Lerneinheiten.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankDB {
    private Connection verbindung = null;

    public BankDB(String dbname, String pfad) {
        pfad += dbname;

        try {
            Class.forName("org.sqlite.JDBC");
            verbindung = DriverManager.getConnection("jdbc:sqlite:" + pfad);
        } catch (ClassNotFoundException | SQLException ce) {
            System.err.println(ce.getClass().getName() + ": " + ce.getMessage());
            System.exit(0);
        }
        System.out.println("Datenbank erfolgreich geöffnet");
    }

    public void neueBuchung() {

    }

}
