package KIT_Einheiten.JavaFX.Klassen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
 */
public class EinfacheKomponentenController {
    /***********************/
    /*** FXML Attribute ****/
    /***********************/
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private DatePicker dtDatum;
    @FXML
    private CheckBox chkJaNein;
    @FXML
    private ComboBox<String> cboNamen;
    @FXML
    private ComboBox<Person> cboPerson;

    @FXML
    private ListView<Person> lvPerson;

    /***********************/
    /****** Attribute ******/
    /***********************/

    private ObservableList<String> cboNamenData = FXCollections.observableArrayList();
    private ObservableList<Person> cboPeronData = FXCollections.observableArrayList();

    /***********************/
    /**** Konstruktoren ****/
    /**** und Initialize ***/
    /***********************/

    /**
     * Initialisiert den Controller
     */
    public EinfacheKomponentenController() {
        cboNamenData.add("Huber");
        cboNamenData.add("Maier");
        cboNamenData.add("Schmidt");

        cboPeronData.add(new Person(1, "Max", "Huber", LocalDate.of(2001, 1, 5)));
        cboPeronData.add(new Person(2, "Maria", "Maier", LocalDate.of(1980, 10, 15)));
        cboPeronData.add(new Person(3, "August", "Schmidt", LocalDate.of(1964, 3, 23)));
    }

    /**
     * Initialisiert den Controller und den "Beginn" des Lebenszyklus der FXML App.
     */
    @FXML
    void initialize() {
        cboNamen.setItems(cboNamenData);
        cboPerson.setItems(cboPeronData);
        lvPerson.setItems(cboPeronData);

        // Converter für cboPerson
        cboPerson.setConverter(new StringConverter<Person>() {
            @Override
            public String toString(Person object) {
                return object.getVorname() + " " + object.getNachname();
            }

            @Override
            public Person fromString(String string) {
                return null;
            }
        });

        cboPerson.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

            @Override
            public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                System.out.println(newValue.getVorname() + " " + newValue.getNachname() + " " +
                        newValue.getGebdatum().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            }
        });

        lvPerson.setCellFactory(param -> {
            TextFieldListCell<Person> cell = new TextFieldListCell<>(new StringConverter<Person>() {

                @Override
                public Person fromString(String string) {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public String toString(Person object) {
                    return object.getPersnr() + " " + object.getVorname() + " " + object.getNachname();
                }
            });
            return cell;
        });

        // Alternative zu der onAction Methode
        dtDatum.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(dtDatum.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            }
        });
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    /***********************/
    /*** Control Methoden **/
    /** (z.B.ButtonClicks) */
    /***********************/

    @FXML
    void chkJaNein_Click(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Checkbox");
        alert.setHeaderText("");

        if (chkJaNein.isSelected())
            alert.setContentText("ist angeklickt");
        else
            alert.setContentText("ist nich angeklickt");
        alert.showAndWait();
    }

    @FXML
    void cboNamen_Click(ActionEvent event) {
        System.out.println(cboNamen.getValue());
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/

}
