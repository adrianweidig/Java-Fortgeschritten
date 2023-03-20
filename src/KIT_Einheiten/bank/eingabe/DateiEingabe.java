package KIT_Einheiten.bank.eingabe;

import KIT_Einheiten.bank.klassen.*;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class DateiEingabe implements IEingabe {

    /***********************/
    /****** Attribute ******/
    /***********************/

    /***********************/
    /**** Konstruktor ******/
    /***********************/

    /***********************/
    /****** Methoden *******/
    /***********************/
    @Override
    public ArrayList<Buchung> buchungen() {
        return null;
    }


    /**
     * Hilfsfunktionen für konten Methode
     **/

    @Override
    public HashMap<Integer, KontoStamm> konten() {

        HashMap<Integer, KontoStamm> konten = new HashMap<>();

        try {
            ArrayList<String> zeilen = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader("E:\\Programmierung\\Java\\Kit_Fortgeschritten_1\\src\\KIT_Einheiten\\bank\\resources\\Bankdaten.txt"));

            while (br.ready()) {
                zeilen.add(br.readLine());
            }

            for (int zaehler = 0; zaehler < zeilen.size(); zaehler++) {
                String[] kontoString = zeilen.get(zaehler).split(";");
                Date aktuellesDatum = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
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

                        konten.put(zaehler, giroKonto);
                        break;
                    case "NeuesSparkonto":
                        SparKonto sparKonto = new SparKonto();

                        // Allgemeine Kontobearbeitung
                        sparKonto.setKontonummer(kontonummer);
                        sparKonto.setKontoinhaber(kontoinhaber);

                        sparKonto.setDatum(aktuellesDatum);
                        sparKonto.setSaldo(0);

                        // Kontospezifische Bearbeitung
                        sparKonto.setHabenzins(Double.parseDouble(kontoString[3]));
                        sparKonto.setKuenddatum(new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse(kontoString[4]));
                        sparKonto.setKuendbetrag(Double.parseDouble(kontoString[5]));

                        konten.put(zaehler, sparKonto);
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

                        konten.put(zaehler, darlehensKonto);
                        break;
                    case "buchung":
                        break;
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return konten;
    }
    /***********************/
    /** Getter und Setter **/
    /***********************/
}
