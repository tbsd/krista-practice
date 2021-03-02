package org.example;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class App
{
    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8000, "127.0.0.1")
                .setHandler(exchange -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html");
                    exchange.getResponseSender()
                            .send("<html>" +
                                    "<head>" +
                                    "<meta charset=\"UTF-8\">" +
                                    "</head>" +
                                    "<body>" +
                                    "Курбатов Антон" +
                                    "</body>" +
                                    "</html>");
                }).build();
        server.start();
    }
}
