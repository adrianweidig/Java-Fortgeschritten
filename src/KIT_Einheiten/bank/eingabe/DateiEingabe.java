package KIT_Einheiten.bank.eingabe;

import KIT_Einheiten.bank.klassen.*;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * Einlesen von Informationen über eine Textdatei
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DateiEingabe implements IEingabe {

    /***********************/
    /****** Attribute ******/
    /***********************/
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    private Date aktuellesDatum = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    private ArrayList<String[]> zeilen_konten = new ArrayList<>();
    private ArrayList<String[]> zeilen_buchungen = new ArrayList<>();

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/

    /**
     * Liest die Bankdaten.txt anhand eines ABSOLUTEN Pfades ein.
     * Anschließend werden die Zeilen zerlegt und das so entstehende
     * Array entweder in die Liste der Buchungen oder der zu erstellenden
     * Konten eingegliedert.
     */
    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("E:\\Programmierung\\Java\\Kit_Fortgeschritten_1\\src\\KIT_Einheiten\\bank\\resources\\Bankdaten.txt"));

            while (br.ready()) {
                String zeile = br.readLine();
                String[] zeile_zerlegt = zeile.split(";");

                if (zeile_zerlegt[0].contains("Neues")) {
                    this.zeilen_konten.add(zeile_zerlegt);
                } else if (zeile_zerlegt[0].contains("buchung")) {
                    this.zeilen_buchungen.add(zeile_zerlegt);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return  , not null
     */
    @Override
    public ArrayList<Buchung> buchungen() {
        return null;
    }

    /**
     * Initialisiert die Liste der Buchungen und Konten.
     * Siehe {@link DateiEingabe#readFile()}
     *
     * Iteriert anschließend über die Liste der zu erstellenden Konten,
     * erzeugt die zugehörigen Objekte und gibt eine anhand der Kontonummer
     * durchnummerierte HashMap der Objekte zurück.
     *
     * @return Alle Konten, not null
     */
    @Override
    public HashMap<Integer, KontoStamm> konten() {
        this.readFile();

        HashMap<Integer, KontoStamm> konten = new HashMap<>();

        for (int zaehler = 0; zaehler < this.zeilen_konten.size(); zaehler++) {
            String[] kontoString = this.zeilen_konten.get(zaehler);

            int kontonummer = Integer.parseInt(kontoString[1]);
            String kontoinhaber = kontoString[2];

            switch (kontoString[0]) {
                case "NeuesGiroKonto":
                    GiroKonto giroKonto = new GiroKonto();

                    // Allgemeine Kontobearbeitung
                    giroKonto.setKontonummer(kontonummer);
                    giroKonto.setKontoinhaber(kontoinhaber);

                    giroKonto.setDatum(aktuellesDatum);
                    giroKonto.setSaldo(0);

                    // Kontospezifische Bearbeitung
                    giroKonto.setDispo(Double.parseDouble(kontoString[3]));
                    giroKonto.setSollzins(Double.parseDouble(kontoString[4]));

                    konten.put(kontonummer, giroKonto);
                    break;
                case "NeuesSparkonto":
                    try {
                        SparKonto sparKonto = new SparKonto();

                        // Allgemeine Kontobearbeitung
                        sparKonto.setKontonummer(kontonummer);
                        sparKonto.setKontoinhaber(kontoinhaber);

                        sparKonto.setDatum(aktuellesDatum);
                        sparKonto.setSaldo(0);

                        // Kontospezifische Bearbeitung
                        sparKonto.setKuendbetrag(Double.parseDouble(kontoString[3]));
                        sparKonto.setKuenddatum(formatter.parse(kontoString[4]));
                        sparKonto.setHabenzins(Double.parseDouble(kontoString[5]));

                        konten.put(kontonummer, sparKonto);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "NeuesDarlehenskonto":
                    DarlehensKonto darlehensKonto = new DarlehensKonto();

                    // Allgemeine Kontobearbeitung
                    darlehensKonto.setKontonummer(kontonummer);
                    darlehensKonto.setKontoinhaber(kontoinhaber);

                    darlehensKonto.setDatum(aktuellesDatum);
                    darlehensKonto.setSaldo(0);

                    // Kontospezifische Bearbeitung
                    darlehensKonto.setRate(Double.parseDouble(kontoString[3]));

                    konten.put(kontonummer, darlehensKonto);
                    break;
            }
        }

        return konten;
    }
/***********************/
/** Getter und Setter **/
/***********************/
}
