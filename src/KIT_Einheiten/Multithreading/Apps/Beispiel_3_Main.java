package KIT_Einheiten.Multithreading.Apps;

import KIT_Einheiten.Multithreading.Klassen.InterruptThread_1;

/**
 * Testdatei / Maindatei für das dritte Beispiel zum Thema Multithreading.
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Beispiel_3_Main {
    public static void main(String[] args) throws InterruptedException {
        InterruptThread_1 thread1 = new InterruptThread_1();

        thread1.start();

        Thread.sleep(1000);

        thread1.interrupt();
        System.out.println("Hauptthread beendet");
    }
}
