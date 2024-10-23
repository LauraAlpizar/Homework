package models;

import java.util.UUID;

public class Todo {
    //clic derecho generate, getter and setter y selecciona
    private UUID id; // Identificador único de cada tarea
    private String title; // El titulo de la tarea
    private boolean completed; // Estado de la tarea (completada o no)

    // Constructor que permite crear un objeto. Si no se proporciona un id, se genera uno automaticamente.
    public Todo(String id, String title, boolean completed) {
        this.id = id.isEmpty() ? UUID.randomUUID() : UUID.fromString(id); // Si el id está vacío, genera un UUID aleatorio
        this.title = title; // Asigna el titulo
        this.completed = completed; // Asigna el estado de completado
    }
    public UUID getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public boolean isCompleted() {
        return completed;
    }
}
