package KIT_Einheiten.uebungen.Multithreading_Uebungen;

import java.util.TimerTask;

/**
 * Threadklasse um eine Beschleunigung mittels Timer zu ermöglichen
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Auto_fahren extends TimerTask {

    private int geschwindigkeit_in_kmh = 0;
    private boolean bremsen = false;

    @Override
    public void run() {
        if (geschwindigkeit_in_kmh < 100 && !bremsen) {
            geschwindigkeit_in_kmh += 10;
        } else if (geschwindigkeit_in_kmh >= 100 && !bremsen) {
            System.out.println("Bremsvorgang eingeleitet.");
            geschwindigkeit_in_kmh -= 10;
            bremsen = true;
        } else {
            geschwindigkeit_in_kmh -= 10;
        }

        System.out.println("Aktuelle Geschwindigkeit: " + this.geschwindigkeit_in_kmh);
    }

    public int getGeschwindigkeit_in_kmh() {
        return geschwindigkeit_in_kmh;
    }

    public boolean isBremsen() {
        return bremsen;
    }
}
