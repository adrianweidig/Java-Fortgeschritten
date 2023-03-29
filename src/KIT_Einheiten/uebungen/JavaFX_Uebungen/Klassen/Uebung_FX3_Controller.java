package KIT_Einheiten.uebungen.JavaFX_Uebungen.Klassen;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;

public class Uebung_FX3_Controller {

    @FXML
    private TextArea fx_path_area;
    @FXML
    private TreeView<File> tvBaum;

    private File start_verzeichnis = new File("C:\\");

    @FXML
    void initialize() {
        this.tvBaum.setCellFactory(param -> new TreeCell<File>() {
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                    setText("");
                } else {
                    setText(item.getName());

                }
            }
        });

        TreeItem<File> root = new TreeItem<>(start_verzeichnis);

        this.tvBaum.setRoot(root);
        root.setExpanded(true);
        root.setValue(this.start_verzeichnis);


        rekUnterverzeichnisse(this.start_verzeichnis, root);


        this.tvBaum.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isLeaf()) {
                this.fx_path_area.setText(newValue.getValue().getAbsolutePath());
            }
        });
    }

    private static void rekUnterverzeichnisse(File userdir, TreeItem<File> stringTreeItem) {
        File[] files = userdir.listFiles();
        for (File f : files) {
            TreeItem<File> stringTreeLeaf = new TreeItem<>(f);
            stringTreeItem.getChildren().add(stringTreeLeaf);

            if (f.isDirectory()) {
                try {
                    rekUnterverzeichnisse(f, stringTreeLeaf);   //rekursiver Aufruf
                } catch (NullPointerException ne) {
                    // Muss ansonsten rein, da es auch Spezialfälle gibt, bei denen ein Abbruch wäre
                }
            }
        }

    }
}
