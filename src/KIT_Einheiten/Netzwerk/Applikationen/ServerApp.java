package KIT_Einheiten.Netzwerk.Applikationen;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Testdatei / Maindatei für einen eigenen Server
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3900)) {

            System.out.println("Server wartet auf Verbindung");

            Socket client = server.accept();

            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();

            while (client.isBound()) {
                //byte[] inhalt = new byte[0];
                int zahlen_inhalt = inputStream.read();

                System.out.print((char) zahlen_inhalt);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
