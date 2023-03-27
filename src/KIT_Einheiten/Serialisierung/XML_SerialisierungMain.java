package KIT_Einheiten.Serialisierung;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Testdatei / Maindatei für das Serialisieren von Dateien in XML Dateien
 * und der zugehörigen XML Struktur.
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class XML_SerialisierungMain {
    public static void main(String[] args) {
        Person person_1 = new Person("Max", "Huber");

        String pfad = "src/KIT_Einheiten/Serialisierung/resources/person_1.xml";

        serialisierung(person_1, pfad);
        Person deserialisierte_person_1 = (Person) deserialisierung(pfad);

        System.out.println(deserialisierte_person_1.getVorname() + " " + deserialisierte_person_1.getNachname());
    }

    /**
     * Serialisiert das Objekt in einer XML Datei
     * <p>
     * BEACHTE: XMLEncoder verlangt das EXPLIZITE Vorhandensein
     * eines ausgeschriebenen Defaultkonstruktors.
     *
     * @param objekt    Das zu serialisierende Objekt
     * @param dateipfad Der Pfad zur Datei
     */
    public static void serialisierung(Object objekt, String dateipfad) {
        // So werden die Streams automatisch wieder geschlossen
        try (FileOutputStream fos = new FileOutputStream(dateipfad); XMLEncoder xmlEncoder = new XMLEncoder(fos)) {
            xmlEncoder.writeObject(objekt);
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

        try (XMLDecoder xmlDecoder = new XMLDecoder(Files.newInputStream(Paths.get(dateipfad)))) {
            obj = xmlDecoder.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }
}
