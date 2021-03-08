package org.example;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 65535; ++i)
            if (isPortInUse(i))
                System.out.println(i + " is in use");
    }

    static boolean isPortInUse(int port) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1", port);
            socket.close();
            return true;
        } catch (ConnectException ex) {
            return false;
        }
    }
}
