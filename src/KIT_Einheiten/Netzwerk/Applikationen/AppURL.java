package KIT_Einheiten.Netzwerk.Applikationen;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Testdatei / Maindatei für Umgang mit URL
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class AppURL {
    public static void main(String[] args) throws MalformedURLException
    {
        URL url = new URL("http://www.mlconsulting.de:80/scripte/script.cgi?name=Huber");
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Query: " + url.getQuery());
        System.out.println("Path: " + url.getPath());
    }
}
