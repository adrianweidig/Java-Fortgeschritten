package KIT_Einheiten.bank.klassen;

import java.util.Date;

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
