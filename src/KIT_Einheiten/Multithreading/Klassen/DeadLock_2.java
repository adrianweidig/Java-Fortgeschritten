package KIT_Einheiten.Multithreading.Klassen;

import KIT_Einheiten.Multithreading.Apps.Beispiel_5_Main;

public class DeadLock_2 extends Thread {

    /**
     * Provoziert einen Deadlock
     */
    @Override
    public void run() {
        super.run();

        synchronized (Beispiel_5_Main.b) {
            System.out.println("Deadlock2 : Lock auf b");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (Beispiel_5_Main.a) {
                System.out.println("Deadlock2 : Lock auf a");
            }
        }
    }
}
