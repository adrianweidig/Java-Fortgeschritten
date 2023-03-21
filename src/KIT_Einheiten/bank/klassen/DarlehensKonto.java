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
     * Überprüft, ob die Buchung gem. Richtlinien valide ist.
     * Überschreiben aufgrund angepasster Richtlinien.
     *
     * @param buchung zu verbuchender Betrag, not null
     * @return True oder False als String, not null
     */
    @Override
    public String buchungspruefung(Buchung buchung) {
        String ergebnis = "False";

        if (this.rate == buchung.getBetrag()) {
            ergebnis = "True";
        } else {
            System.out.println("Buchung in Höhe " + buchung.getBetrag() + " für das Konto " + this.getKontonummer() + " ( " + this.getClass().getSimpleName() + " ) konnte nicht durchgeführt werden!\n ----> Buchungsbetrag muss der Rate entsprechen\n");
        }

        return ergebnis;
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
