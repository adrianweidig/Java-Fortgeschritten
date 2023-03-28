package KIT_Einheiten.JavaFX.Klassen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BindingController 
{
    @FXML    private TextField txtFeld2;
    @FXML    private TextField txtFeld1;

    private StringProperty inhalt = new SimpleStringProperty("Test");
    @FXML
    void initialize() 
    {
    	txtFeld1.textProperty().bindBidirectional(inhalt);
    	txtFeld2.textProperty().bindBidirectional(inhalt);
    }
}
