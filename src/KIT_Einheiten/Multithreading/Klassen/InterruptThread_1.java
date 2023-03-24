package KIT_Einheiten.Multithreading.Klassen;

/**
 * Threadklasse um Interrupt zu verdeutlichen
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class InterruptThread_1 extends Thread {
    @Override
    public void run() {
        super.run();

        while (!isInterrupted()) {
            System.out.println("InterruptThread_1 läuft");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("\u001B[35mMoment gefunden in dem wir sleep unterbrechen.");
                this.interrupt();
            }
        }
    }
}
