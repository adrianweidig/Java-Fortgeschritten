package Eigene_Lerneinheiten.Generics.Mit_Generics;

import Eigene_Lerneinheiten.Generics.Auto;
import Eigene_Lerneinheiten.Generics.Fahrrad;
import Eigene_Lerneinheiten.Generics.Fahrzeug;
import Eigene_Lerneinheiten.Generics.NichtDefiniertesFahrzeug;

/**
 * Testdatei / Maindatei für generische Möglichkeiten
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class MitGenericsMain {
    public static void main(String[] args) {

        // Nicht möglich, da T extends Fahrzeug. Somit ist gewährleistet, dass wir auch nur
        // solche Fahrzeuge besitzen.
        // FahrzeugArrayList<Integer> fahrzeugArrayList = new FahrzeugArrayList<Integer>();

        FahrzeugArrayList<Fahrzeug> fahrzeugArrayList = new FahrzeugArrayList<>();
        fahrzeugArrayList.add(new Fahrrad());
        fahrzeugArrayList.add(new Auto());
        fahrzeugArrayList.add(new NichtDefiniertesFahrzeug());

        // Der Aufwand liegt also auf der Seite des Entwicklers dessen (in diesem Fall)
        // generische ArrayList genutzt wird, statt auf der Seite des Nutzer-Entwicklers.
        // Sind die vorhandenen Möglichkeiten nicht ausreichend oder müssen erweitert
        // werden so kann man noch immer auf die Möglichkeit der Vererbung zurückgreifen
        // und z.B. fahrzeuge_reparieren auf eigene Art und Weise überschreiben.
        fahrzeugArrayList.fahrzeuge_reparieren();
        System.out.println(fahrzeugArrayList);

    }
}
