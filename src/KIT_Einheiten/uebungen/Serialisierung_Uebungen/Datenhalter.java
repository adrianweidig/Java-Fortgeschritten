package KIT_Einheiten.uebungen.Serialisierung_Uebungen;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Datenhaltungsklasse für eine mit Primzahlen initialisierten ArrayList
 * und deren Initialisierungs- und Aufrufmethode.
 */
public class Datenhalter implements Serializable {
    private final ArrayList<Integer> integerArrayList = new ArrayList<>();

    /**
     * Initialisiert die ArrayList mit den Primzahlen von 1 bis 100
     */
    public void initArrayList() {
        for (int i = 2; i <= 100; i++) {
            boolean istPrimzahl = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    istPrimzahl = false;
                    break;
                }
            }
            if (istPrimzahl) {
                integerArrayList.add(i);
            }
        }
    }

    /**
     * Beachte: (i+1) = Rechnung ; i+1 = 01 11, da dies mit Strings links und Rechts der
     * gewünschten Rechnung als String-Konkatenation betrachtet wird.
     */
    public void showArrayList() {
        for (int i = 0; i < integerArrayList.size(); i++) {
            System.out.println("Primzahl Nr. " + (i + 1) + " : " + integerArrayList.get(i));
        }
    }
}

