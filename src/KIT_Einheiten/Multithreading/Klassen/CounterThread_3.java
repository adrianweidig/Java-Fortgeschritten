package KIT_Einheiten.Multithreading.Klassen;

public class CounterThread_3 extends Thread{
    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 100; i++) {
            System.err.println("\u001B[35mCounterThread 3 - " + i);
        }

        System.err.println("\u001B[35mCounterThread 3 beendet.");
    }
}
