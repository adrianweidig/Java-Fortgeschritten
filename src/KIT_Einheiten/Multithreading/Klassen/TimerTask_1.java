package KIT_Einheiten.Multithreading.Klassen;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

/**
 * Threadklasse um Timerfunktionalität zu zeigen
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class TimerTask_1 extends TimerTask {
    @Override
    public void run() {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
