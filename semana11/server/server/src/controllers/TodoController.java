package controllers;

import com.google.gson.Gson; // Librería Gson para convertir objetos Java a JSON y viceversa
import com.sun.net.httpserver.HttpExchange; // Clase que representa una solicitud HTTP
import com.sun.net.httpserver.HttpHandler; // Interfaz para manejar solicitudes HTTP

import java.io.IOException; // Excepciones para errores de entrada/salida
import java.io.InputStream;
import java.io.OutputStream; // Para escribir la respuesta en el cuerpo de la solicitud HTTP
import java.io.StringWriter;
import java.util.ArrayList;  // Importa la clase para manejar listas

import database.DB;
import models.Todo;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray; // Para manejar arrays en formato JSON
import org.json.JSONObject; // Para manejar objetos JSON

// La clase TodoController implementa la interfaz HttpHandler para manejar solicitudes HTTP
public class TodoController implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "";
        String requestMethod = exchange.getRequestMethod();

        try {
            if (requestMethod.equals("GET")) {
                response = listTodos().toString();
            } else if (requestMethod.equals("POST")) {
                response = addTodo(exchange.getRequestBody()).toString();
            } else if (requestMethod.equals("DELETE")) {
                String[] paths = exchange.getRequestURI().getPath().split("/");
                String todoId = paths[paths.length - 1];
                System.out.println("Eliminando todo con ID: " + todoId); // Depuración

                JSONObject jsonResponse = deleteTodo(todoId);
                response = jsonResponse.toString();
            } else {
                exchange.sendResponseHeaders(405, -1);
                return;
            }
            exchange.sendResponseHeaders(200, response.length());
        } catch (Exception e) {
            // En caso de error, enviar respuesta con código 500
            response = "{\"result\":\"error\", \"message\":\"" + e.getMessage() + "\"}";
            exchange.sendResponseHeaders(500, response.length());
        } finally {
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }


    public JSONObject deleteTodo(String todoId) throws Exception {
        JSONObject response = new JSONObject();
        JSONArray todos = DB.data.getJSONArray("todos");

        System.out.println("Todos actuales: " + todos.toString());

        int index = -1;
        for (int i = 0; i < todos.length(); i++) {
            JSONObject todo = todos.getJSONObject(i);
            if (todo.getString("id").equals(todoId)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            todos.remove(index);
            DB.saveData();
            response.put("result", "successful");
        } else {
            response.put("result", "error");
            response.put("message", "Todo not found");
        }

        return response;
    }

    public JSONObject addTodo(InputStream todoBody) throws Exception {
        StringWriter sw = new StringWriter();
        IOUtils.copy(todoBody, sw);
        String body = sw.toString();
        JSONObject jsonBody = new JSONObject(body);
        String title = jsonBody.getString("title");
        Todo newTodo = new Todo("", title, false);
        JSONObject newTodoJsonObject = new JSONObject(newTodo);
        DB.data.getJSONArray("todos").put(newTodoJsonObject);
        DB.saveData();

        JSONObject response = new JSONObject();
        response.put("result", "successful");
        return response;
    }


    public JSONObject listTodos() {
        JSONObject response = new JSONObject();
        response.put("data", DB.data.getJSONArray("todos"));
        response.put("result", "successful");
        return response;
    }
}
