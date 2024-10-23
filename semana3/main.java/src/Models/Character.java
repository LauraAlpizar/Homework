package Models;

import Models.Enums.Gender;
import Models.Enums.Status;

// La clase 'Character' representa un personaje con múltiples atributos.
public class Character {
    // Atributos privados del personaje
    private int id;          // El ID único del personaje.
    private String name;     // El nombre del personaje.
    private Status status;   // El estado del personaje (Alive, Dead, Unknown).
    private Gender gender;   // El género del personaje (Male, Female, etc.).
    private String species;  // La especie del personaje (Humano, Alien, etc.).
    private String type;     // El tipo del personaje (vacío si no aplica).
    private String origin;   // El lugar de origen del personaje.
    private String[] episode; // Lista de URLs de episodios en los que aparece.

    // Constructor de la clase Character. Recibe todos los atributos como parámetros.
    public Character(int id, String name, Status status, Gender gender, String species, String type, String origin, String[] episode) {
        this.id = id;                 // Inicializa el ID del personaje.
        this.name = name;             // Inicializa el nombre del personaje.
        this.status = status;         // Inicializa el estado del personaje.
        this.gender = gender;         // Inicializa el género del personaje.
        this.species = species;       // Inicializa la especie del personaje.
        this.type = type;             // Inicializa el tipo del personaje.
        this.origin = origin;         // Inicializa el lugar de origen del personaje.
        this.episode = episode;       // Inicializa la lista de episodios en los que aparece.
    }

    // Métodos getters y setters para cada atributo.

    public int getId() {
        return this.id;  // Devuelve el ID del personaje.
    }

    public void setId(int id) {
        this.id = id;    // Modifica el ID del personaje.
    }

    public String getName() {
        return this.name; // Devuelve el nombre del personaje.
    }

    public void setName(String name) {
        this.name = name; // Modifica el nombre del personaje.
    }

    public Status getStatus() {
        return this.status; // Devuelve el estado del personaje.
    }

    public void setStatus(Status status) {
        this.status = status; // Modifica el estado del personaje.
    }

    public Gender getGender() {
        return this.gender; // Devuelve el género del personaje.
    }

    public void setGender(Gender gender) {
        this.gender = gender; // Modifica el género del personaje.
    }

    public String getSpecies() {
        return this.species; // Devuelve la especie del personaje.
    }

    public void setSpecies(String species) {
        this.species = species; // Modifica la especie del personaje.
    }

    public String getType() {
        return this.type; // Devuelve el tipo del personaje.
    }

    public void setType(String type) {
        this.type = type; // Modifica el tipo del personaje.
    }

    public String getOrigin() {
        return this.origin; // Devuelve el origen del personaje.
    }

    public void setOrigin(String origin) {
        this.origin = origin; // Modifica el origen del personaje.
    }

    public String[] getEpisode() {
        return this.episode; // Devuelve la lista de episodios del personaje.
    }

    public void setEpisode(String[] episode) {
        this.episode = episode; // Modifica la lista de episodios del personaje.
    }
}
