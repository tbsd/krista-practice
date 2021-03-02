package org.example;
import java.net.*;
import java.util.Collections;
import java.util.Enumeration;

public class App {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface inter : Collections.list(interfaces)) {
                String name = inter.getName();
                String macStr = macToString(inter.getHardwareAddress());
                System.out.print("Name: ");
                System.out.println(name);
                System.out.print("MAC: ");
                System.out.println(macStr);
                Enumeration<InetAddress> inetAddresses = inter.getInetAddresses();
                for (InetAddress address : Collections.list(inetAddresses)) {
                    String ip = address.getHostAddress().split("%")[0];
                    System.out.print("Ip: ");
                    System.out.println(ip);
                }
                System.out.println();
            }
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String macToString(byte[] mac) {
        if (mac == null)
            return "no MAC-address";
        StringBuilder macBuilder = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            macBuilder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return macBuilder.toString();
    }
}
