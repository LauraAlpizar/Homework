// Importamos las clases necesarias para trabajar con nuestro modelo de personajes, enums, y JSON.
import Models.Character;
import Models.Enums.Gender;
import Models.Enums.Status;
import org.json.JSONArray;
import org.json.JSONObject;

// Importamos las clases para hacer solicitudes HTTP y manejar las respuestas.
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de la clase Character (nuestro primer personaje)
        Character myFirstCharacter = new Character(1, "Jonathan", Status.Alive, Gender.Male, "Human", "Human", "Earth", new String[]{"https://rickandmortyapi.com/api/episode/1"});

        // Imprimimos las propiedades del personaje para verificar que se han inicializado correctamente.
        System.out.println(myFirstCharacter.getId());      // Imprime el ID del personaje.
        System.out.println(myFirstCharacter.getName());    // Imprime el nombre del personaje.
        System.out.println(myFirstCharacter.getStatus());  // Imprime el estado (Alive, Dead, Unknown).
        System.out.println(myFirstCharacter.getGender());  // Imprime el género del personaje (Male, Female, etc.).
        System.out.println(myFirstCharacter.getSpecies()); // Imprime la especie del personaje (Human, Alien, etc.).
        System.out.println(myFirstCharacter.getType());    // Imprime el tipo del personaje (si es un tipo especial, de lo contrario vacío).
        System.out.println(myFirstCharacter.getOrigin());  // Imprime el origen del personaje (nombre del lugar de origen).
        System.out.println(myFirstCharacter.getEpisode()); // Imprime la lista de episodios en los que aparece.

        // Definimos la URL de la API para obtener información de personajes.
        String url = "https://rickandmortyapi.com/api/character";

        // Creamos una solicitud HTTP GET para obtener los datos desde la API.
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))  // Especificamos la URI de la API.
                .build();              // Construimos la solicitud.

        try {
            // Enviamos la solicitud HTTP y recibimos la respuesta en formato String.
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Parseamos la respuesta JSON a un objeto JSONObject.
            JSONObject responseBody = new JSONObject(response.body());

            // Obtenemos el array de resultados (personajes) desde el JSON.
            JSONArray results = responseBody.getJSONArray("results");

            // Imprimimos todos los personajes obtenidos desde la API.
            System.out.println(results);

            // Iteramos sobre el array de personajes para procesarlos uno por uno.
            for (int i = 0; i < results.length(); i++) {
                // Extraemos los datos de cada personaje en el formato correcto.
                JSONObject character = results.getJSONObject(i);

                // Obtenemos el ID del personaje.
                int id = character.getInt("id");

                // Obtenemos el nombre del personaje.
                String name = character.getString("name");

                // Transformamos el estado del personaje a un valor del enum 'Status'.
                Status status = Status.valueOf(
                        character.getString("status")
                                .substring(0, 1).toUpperCase() +
                                character.getString("status")
                                        .substring(1).toLowerCase()
                );

                // Obtenemos el género del personaje y lo convertimos al enum 'Gender'.
                Gender gender = Gender.valueOf(character.getString("gender"));

                // Obtenemos la especie del personaje.
                String species = character.getString("species");

                // Obtenemos el tipo del personaje (si tiene un tipo especial).
                String type = character.getString("type");

                // Obtenemos el primer episodio donde aparece el personaje.
                JSONArray episodes = character.getJSONArray("episode");

                // Obtenemos el nombre del origen del personaje.
                String origin = character.getJSONObject("origin").getString("name");

                // Creamos una nueva instancia de Character con los datos obtenidos.
                Character newCharacter = new Character(
                        id, name, status, gender, species, type, origin,
                        new String[]{episodes.getString(0)} // Solo agregamos el primer episodio
                );

                // Imprimimos la información completa del personaje.
                System.out.println(newCharacter.getId() + " " +
                        newCharacter.getName() + " " +
                        newCharacter.getStatus() + " " +
                        newCharacter.getGender() + " " +
                        newCharacter.getSpecies() + " " +
                        newCharacter.getType() + " " +
                        newCharacter.getOrigin() + " " +
                        newCharacter.getEpisode()
                );
            }
        } catch (Exception e) {
            // Si ocurre algún error durante la solicitud HTTP, imprimimos el error.
            e.printStackTrace();
        }
    }
}
