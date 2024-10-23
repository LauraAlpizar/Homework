package controllers;

import com.google.gson.Gson; // Librería Gson para convertir objetos Java a JSON y viceversa
import com.sun.net.httpserver.HttpExchange; // Clase que representa una solicitud HTTP
import com.sun.net.httpserver.HttpHandler; // Interfaz para manejar solicitudes HTTP

import java.io.IOException; // Excepciones para errores de entrada/salida
import java.io.OutputStream; // Para escribir la respuesta en el cuerpo de la solicitud HTTP
import java.util.ArrayList;  // Importa la clase para manejar listas

import database.DB;
import models.Todo;

import org.json.JSONArray; // Para manejar arrays en formato JSON
import org.json.JSONObject; // Para manejar objetos JSON

// La clase TodoController implementa la interfaz HttpHandler para manejar solicitudes HTTP
public class TodoController implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println(exchange.getRequestURI()); // Imprime la URI de la solicitud (la ruta que el cliente solicita)
            System.out.println(exchange.getRequestMethod()); // Imprime el metodo HTTP (GET, POST, etc.)

            // Creamos la respuesta con el resultado de listar los "todos" (tareas), convertido a string.
            String response = listTodos().toString(); // Prepara la respuesta con la lista de todos

            // Enviamos un código de estado HTTP 200 (éxito) y la longitud de la respuesta
            exchange.sendResponseHeaders(200, response.length()); // Envia el codigo de estado HTTP 200 y la longitud de la respuesta

            OutputStream os = exchange.getResponseBody(); // Obtenemos el cuerpo de la respuesta para escribir en este
            os.write(response.getBytes()); // Escribimos la respuesta en bytes
            os.close(); // Cerramos el flujo de salida
        }

        // Listar todos los "todos" (tareas) en formato JSON
        public JSONObject listTodos() {
            JSONObject response = new JSONObject(); // Creamos un objeto JSON para la respuesta
            response.put("data",DB.data.getJSONArray("todos")); // Extraemos el array de tareas de la "base de datos"
            response.put("result","successful"); // Añadimos un resultado indicando exito
            return response; // Retornamos el objeto JSON como respuesta
        }
}
