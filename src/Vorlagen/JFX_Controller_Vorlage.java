package Vorlagen;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * JavaFX Controller Vorlage
 *
 * @author Adrian Weidig
 * @since
 */
public class JFX_Controller_Vorlage {
    /***********************/
    /*** FXML Attribute ****/
    /***********************/
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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

    /***********************/
    /** Getter und Setter **/
    /***********************/
}
