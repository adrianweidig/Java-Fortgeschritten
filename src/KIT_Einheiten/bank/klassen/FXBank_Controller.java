package KIT_Einheiten.bank.klassen;

import KIT_Einheiten.applikationen.AppDatenbankLaden;
import KIT_Einheiten.bank.eingabe.DatenbankEingabe;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JavaFX Controller Vorlage
 *
 * @author Adrian Weidig
 * @since 30.03.2023
 */
public class FXBank_Controller {
    /***********************/
    /*** FXML Attribute ****/
    /***********************/
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane fx_center_tabpane;

    @FXML
    private Menu fx_menu;

    @FXML
    private MenuItem fx_menuitem_syncDB, fx_menuitem_leave;

    /***********************/
    /****** Attribute ******/
    /***********************/
    private DatenbankEingabe db_eingabe = new DatenbankEingabe();

    private HashMap<Integer, KontoStamm> verarbeitete_konten = db_eingabe.konten();
    private ArrayList<Buchung> buchungen = db_eingabe.buchungen();

    private ArrayList<String> tabellen = db_eingabe.getTables();

    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    /***********************/
    /**** Konstruktoren ****/
    /**** und Initialize ***/
    /***********************/

    /**
     * Initialisiert den Controller und den "Beginn" des Lebenszyklus der FXML App.
     */
    @FXML
    void initialize() {
        // Gibt grundsätzlich den genutzten Speicherort aus
        System.out.println("Location: " + this.location);
        AppDatenbankLaden.datenbankInitialisieren();
        this.buildTabs();
        this.fillTabs();
    }

    /***********************/
    /****** Methoden *******/
    /***********************/

    private void readDB() {
        this.verarbeitete_konten = db_eingabe.konten();
        this.buchungen = db_eingabe.buchungen();
        this.tabellen = db_eingabe.getTables();
    }

    private Tab getTabByName(String name) {
        Tab returnTab = null;

        // Safety first und so
        if (this.fx_center_tabpane != null && !this.fx_center_tabpane.getTabs().isEmpty()) {
            for (int i = 0; i < this.fx_center_tabpane.getTabs().size(); i++) {
                Tab tmpTab = this.fx_center_tabpane.getTabs().get(i);
                if (tmpTab.getText().equalsIgnoreCase(name)) {
                    returnTab = tmpTab;
                }
            }
        }

        return returnTab;
    }

    private HashMap<String, String> convertAccountToHashMap(KontoStamm konto) {
        HashMap<String, String> accountMap = new HashMap<>();
        String kontoart = konto.getClass().getSimpleName().toLowerCase();

        accountMap.put("Kontonummer", String.valueOf(konto.getKontonummer()));
        accountMap.put("Kontoinhaber", konto.getKontoinhaber());
        accountMap.put("Saldo", String.valueOf(konto.getSaldo()));

        switch (kontoart) {
            case "girokonto":
                GiroKonto giroKonto = (GiroKonto) konto;
                accountMap.put("Dispo", String.valueOf(giroKonto.getDispo()));
                accountMap.put("Sollzins", String.valueOf(giroKonto.getSollzins()));
                break;
            case "sparkonto":
                SparKonto sparKonto = (SparKonto) konto;
                accountMap.put("Habenzins", String.valueOf(sparKonto.getHabenzins()));
                accountMap.put("Kündbetrag", String.valueOf(sparKonto.getKuendbetrag()));
                accountMap.put("Künddatum", formatter.format(sparKonto.getKuenddatum()));
                break;
            case "darlehenskonto":
                DarlehensKonto darlehensKonto = (DarlehensKonto) konto;
                accountMap.put("Rate", String.valueOf(darlehensKonto.getRate()));
                break;
        }

        return accountMap;

    }

    private void buildTabs() {
        for (String tabelle : this.tabellen) {
            Tab newTab = new Tab(tabelle);

            if (tabelle.equals("Buchung")) {
                tabelle += "en";
                newTab.setContent(buildPayments());
            } else {
                TreeTableView<HashMap<String, String>> accountTreeTableview = buildAccountTreeTableView(tabelle);
                newTab.setContent(accountTreeTableview);
            }

            this.fx_center_tabpane.getTabs().add(newTab);

        }
    }

    private void fillTabs() {
        for (Buchung buchung : buchungen) {
            Tab buchungsTab = getTabByName("Buchung");
            TableView<Buchung> buchungTableView = (TableView<Buchung>) buchungsTab.getContent();
            buchungTableView.getItems().add(buchung);

            KontoStamm konto = verarbeitete_konten.get(buchung.getKontonummer());
            String fehler = konto.buchungspruefung(buchung);

            if (fehler.isEmpty()) {
                konto.updateSaldo(buchung);
                db_eingabe.saldoVerbuchen(buchung);
            } else {
                // TODO: FEHLER AUSGABE
            }
        }

        for (KontoStamm konto : verarbeitete_konten.values()) {
            String kontoname = konto.getClass().getSimpleName();
            Tab kontoTab = getTabByName(kontoname);
            TreeTableView<HashMap<String, String>> treeTableView = (TreeTableView<HashMap<String, String>>) kontoTab.getContent();

            HashMap<String, String> accountMap = this.convertAccountToHashMap(konto);
            TreeItem<HashMap<String, String>> acountItem = new TreeItem<>(accountMap);

            // Die HashMap hatte den Zweck beliebige String-Werte hinzufügen zu können.
            // Somit müssen wir die Buchung lediglich in die richtige Spalte zwecks
            // Ansicht hinzufügen, nicht jedoch zwecks des richtigen Titels.
            ArrayList<Buchung> kontoBuchungen = konto.getBuchungen();

            for (int i = 0; i < kontoBuchungen.size(); i++) {
                String kontonummer = "Nr. " + (i + 1);
                String buchungsdatum = "Buchung am " + formatter.format(kontoBuchungen.get(i).getDatum());
                String buchungsbetrag = "Betrag: " + kontoBuchungen.get(i).getBetrag();

                // Man beachte, dass die "Titel" der HashMap den Spalten entsprechen MÜSSEN
                HashMap<String, String> buchungsMap = new HashMap<>();

                buchungsMap.put("Kontonummer", kontonummer);
                buchungsMap.put("Kontoinhaber", buchungsdatum);
                buchungsMap.put("Saldo", buchungsbetrag);

                acountItem.getChildren().add(new TreeItem<>(buchungsMap));
            }


            treeTableView.getRoot().getChildren().add(acountItem);
        }
    }

