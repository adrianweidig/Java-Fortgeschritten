package KIT_Einheiten.uebungen.JavaFX_Uebungen.Klassen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * Focus Change Listener zur Änderung der Hintergrundfarbe eines Textfeldes.
 *
 * @param <T> Vom observable Value abhängiger Datentyp
 * @author Adrian Weidig
 * @since 28.03.2023
 */
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
