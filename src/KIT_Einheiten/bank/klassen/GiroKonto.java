package KIT_Einheiten.bank.klassen;

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
