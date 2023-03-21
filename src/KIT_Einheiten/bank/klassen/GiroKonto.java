package KIT_Einheiten.bank.klassen;

/**
 * Girokonto, welches im Vergleich zum KontoStamm
 * zusätzlich den Dispobetrag, sowie Sollzins innehat.
 *
 * @author Adrian Weidig
 * @since 20.03.2023
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
     * Überprüft, ob die Buchung gem. Richtlinien valide ist.
     * Überschreiben aufgrund angepasster Richtlinien.
     *
     * @param buchung zu verbuchender Betrag, not null
     * @return Nichts oder den Fehlerstring, not null
     */
    @Override
    public String buchungspruefung(Buchung buchung) {
        String ergebnis = "";

        if (this.getSaldo() + buchung.getBetrag() < this.dispo*-1) {
            ergebnis = " ----> Dispo limit ist überschritten\n";
        }

        return ergebnis;
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
