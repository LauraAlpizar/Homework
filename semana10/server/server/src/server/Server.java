package server;

import com.sun.net.httpserver.HttpServer;
import controllers.TodoController;
import controllers.UserController;

import java.net.InetSocketAddress;
import java.io.IOException;

public class Server {
    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0); // Crea el servidor en el puerto 8080
        server.createContext("/api/todos", new TodoController()); // Asigna el controlador TodoController a la ruta /api/todos
        server.createContext("/api/users", new UserController()); // Asigna el controlador UserController a la ruta /api/users
        server.setExecutor(null);  // Usa el executor por defecto para manejar las solicitudes
        server.start(); // Inicia el servidor
    }
}
