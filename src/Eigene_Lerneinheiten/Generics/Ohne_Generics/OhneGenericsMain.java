package Eigene_Lerneinheiten.Generics.Ohne_Generics;

import Eigene_Lerneinheiten.Generics.Auto;
import Eigene_Lerneinheiten.Generics.Fahrrad;
import Eigene_Lerneinheiten.Generics.Fahrzeug;
import Eigene_Lerneinheiten.Generics.NichtDefiniertesFahrzeug;

import java.util.ArrayList;

/**
 * Testdatei / Maindatei ohne generische Möglichkeiten
 * (abgesehen derer der ArrayList selbst)
 *
 * @author Adrian Weidig
 * @since 20.03.2023
 */
public class OhneGenericsMain {
    public static void main(String[] args) {
        // Wir nehmen einfach nur die ArrayListe statt der eigenen generischen Implementierung
        // Argument: "Ich kann ja auch einfach die ArrayList nehmen und über Polymorphie auf die
        //            zugehörigen Methoden zugreifen."
        //            --> Funktioniert nur, wenn die Methoden gleich heißen und somit überschrieben
        //                wurden. Teilweise haben jedoch unterschiedliche Objekte mit gleicher
        //                Vaterklasse auch unterschiedliche Methoden, welche aufgerufen werden sollen.
        ArrayList<Fahrzeug> fahrzeug_liste = new ArrayList<>();
        fahrzeug_liste.add(new Fahrrad());
        fahrzeug_liste.add(new Auto());
        fahrzeug_liste.add(new NichtDefiniertesFahrzeug());


        // Man ist gezwungen zusätzliche Funktionalität zu implementieren, um Zugriffe zu
        // ermöglichen und entsprechende Überprüfungen vorzunehmen, obwohl der genutzte
        // Code als "Fremdnutzer" einem nicht so bekannt ist wie der Entwickler des z.B.
        // Frameworks.
        // Man stelle sich vor, ArrayList wäre nicht generisch und man muss dies permanent
        // selbst implementieren.
        for (Fahrzeug fahrzeug : fahrzeug_liste) {
            if (fahrzeug instanceof Fahrrad) {
                ((Fahrrad) fahrzeug).fahrrad_reparieren();
            } else if (fahrzeug instanceof Auto) {
                ((Auto) fahrzeug).auto_reparieren();
            } else {
                System.out.println("toString unbekannter Fahrzeugklasse: " + fahrzeug);
            }
        }

    }
}
