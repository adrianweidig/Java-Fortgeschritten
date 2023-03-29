package KIT_Einheiten.JavaFX.Klassen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
 */
public class TreeViewController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label lblAuswahl;
    @FXML
    private TreeView<String> tvBaum;

    @FXML
    void initialize() {
        // root-Knoten als erstes anlegen
        TreeItem<String> root = new TreeItem<>("Punkt 1");
        tvBaum.setRoot(root);
        root.setExpanded(true);

        // root Knoten weiter Knoten hinzufügen
        root.getChildren().add(new TreeItem<String>("Punkt 1.a"));

        TreeItem<String> punkt1b = new TreeItem<String>("Punkt 1.b");
        root.getChildren().add(punkt1b);
        punkt1b.setExpanded(true);

        punkt1b.getChildren().add(new TreeItem<String>("Punkt 1.b.A"));
        punkt1b.getChildren().add(new TreeItem<String>("Punkt 1.b.B"));

        tvBaum.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem> observable, TreeItem oldValue, TreeItem newValue) {
                lblAuswahl.setText((String) newValue.getValue());
            }
        });
    }
}

