package KIT_Einheiten.Multithreading.Apps;

import KIT_Einheiten.Multithreading.Klassen.ConsumerThread_1;
import KIT_Einheiten.Multithreading.Klassen.ProducerThread_1;

import java.util.ArrayList;

/**
 * Testdatei / Maindatei für das siebte Beispiel zum Thema Multithreading.
 *
 * @author Adrian Weidig
 * @since 24.03.2023
 */
public class Beispiel_7_Main {
    public static void main(String[] args) {
        ArrayList<String> bier = new ArrayList<>();

        ProducerThread_1 producerThread1 = new ProducerThread_1(bier);
        ConsumerThread_1 consumerThread1 = new ConsumerThread_1(bier);

        producerThread1.start();
        consumerThread1.start();

    }
}
