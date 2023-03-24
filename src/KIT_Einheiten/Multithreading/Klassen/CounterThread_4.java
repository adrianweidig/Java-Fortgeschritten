package KIT_Einheiten.Multithreading.Klassen;

/**
 * Klasse mit Runnable Funktionalität für simplen Counter
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class CounterThread_4 extends Thread{
    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 100; i++) {
            System.out.println("CounterThread 4 - " + i);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("CounterThread 4 beendet.");
    }
}
