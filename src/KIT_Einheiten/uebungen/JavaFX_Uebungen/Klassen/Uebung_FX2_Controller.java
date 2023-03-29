package KIT_Einheiten.uebungen.JavaFX_Uebungen.Klassen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * JavaFX Controller Vorlage
 *
 * @author Adrian Weidig
 * @since
 */
public class Uebung_FX2_Controller {
    /***********************/
    /*** FXML Attribute ****/
    /***********************/
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TextField fx_ktnr_input, fx_blz_input, fx_land_input;

    @FXML
    private Button fx_btn_ibanausgabe;

    @FXML
    private Label fx_lbl_ausgabe;


    /***********************/
    /****** Attribute ******/
    /***********************/

    /***********************/
    /**** Konstruktoren ****/
    /**** und Initialize ***/
    /***********************/

    /**
     * Initialisiert den Controller und den "Beginn" des Lebenszyklus der FXML App.
     */
    @FXML
    void initialize() {
        // Gibt grundsätzlich den genutzten Speicherort aus
        System.out.println("Location: " + this.location);
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    /***********************/
    /*** Control Methoden **/
    /** (z.B.ButtonClicks) */
    /***********************/

    @FXML
    void fx_on_ibanausgabe_click(ActionEvent event) {
        String fx_kontonummer = this.fx_ktnr_input.getText().trim();
        String fx_bankleitzahl = this.fx_blz_input.getText().trim();

        if (fx_kontonummer.length() <= 10 && fx_bankleitzahl.length() == 8) {
            // TODO: laenderkennung als Eingabemöglichkeit
            String laenderkennung = fx_land_input.getText().toUpperCase();
            // Wird nur an einer Stelle benötigt
            String laendercode = laenderkennung.charAt(0) - 55 + String.valueOf(laenderkennung.charAt(1) - 55) + "00";
            String kontonummer = String.format("%010d", Integer.parseInt(fx_kontonummer));
            String bban = fx_bankleitzahl + kontonummer;
            BigInteger pruefsumme = new BigInteger(bban + laendercode).mod(new BigInteger("97"));
            String pruefziffer = String.format("%02d", 98 - pruefsumme.intValueExact());
            String iban = laenderkennung + pruefziffer + bban;

            fx_lbl_ausgabe.setText(iban);
        } else {
            fx_lbl_ausgabe.setText("Die Kontonummer muss zwischen 0 und 10 Zeichen haben.\n Die Bankleitzahl exakt 8 Zeichen.");
        }
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/


}

