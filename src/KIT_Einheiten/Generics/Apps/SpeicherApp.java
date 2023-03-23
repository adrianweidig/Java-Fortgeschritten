package KIT_Einheiten.Generics.Apps;

import KIT_Einheiten.Generics.Klassen.Speicherklasse;
import KIT_Einheiten.Generics.Klassen.Speicherklasse_Generic;

/**
 * Testklasse für Generics Lerneinheit
 *
 * @author Adrian Weidig
 * @since 23.03.2023
 */
public class SpeicherApp {
    public static void main(String[] args) {
        // Standardvariante
        Speicherklasse speicher = new Speicherklasse(123);

        System.out.println(speicher.getSpeicher());

        speicher.setSpeicher(456);

        System.out.println(speicher.getSpeicher());

        // Genericvariante
        Speicherklasse_Generic<String> string_speicher_generic = new Speicherklasse_Generic<>("Hallo");

        System.out.println(string_speicher_generic.getSpeicher());

        string_speicher_generic.setSpeicher("Hallo Welt!");

        System.out.println(string_speicher_generic.getSpeicher());

        Speicherklasse_Generic<Integer> int_speicher_generic = new Speicherklasse_Generic<>(123);

        System.out.println(int_speicher_generic.getSpeicher());

        int_speicher_generic.setSpeicher(456);

        System.out.println(int_speicher_generic.getSpeicher());

    }
}
