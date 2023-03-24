package KIT_Einheiten.uebungen.Multithreading_Uebungen;

import java.util.Timer;

/**
 * Testdatei / Maindatei für die Auto_fahren Übung
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class AutoMain {
    public static void main(String[] args) throws InterruptedException {
        Timer timerThread = new Timer();
        Auto_fahren autoFahren = new Auto_fahren();


        // 1. Angabe = Timer
        // 2. Angabe = Zeit in ms
        // 3. Angabe = Zeit in ms in der schedule erneut aufgerufen werden soll
        timerThread.schedule(autoFahren, 0, 50);

        // Es wird Zeit benötigt um isBremsen() und die Geschwindigkeit zu überprüfen
        // währenddessen die Werte geändert werden. Ohne sleep oder in einem while(true)
        // mit if Anweisung auf die beiden Bedingungen wird run permanent erneut ausgeführt.
        while (!autoFahren.isBremsen() || autoFahren.getGeschwindigkeit_in_kmh() > 0) {
            Thread.sleep(1);
        }

        // Fehlerhaft

        //  while(true) {
        //      if(autoFahren.isBremsen() && autoFahren.getGeschwindigkeit_in_kmh() <= 0) {
        //          timerThread.cancel();
        //          autoFahren.cancel();
        //      }
        //  }

        timerThread.cancel();
        autoFahren.cancel();

    }
}
