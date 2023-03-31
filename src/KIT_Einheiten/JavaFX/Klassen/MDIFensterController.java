package KIT_Einheiten.JavaFX.Klassen;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MDIFensterController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btnSchliessen;

    @FXML
    void btnSchliessen_Click(ActionEvent event) {
        ((Stage) btnSchliessen.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {

    }
}
