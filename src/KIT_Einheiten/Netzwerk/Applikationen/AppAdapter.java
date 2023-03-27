package KIT_Einheiten.Netzwerk.Applikationen;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;

/**
 * Testdatei / Maindatei für Informationen aus Netzwerkinhalten
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class AppAdapter {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        for(NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            System.out.println(networkInterface);
            System.out.println(networkInterface.getDisplayName());

            InetAddress[] adressen = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());

            for(InetAddress address : adressen) {
                System.out.println("Adresse: " + address.getHostAddress());
                System.out.println("Hostname: " + address.getHostName());
            }
        }
    }
}
