package KIT_Einheiten.Netzwerk.Applikationen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Testdatei / Maindatei für Umgang mit Webseiten und deren Inhalten
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class AppHTMLContent {
    public static void main(String[] args) throws IOException {
        URL adresse = new URL("https://www.bmw.de");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(adresse.openStream()));

        String html = "";

        while ((html = bufferedReader.readLine()) != null) {
            System.out.println(html);
        }

    }
}
