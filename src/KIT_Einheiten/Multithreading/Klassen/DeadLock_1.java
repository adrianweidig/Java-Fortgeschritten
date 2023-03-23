package KIT_Einheiten.Multithreading.Klassen;

import KIT_Einheiten.Multithreading.Apps.Beispiel_5_Main;

public class DeadLock_1 extends Thread{
    @Override
    public void run() {
        super.run();

        synchronized (Beispiel_5_Main.a) {
            System.out.println("Deadlock1 : Lock auf a");
            synchronized (Beispiel_5_Main.b) {
                System.out.println("Deadlock1 : Lock auf b");
            }
        }
    }
}
