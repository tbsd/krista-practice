package ru.krista.edu.distrib.tech.socket;

import java.io.IOException;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        EchoClient cli = new EchoClient();
        try {
            cli.startConnection("127.0.0.1", 6000);
            System.out.println(cli.sendMessage("test"));
            cli.stopConnection();
        } catch (java.net.ConnectException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
