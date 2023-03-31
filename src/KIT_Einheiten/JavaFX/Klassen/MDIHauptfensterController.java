package KIT_Einheiten.JavaFX.Klassen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MDIHauptfensterController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private MenuItem mnuNichtModal;
    @FXML
    private MenuItem mnuModal;

    private Stage hauptfenster;


    public void setHauptfenster(Stage hauptfenster) {
        this.hauptfenster = hauptfenster;
    }

    @FXML
    void initialize() {
    }

    @FXML
    void mnuModal_Click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\MDIModal.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Modales Fenster");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root));
        stage.initOwner(hauptfenster);
        stage.show();
    }

    @FXML
    void mnuNichtModal_Click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\MDINichtModal.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Nicht Modales Fenster");
        stage.setScene(new Scene(root));
        stage.initOwner(hauptfenster);
        stage.show();

    }

}

