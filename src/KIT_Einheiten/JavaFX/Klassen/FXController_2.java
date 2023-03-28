package KIT_Einheiten.JavaFX.Klassen;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controllerklasse 2
 *
 * @author Adrian Weidig
 * @since 28.03.2023
 */
public class FXController_2 {
    /***********************/
    /*** FXML Attribute ****/
    /***********************/
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblHallo"
    private Label lblHallo; // Value injected by FXMLLoader

    @FXML // fx:id="lblAusgabe"
    private Label lblAusgabe; // Value injected by FXMLLoader

    @FXML // fx:id="btnAusgabe"
    private Button btnAusgabe; // Value injected by FXMLLoader

    @FXML // fx:id="btnEnde"
    private Button btnEnde; // Value injected by FXMLLoader

    /***********************/
    /****** Attribute ******/
    /***********************/

    /***********************/
    /**** Konstruktoren ****/
    /**** und Initialize ***/
    /***********************/

    @FXML
    /**
     * Initialisiert den Controller und den "Beginn" des Lebenszyklus der FXML App.
     */
    void initialize() {
        System.out.println("Location: " + this.location);
        assert lblHallo != null : "fx:id=\"lblHallo\" was not injected: check your FXML file 'FXController_2.fxml'.";
        assert lblAusgabe != null : "fx:id=\"lblAusgabe\" was not injected: check your FXML file 'FXController_2.fxml'.";
        assert btnAusgabe != null : "fx:id=\"btnAusgabe\" was not injected: check your FXML file 'FXController_2.fxml'.";
        assert btnEnde != null : "fx:id=\"btnEnde\" was not injected: check your FXML file 'FXController_2.fxml'.";

    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    /***********************/
    /*** Control Methoden **/
    /** (z.B.ButtonClicks) */
    /***********************/

    @FXML
    void btnAusgabe_Click(ActionEvent event) {

    }

    @FXML
    void btnEnde_Click(ActionEvent event) {

    }

    /***********************/
    /** Getter und Setter **/
    /***********************/


}
