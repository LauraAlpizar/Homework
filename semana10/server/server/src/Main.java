import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import database.DB;
import org.json.JSONArray;
import server.Server;
import models.Todo;

public class Main {
    public static void main(String[] args) throws Exception {

        DB.loadData(); // Carga los datos desde el archivo de la base de datos
        new Server().start(); // Inicia el servidor

        /*
        ArrayList<Todo> todos = new ArrayList<Todo>(); // Crea una lista de "todos"
        JSONArray jsonArray = DB.data.getJSONArray("todos"); // Extrae el array JSON de la base de datos
        for (int i = 0; i < jsonArray.length(); i++) {
            todos.add(new Gson().fromJson(jsonArray.get(i).toString(), Todo.class)); // Convierte cada elemento del JSON a un objeto Todo
        }
        Todo newTodo = new Todo("","Buy album BTS",false); // Crea un nuevo objeto Todo
        todos.add(newTodo);  // Añade el nuevo todo a la lista
        DB.data.put("todos", todos); // Actualiza la base de datos con la nueva lista
        DB.saveData(); // Guarda los datos en el archivo
        */
    }
}