    private TableView<Buchung> buildPayments() {
        TableView<Buchung> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setStyle("-fx-alignment: CENTER;");

        TableColumn<Buchung, String> spalte_kontonummer = new TableColumn<>("Konto\n  Nr.");
        spalte_kontonummer.setStyle("-fx-alignment: CENTER-RIGHT;");
        spalte_kontonummer.setMaxWidth(750);

        spalte_kontonummer.setCellValueFactory(zellitem -> new SimpleStringProperty(String.valueOf(zellitem.getValue().getKontonummer())));

        TableColumn<Buchung, String> spalte_datum = new TableColumn<>("Buchungs-Datum");
        spalte_datum.setCellValueFactory(zellitem -> new SimpleStringProperty(formatter.format(zellitem.getValue().getDatum())));

        TableColumn<Buchung, String> spalte_betrag = new TableColumn<>("Betrag");
        spalte_betrag.setCellValueFactory(zellitem -> new SimpleStringProperty(String.valueOf(zellitem.getValue().getBetrag())));

        tableView.getColumns().addAll(spalte_kontonummer, spalte_datum, spalte_betrag);

        return tableView;

    }

    public TreeTableView<HashMap<String, String>> buildAccountTreeTableView(String name) {
        System.out.println(name);
        TreeTableView<HashMap<String, String>> treeTableView = new TreeTableView<>();
        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        treeTableView.setStyle("-fx-alignment: CENTER;");


        // Standard-Spalten, welche jedes Konto hat
        TreeTableColumn<HashMap<String, String>, String> spalte_kontonummer = new TreeTableColumn<>("Konto\n  Nr.");
        spalte_kontonummer.setStyle("-fx-alignment: CENTER-RIGHT;");
        spalte_kontonummer.setMinWidth(30);
        spalte_kontonummer.setMaxWidth(900);

        spalte_kontonummer.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Kontonummer")));

        TreeTableColumn<HashMap<String, String>, String> spalte_kontoinhaber = new TreeTableColumn<>("Kontoinhaber");
        spalte_kontoinhaber.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Kontoinhaber")));

        TreeTableColumn<HashMap<String, String>, String> spalte_saldo = new TreeTableColumn<>("Saldo");
        spalte_saldo.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Saldo")));

        treeTableView.getColumns().addAll(spalte_kontonummer, spalte_kontoinhaber, spalte_saldo);

        switch (name.toLowerCase()) {
            case "girokonto":
                TreeTableColumn<HashMap<String, String>, String> spalte_dispo = new TreeTableColumn<>("Dispo");
                spalte_dispo.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Dispo")));

                TreeTableColumn<HashMap<String, String>, String> spalte_sollzins = new TreeTableColumn<>("Sollzins");
                spalte_sollzins.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Sollzins")));

                treeTableView.getColumns().addAll(spalte_dispo, spalte_sollzins);
                break;
            case "sparkonto":
                TreeTableColumn<HashMap<String, String>, String> spalte_habenzins = new TreeTableColumn<>("Habenzins");
                spalte_habenzins.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Habenzins")));

                TreeTableColumn<HashMap<String, String>, String> spalte_kuendbetrag = new TreeTableColumn<>("Kündbetrag");
                spalte_kuendbetrag.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Kündbetrag")));

                TreeTableColumn<HashMap<String, String>, String> spalte_kuenddatum = new TreeTableColumn<>("Künddatum");
                spalte_kuenddatum.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Künddatum")));

                treeTableView.getColumns().addAll(spalte_habenzins, spalte_kuendbetrag, spalte_kuenddatum);
                break;
            case "darlehenskonto":
                TreeTableColumn<HashMap<String, String>, String> spalte_rate = new TreeTableColumn<>("Rate");
                spalte_rate.setCellValueFactory(zellitem -> new SimpleStringProperty(zellitem.getValue().getValue().get("Rate")));

                treeTableView.getColumns().add(spalte_rate);
                break;
        }


        // Root wird nicht benötigt wird somit "leer" hinzugefügt
        TreeItem<HashMap<String, String>> root = new TreeItem<>();
        treeTableView.setRoot(root);
        treeTableView.setShowRoot(false);

        return treeTableView;
    }

    /***********************/
    /*** Control Methoden **/
    /** (z.B.ButtonClicks) */
    /***********************/

    @FXML
    private void on_db_sync_click(ActionEvent event) {
        AppDatenbankLaden.datenbankInitialisieren();
        this.fx_center_tabpane.getTabs().removeAll(this.fx_center_tabpane.getTabs());
        this.readDB();
        this.buildTabs();
        this.fillTabs();
    }

    @FXML
    private void on_leave_click(ActionEvent event) {
        Stage s = (Stage) this.fx_center_tabpane.getScene().getWindow();
        s.close();
    }

    /***********************/
    /** Getter und Setter **/
    /***********************/
}

