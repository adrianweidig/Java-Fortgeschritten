package KIT_Einheiten.uebungen.JavaFX_Uebungen.Klassen;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;

import java.io.File;

/**
 * JavaFX Controllerklasse zur Übung 3
 *
 * @author Adrian Weidig
 * @since 29.03.2023
 */
public class Uebung_FX3_Controller {

    @FXML
    private TextArea fx_path_area;
    @FXML
    private TreeView<File> tvBaum;
    private final Image ordnericon = new Image(String.valueOf(this.getClass().getResource("..\\resources\\foldericon.png")));

    /**
     * Methode zum Initialisieren NACHDEM das Fenster / Stage gebaut wurde. Da hier auf das
     * Window zugegriffen wird muss dieses bereits erzeugt worden sein. Somit darf es nicht in
     * initialize aufgerufen werden.
     */
    public void afterWindowBuildInit() {
        File start_verzeichnis = new DirectoryChooser().showDialog(tvBaum.getScene().getWindow());

        TreeItem<File> root = new TreeItem<>(start_verzeichnis);
        this.tvBaum.setRoot(root);

        root.setExpanded(true);

        rekUnterverzeichnisse(start_verzeichnis, root);

        this.tvBaum.setCellFactory(param -> new TreeCell<File>() {
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                    setText("");
                } else {
                    setText(item.getName());
                    if (item.isDirectory()) {
                        setGraphic(new ImageView(ordnericon));
                    }

                }
            }
        });

        this.tvBaum.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isLeaf()) {
                this.fx_path_area.setText(newValue.getValue().getAbsolutePath());
            }
        });
    }

    /**
     * Rekursive Methode zum Initialisieren der TreeView
     *
     * @param userdir        aktuelles Verzeichnis
     * @param stringTreeItem aktuelles TreeItem
     */
    private void rekUnterverzeichnisse(File userdir, TreeItem<File> stringTreeItem) {
        File[] files = userdir.listFiles();
        if (files != null) {
            for (File f : files) {
                TreeItem<File> stringTreeLeaf = new TreeItem<>(f);
                stringTreeItem.getChildren().add(stringTreeLeaf);

                if (f.isDirectory()) {
                    rekUnterverzeichnisse(f, stringTreeLeaf);   //rekursiver Aufruf
                }
            }
        }


    }
}
