package KIT_Einheiten.Multithreading.Klassen;

import java.util.ArrayList;

/**
 * Threadklasse um Consumer Producer Threadmöglichkeiten zu verdeutlichen
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class ConsumerThread_1 extends Thread {
    private ArrayList<String> bier;

    public ConsumerThread_1(ArrayList<String> bier) {
        this.bier = bier;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            synchronized (bier) {
                if (bier.size() < 1) {
                    try {
                        bier.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Es wurden entnommen ein " + bier.get(0));
                bier.remove(0);
                bier.notify();
                System.out.println("Derzeit sind " + bier.size() + " Flaschen vorhanden.");

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
