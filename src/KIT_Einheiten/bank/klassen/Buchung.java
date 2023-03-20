package KIT_Einheiten.bank.klassen;

import java.util.Date;

/**
 * Datenhaltungsklasse für Buchungsinformationen
 *
 * @since 20.03.2023
 * @author Adrian Weidig
 */
public class Buchung {
    /***********************/
    /****** Attribute ******/
    /***********************/
    private double betrag;
    private Date datum;
    private int kontonummer;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    /***********************/
    /** Getter und Setter **/
    /***********************/
    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }
}
