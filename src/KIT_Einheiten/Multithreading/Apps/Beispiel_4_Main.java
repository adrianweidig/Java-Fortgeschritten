package KIT_Einheiten.Multithreading.Apps;

import KIT_Einheiten.Multithreading.Klassen.SyncThread_1;

/**
 * Testdatei / Maindatei für das vierte Beispiel zum Thema Multithreading.
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Beispiel_4_Main {

    public static void main(String[] args) {
        Thread t1 = new SyncThread_1("Thread 1");
        Thread t2 = new SyncThread_1("Thread 2");

        t1.start();
        t2.start();

    }
}
