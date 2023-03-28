package KIT_Einheiten.JavaFX.Klassen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Controllerklasse zum Veranschaulichen der FXML Funktionalität.
 *
 * @author Adrian Weidig
 * @since 28.03.2023
 */
public class FXController_1 {
    // Deklaration der Felder die in der Maske verwendet werden
    @FXML
    private Label lblHello;
    @FXML
    private Button btnEnde;

    /**
     * Initialisiert den Controller und den "Beginn" des Lebenszyklus der FXML App.
     */
    @FXML
    public void initialize() {
        lblHello.setText("Ausgabe");
    }

    /**
     * Button Funktionalität zum öffnen eines Alerts.
     *
     * @param e zugehöriges Auslöseevent
     */
    public void btnAusgabe_Click(ActionEvent e) {
        // Ausgabe in einer MessageBox
        // 1. Version MessgaeBox aus Java Swing
        JOptionPane.showMessageDialog(null, lblHello.getText());

        // 2.Version Ausgabe über die Alert Klasse
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Ausgabe der Daten");
//		a.setHeaderText("Der Benutzer hat folgende Ausgabe");
        a.setHeaderText("");
        a.setContentText(lblHello.getText());
        a.showAndWait();
    }

    /**
     * Button Funktionalität zum Beenden des Programmes.
     *
     * @param e zugehöriges Auslöseevent
     */
    public void btnEnde_Click(ActionEvent e) {
        // 1. Version Apllication beenden
//		System.exit(0);

        // 2. Version Beenden des Fensters
        Stage s = (Stage) btnEnde.getScene().getWindow();
        s.close();
    }

}
