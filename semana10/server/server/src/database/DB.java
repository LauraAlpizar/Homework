package database;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;

public abstract class DB {
    private static final String dataFilePath = "C:\\Users\\Mlaur\\POO\\server\\src\\database"; //ruta
    private static final String dataFilePath2 = System.getProperty("user.dir") + "\\src\\database\\data.json";
    public static JSONObject data = new JSONObject(); // Objeto que almacena los datos en formato JSON

    protected DB() throws FileNotFoundException {
    }

    // Carga los datos desde el archivo JSON
    public static void loadData() throws Exception {
        File file = new File(dataFilePath);  // Localiza el archivo
        if (file.exists()) { // Si el archivo existe, lo lee
            InputStream inputStream = new FileInputStream(file); // Abre un flujo de entrada desde el archivo
            String jsonText = IOUtils.toString(inputStream, "utf-8"); // Convierte el flujo de entrada en una cadena
            data = new JSONObject(jsonText); // Carga los datos en un objeto JSON
        }
        System.out.println(data); //imprime los datos
    }

    // Guarda los datos en el archivo JSON
    public static void saveData() throws Exception {
        File file = new File(dataFilePath);
        FileOutputStream outputStream = new FileOutputStream(file);  // Abre un flujo de salida hacia el archivo
        String jsonText = data.toString(); // Convierte el objeto JSON en texto
        outputStream.write(jsonText.getBytes()); // Escribe los datos en el archivo
        outputStream.close(); // Cierra el flujo de salida
    }
}
