package Eigene_Lerneinheiten.Generics.Mit_Generics;

import Eigene_Lerneinheiten.Generics.Auto;
import Eigene_Lerneinheiten.Generics.Fahrrad;
import Eigene_Lerneinheiten.Generics.Fahrzeug;

import java.util.ArrayList;

/**
 * Datenhaltungsklasse in generischer Form
 *
 * @param <T> beliebiger von Fahrzeug erbender Wert
 * @author Adrian Weidig
 * @since 23.03.2023
 */
public class FahrzeugArrayList<T extends Fahrzeug> extends ArrayList<T> {
    /**
     * Ruft bei den <u>bekannten</u> Fahrzeugen
     * deren reparieren Methode auf.
     */
    public void fahrzeuge_reparieren() {
        for (T element : this) {
            if (element instanceof Fahrrad) {
                ((Fahrrad) element).fahrrad_reparieren();
            } else if (element instanceof Auto) {
                ((Auto) element).auto_reparieren();
            } else {
                System.out.println("Nicht definiertes Fahrzeug. Reparaturprozedur nicht bekannt.");
            }
        }
    }

    /**
     * Angepasste toString zur kompletten Ausgabe
     * der Liste.
     *
     * @return die Ausgabe als String
     */
    @Override
    public String toString() {
        String ausgabe = "Keine Elemente in der Liste vorhanden.";

        // Leere Liste prüfen würde keinen Sinn ergeben
        if (!this.isEmpty()) {
            ausgabe = "";

            for (T element : this) {
                ausgabe += " [ " + element.toString() + " ]";
            }
        }

        return ausgabe;
    }

}
