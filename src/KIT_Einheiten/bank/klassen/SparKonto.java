package KIT_Einheiten.bank.klassen;

import java.util.Date;

/**
 * Sparkonto, welches im Vergleich zum KontoStamm
 * zusätzlich den Habenzins, Kündbetrag und das
 * Kündigungsdatum innehat.
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class SparKonto extends KontoStamm {
    /***********************/
    /****** Attribute ******/
    /***********************/
    private double habenzins;
    private double kuendbetrag;
    private Date kuenddatum;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    /**
     *
     * @param buchung  , not null
     * @return  , not null
     */
    @Override
    public String buchungspruefung(Buchung buchung) {
        return null;
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/
    public double getHabenzins() {
        return habenzins;
    }

    public void setHabenzins(double habenzins) {
        this.habenzins = habenzins;
    }

    public double getKuendbetrag() {
        return kuendbetrag;
    }

    public void setKuendbetrag(double kuendbetrag) {
        this.kuendbetrag = kuendbetrag;
    }

    public Date getKuenddatum() {
        return kuenddatum;
    }

    public void setKuenddatum(Date kuenddatum) {
        this.kuenddatum = kuenddatum;
    }
}
