package KIT_Einheiten.JavaFX.Klassen;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
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

        lblAusgabe.setText("Ausgabe");
        lblAusgabe.setVisible(true);
        lblAusgabe.setLayoutX(10);


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
        // Ausgbae in einer MessageBox
        // 1. MessageBox aus Java Swing
        JOptionPane.showMessageDialog(null, lblAusgabe.getText());

        // 2. Ausgabe über die Alert Klasse
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ausgabe der Daten");
        alert.setHeaderText("");
        alert.setContentText(lblAusgabe.getText());
        alert.showAndWait();
    }

    @FXML
    void btnEnde_Click(ActionEvent event) {
        // 1. App beenden
        // System.exit(0);

        // 2. Beenden des Fensters
        Stage stage = (Stage) btnEnde.getScene().getWindow();
        stage.close();
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/


}
