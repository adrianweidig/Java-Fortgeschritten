package KIT_Einheiten.Multithreading.Klassen;

public class CounterThread_1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("CounterThread 1 - " + i);
        }
    }
}
