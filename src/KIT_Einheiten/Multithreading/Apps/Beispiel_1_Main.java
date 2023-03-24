package KIT_Einheiten.Multithreading.Apps;

import KIT_Einheiten.Multithreading.Klassen.CounterThread_1;
import KIT_Einheiten.Multithreading.Klassen.CounterThread_2;

/**
 * Testdatei / Maindatei für das erste Beispiel zum Thema Multithreading.
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Beispiel_1_Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new CounterThread_1());
        Thread thread2 = new Thread(new CounterThread_2());

        thread1.start();
        thread2.start();

        System.out.println("Mainklasse beendet");

    }
}
