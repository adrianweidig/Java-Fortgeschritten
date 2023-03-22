package Eigene_Lerneinheiten.SQL;

public class SQLMain {
    public static void main(String[] args) {
        String db_name = "Bank.db";
        String db_pfad = "E:\\Programmierung\\Java\\Kit_Fortgeschritten_1\\src\\Eigene_Lerneinheiten\\SQL\\";

        BankDB datenbank = new BankDB(db_name, db_pfad);
    }
}
