package KIT_Einheiten.Netzwerk.Applikationen;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Testdatei / Maindatei für einen eigenen Client zum Server
 *
 * @author Adrian Weidig
 * @since 27.03.2023
 */
public class ClientApp {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 3900);

        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();

        while (true) {
            outputStream.write((new Scanner(System.in).next() + "\n").getBytes());
        }
    }
}
