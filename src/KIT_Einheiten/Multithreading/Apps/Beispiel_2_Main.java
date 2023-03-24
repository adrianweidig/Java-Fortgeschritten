package KIT_Einheiten.Multithreading.Apps;

import KIT_Einheiten.Multithreading.Klassen.CounterThread_3;
import KIT_Einheiten.Multithreading.Klassen.CounterThread_4;

/**
 * Testdatei / Maindatei für das zweite Beispiel zum Thema Multithreading.
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Beispiel_2_Main {
    public static void main(String[] args) {
        CounterThread_3 thread3 = new CounterThread_3();
        CounterThread_4 thread4 = new CounterThread_4();

        thread3.start();
        thread4.start();
    }
}
