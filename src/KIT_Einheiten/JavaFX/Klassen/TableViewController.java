package KIT_Einheiten.JavaFX.Klassen;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TableViewController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableColumn<Person, String> tcPersNr;
    @FXML
    private TableColumn<Person, String> tcNachname;
    @FXML
    private TableColumn<Person, String> tcGebDatum;
    @FXML
    private TableColumn<Person, String> tcVorname;
    @FXML
    private TableView<Person> tblPersonen;
    @FXML
    private Button btnAnzeigen;

    private ObservableList<Person> tblPersonenData = FXCollections.observableArrayList();

    public TableViewController() {
        tblPersonenData.add(new Person(1, "Max", "Huber", LocalDate.of(1990, 1, 1)));
        tblPersonenData.add(new Person(2, "Maria", "Meier", LocalDate.of(1980, 2, 3)));
        tblPersonenData.add(new Person(3, "Hans", "Schmidt", LocalDate.of(1985, 4, 5)));
    }

    @FXML
    void initialize() {
        tblPersonen.setItems(tblPersonenData);

        tcPersNr.setCellValueFactory(new PropertyValueFactory<>("persnr"));
        tcVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        tcNachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        tcGebDatum.setCellValueFactory(param -> {
            Person pers = param.getValue();
            String str = pers.getGebdatum().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            return new SimpleStringProperty(str);
        });
    }

    @FXML
    void btnAnzeigen_Click(ActionEvent event) {
        if (tblPersonen.getSelectionModel().getSelectedIndex() < 0)
            return;
        Person pers = tblPersonen.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Person");
        alert.setHeaderText("");
        alert.setContentText(pers.getVorname() + " " + pers.getNachname());
        alert.showAndWait();
    }

}
