package KIT_Einheiten.uebungen.JavaFX_Uebungen.Klassen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * JavaFX Controller Vorlage
 *
 * @author Adrian Weidig
 * @since 28.03.2023
 */
public class Uebung_FX1_Controller {
    /***********************/
    /*** FXML Attribute ****/
    /***********************/
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TextField fx_name_input, fx_vorname_input, fx_strasse_input, fx_plz_input, fx_ort_input;

    @FXML
    private Button fx_btn_adressausgabe;

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

        fx_vorname_input.focusedProperty().addListener(new FocusImpl<>(fx_vorname_input));
        fx_name_input.focusedProperty().addListener(new FocusImpl<>(fx_name_input));
        fx_strasse_input.focusedProperty().addListener(new FocusImpl<>(fx_strasse_input));
        fx_plz_input.focusedProperty().addListener(new FocusImpl<>(fx_plz_input));
        fx_ort_input.focusedProperty().addListener(new FocusImpl<>(fx_ort_input));

        assert fx_name_input != null : "fx:id=\"fx_name_input\" was not injected: check your FXML file 'Uebung_FX1.fxml'.";
        assert fx_vorname_input != null : "fx:id=\"fx_vorname_input\" was not injected: check your FXML file 'Uebung_FX1.fxml'.";
        assert fx_strasse_input != null : "fx:id=\"fx_strasse_input\" was not injected: check your FXML file 'Uebung_FX1.fxml'.";
        assert fx_plz_input != null : "fx:id=\"fx_plz_input\" was not injected: check your FXML file 'Uebung_FX1.fxml'.";
        assert fx_ort_input != null : "fx:id=\"fx_ort_input\" was not injected: check your FXML file 'Uebung_FX1.fxml'.";
        assert fx_btn_adressausgabe != null : "fx:id=\"fx_btn_adressausgabe\" was not injected: check your FXML file 'Uebung_FX1.fxml'.";
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    /***********************/
    /*** Control Methoden **/
    /** (z.B.ButtonClicks) */
    /***********************/
    @FXML
    void fx_on_adressausgabe_click(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(this.getClass().getResource("..\\resources\\light.css").toExternalForm());
        dialogPane.getStyleClass().add("light");

        alert.setTitle("Adressausgabe");
        alert.setHeaderText(fx_vorname_input.getText() + " " + fx_name_input.getText());
        alert.setContentText(fx_strasse_input.getText() + " , " + fx_plz_input.getText() + " " + fx_ort_input.getText());
        alert.showAndWait();

    }

    /***********************/
    /** Getter und Setter **/
    /***********************/


}


