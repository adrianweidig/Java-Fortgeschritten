package KIT_Einheiten.Multithreading.Klassen;

import java.util.ArrayList;

/**
 * Threadklasse um Consumer Producer Threadmöglichkeiten zu verdeutlichen
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class ProducerThread_1 extends Thread {
    private final ArrayList<String> bier;

    public ProducerThread_1(ArrayList<String> bier) {
        this.bier = bier;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            // Legt einen synchronisierten Zugriff auf die Liste fest
            // nicht auf die Klasse!
            synchronized (bier) {
                bier.add("Augustiner");
                bier.notify();
                System.out.println("Es sind derzeit " + bier.size() + " Flaschen vorhanden.");

                if (bier.size() >= 20) {
                    System.out.println("Mehr als 20 Flaschen gehen nicht in den Kasten.");
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
