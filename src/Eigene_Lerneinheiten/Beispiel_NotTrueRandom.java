package Eigene_Lerneinheiten;

import java.util.Random;

/**
 * Beispieltestklasse zum Veranschaulichen, dass Random
 * keine echten Zufallswerte zurückgibt.
 * <p>
 * Quelle: https://stackoverflow.com/questions/15182496/why-does-this-code-using-random-strings-print-hello-world?rq=1
 */
public class Beispiel_NotTrueRandom {
    public static void main(String[] args) {
        System.out.println(randomString(-229985452) + " " + randomString(-147909649));
    }

    /**
     * "Seedet" das Random-Objekt und baut dann anhand der
     * gewählten Zufallszahlen einen String aus deren
     * ASCII-Code Werten.
     *
     * @param i Seed
     * @return Auszugebender String
     */
    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder return_string = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            return_string.append((char) ('`' + k));
        }

        return return_string.toString();
    }
}
