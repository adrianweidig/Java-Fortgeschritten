package KIT_Einheiten.uebungen.Generics_Uebungen;

import java.util.ArrayList;

/**
 * Übungsdatei zum Dokument Übung Generics.docx
 *
 * @author Adrian Weidig
 * @since 23.03.2023
 */
public class Generics_Uebung {

    /**
     * Innere Datenhaltungsklasse in generischer Form
     *
     * @author Adrian Weidig
     * @since 23.03.2023
     */
    public static class Datenhaltung<T> {
        private T name;
        private T gehalt;

        /**
         * Stellt fest, ob ein String oder ein Double
         * übergeben wurde und legt anhand dessen den
         * jeweiligen Wert fest.
         *
         * @param element beliebiger Input
         */
        public void wert_festlegen(T element) {
            if (element instanceof String) {
                this.name = element;
            } else if (element instanceof Number) {
                this.gehalt = element;
            }
        }

        /**
         * Überschreibt die Standard toString Methode
         *
         * @return zugehörige Ausgabe
         */
        @Override
        public String toString() {
            return "Datenhaltung{" +
                    "name='" + name + '\'' +
                    ", gehalt=" + gehalt +
                    '}';
        }
    }

    /**
     * Innere, generische ArrayList
     *
     * @param <T> Typ der Liste
     */

    public static class GenArrayList<T> extends ArrayList<T> {
        /**
         * Gibt alle Elemente der Liste aus
         */
        public void ausgabe() {
            for (T element : this) {
                System.out.println(element);
            }
        }
    }


    public static void main(String[] args) {
        // Datenhaltungsklasse
        Datenhaltung<Object> datenhaltung = new Datenhaltung<>();
        datenhaltung.wert_festlegen("Name");
        datenhaltung.wert_festlegen(5.0);

        System.out.println(datenhaltung + "\n");

        datenhaltung.wert_festlegen(5);

        System.out.println(datenhaltung + "\n");

        // Generische ArrayList mit allen möglichen Objekten
        GenArrayList<Object> genArrayList = new GenArrayList<>();
        genArrayList.add(datenhaltung);
        genArrayList.add("Das ist ein String");
        genArrayList.add(5);

        genArrayList.ausgabe();

        // Absatz
        System.out.println();

        // Generische ArrayList lediglich mit Strings
        GenArrayList<String> stringArrayList = new GenArrayList<>();
        // Nicht möglich da der Typ auf String festgelegt ist
        // stringArrayList.add(4);

        // Es funktionieren nur die angegebenen Datentypen
        stringArrayList.add("Test 1");
        stringArrayList.add("Test 2");
        stringArrayList.add("Test 3");

        stringArrayList.ausgabe();
    }
}
