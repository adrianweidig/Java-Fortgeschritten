package KIT_Einheiten.uebungen.Serialisierung_Uebungen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Testdatei / Maindatei für die Serialisierungsübung
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class Serialisierung_Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("test " + i+1 + " test");
        }

        Datenhalter datenhalter = new Datenhalter();
        datenhalter.initArrayList();

        String pfad = "src/KIT_Einheiten/uebungen/Serialisierung_Uebungen/resources/datenhaltung.obj";

        serialisierung(datenhalter, pfad);
        Datenhalter deserialisierter_datenhalter = (Datenhalter) deserialisierung(pfad);

        deserialisierter_datenhalter.showArrayList();
    }

    /**
     * Serialisiert das Objekt in einer Datei
     *
     * @param objekt Das zu serialisierende Objekt
     * @param dateipfad Der Pfad zur Datei
     */
    public static void serialisierung(Object objekt, String dateipfad) {
        // So werden die Streams automatisch wieder geschlossen
        try (FileOutputStream fos = new FileOutputStream(dateipfad); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(objekt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deserialisiert die angegebene Datei
     *
     * @param dateipfad Der Pfad zur Datei
     * @return Die deserialisierte Datei als Objekt
     */
    public static Object deserialisierung(String dateipfad) {
        Object obj = null;

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(dateipfad)))) {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }
}
