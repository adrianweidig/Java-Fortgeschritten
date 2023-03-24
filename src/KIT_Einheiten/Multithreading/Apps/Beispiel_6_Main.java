package KIT_Einheiten.Multithreading.Apps;

import KIT_Einheiten.Multithreading.Klassen.TimerTask_1;

import java.util.Timer;

/**
 * Testdatei / Maindatei für das sechste Beispiel zum Thema Multithreading.
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Beispiel_6_Main {
    public static void main(String[] args) {
        Timer timerThread = new Timer();
        // Speichert die aktuelle Zeit in ms z.B. 2000
        long aktuelleZeitInMs = System.currentTimeMillis();

        // 1. Angabe = Timer
        // 2. Angabe = Zeit in ms
        // 3. Angabe = Zeit in ms in der schedule erneut aufgerufen werden soll
        timerThread.schedule(new TimerTask_1(), 0, 1000);

        // Nimmt die JETZT vorhandene Zeit in ms z.B. 4000, zieht die
        // Startzeit davon ab und somit erhält man die aktuelle Laufzeit
        // > Gewünschte Zeit in ms (Hier 10s)
        while (true) {
            if (System.currentTimeMillis() - aktuelleZeitInMs > 10000) {
                timerThread.cancel();
                System.exit(0);
            }
        }
    }
}
