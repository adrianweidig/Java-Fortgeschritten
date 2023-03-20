package KIT_Einheiten.bank.klassen;

/**
 * Girokonto, welches im Vergleich zum KontoStamm
 * zusätzlich den Dispobetrag, sowie Sollzins innehat.
 *
 * @since 20.03.2023
 * @author Adrian Weidig
 */
public class GiroKonto extends KontoStamm {
    /***********************/
    /****** Attribute ******/
    /***********************/
    private double dispo;
    private double sollzins;

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
    public double getDispo() {
        return dispo;
    }

    public void setDispo(double dispo) {
        this.dispo = dispo;
    }

    public double getSollzins() {
        return sollzins;
    }

    public void setSollzins(double sollzins) {
        this.sollzins = sollzins;
    }
}
