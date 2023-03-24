package KIT_Einheiten.Multithreading.Apps;

import KIT_Einheiten.Multithreading.Klassen.DeadLock_1;
import KIT_Einheiten.Multithreading.Klassen.DeadLock_2;

/**
 * Testdatei / Maindatei für das fünfte Beispiel zum Thema Multithreading.
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Beispiel_5_Main {
    public static Object a = new Object();
    public static Object b = new Object();

    public static void main(String[] args) {
        DeadLock_1 deadLock1 = new DeadLock_1();
        DeadLock_2 deadLock2 = new DeadLock_2();

        deadLock1.start();
        deadLock2.start();

    }
}
