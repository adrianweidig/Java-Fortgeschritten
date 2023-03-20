
package KIT_Einheiten.bank.klassen;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class KontoStamm {
    /***********************/
    /****** Attribute ******/
    /***********************/
    private ArrayList<Buchung> buchungen;
    private Date datum;
    private String kontoinhaber;
    private int kontonummer;
    private double saldo;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    public String buchungspruefung(Buchung buchung) {
        return null;
    }

    public String getFehler(KontoStamm kontostamm, Buchung buchung, String fehler) {
        return null;
    }

    public String getInfo() {
        return null;
    }

    public void updateSaldo(Buchung buchung) {

    }


    /***********************/
    /** Getter und Setter **/
    /***********************/
    public ArrayList<Buchung> getBuchungen() {
        return buchungen;
    }

    public void setBuchungen(ArrayList<Buchung> buchungen) {
        this.buchungen = buchungen;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
