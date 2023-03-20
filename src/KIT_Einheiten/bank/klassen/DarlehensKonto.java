package KIT_Einheiten.bank.klassen;

/**
 * Darlehenskonto, welches im Vergleich zum KontoStamm
 * zusätzlich die Rate innehat.
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DarlehensKonto extends KontoStamm {
    /***********************/
    /****** Attribute ******/
    /***********************/
    private double rate;

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    /**
     *
     * @param buchung
     * @return
     */
    @Override
    public String buchungspruefung(Buchung buchung) {
        return null;
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
