package KIT_Einheiten.JDBC.klassen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBZugriff {
    private Connection conn = null;

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
}
