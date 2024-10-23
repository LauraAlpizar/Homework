package controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;


public class UserController implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println(exchange.getRequestURI());
        System.out.println(exchange.getRequestMethod());

        String response = "Hola usuarios"; // Respuesta estática para los usuarios

        exchange.sendResponseHeaders(200,response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
