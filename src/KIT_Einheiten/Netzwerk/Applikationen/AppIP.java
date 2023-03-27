package KIT_Einheiten.Netzwerk.Applikationen;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Testdatei / Maindatei für Umgang mit InetAdress und zugehörigen Funktionalitäten
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class AppIP {
    public static void main(String[] args) throws IOException {

        InetAddress adresse = InetAddress.getByName("www.bmw.de");

        // Gibt anhand der angegebenen Adresse die zugehörige IP-Adresse zurück
        System.out.println(adresse.getHostAddress());

        // Prüft, ob die Adresse erreichbar ist
        System.out.println(adresse.isReachable(20));
    }
}
