package KIT_Einheiten.JavaFX.Klassen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
 */
public class BindingController {
    @FXML
    private TextField txtFeld2;
    @FXML
    private TextField txtFeld1;

    private StringProperty inhalt = new SimpleStringProperty("Test");

    @FXML
    void initialize() {
        txtFeld1.textProperty().bindBidirectional(inhalt);
        txtFeld2.textProperty().bindBidirectional(inhalt);

        txtFeld1.focusedProperty().addListener(new FocusImpl<Boolean>(txtFeld1));
        txtFeld2.focusedProperty().addListener(new FocusImpl<Boolean>(txtFeld2));

        /*
        txtFeld2.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                if(newValue)
                    txtFeld2.setStyle("-fx-background-color: yellow");
                else
                    txtFeld2.setStyle("-fx-background-color: white");

            }
        });
        */
    }

    class FocusImpl<T> implements ChangeListener<T> {
        private TextField txt;

        public FocusImpl(TextField txt) {
            this.txt = txt;
        }

        @Override
        public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
            if ((Boolean) newValue)
                txt.setStyle("-fx-background-color: yellow");
            else
                txt.setStyle("-fx-background-color: white");
        }
    }
}
