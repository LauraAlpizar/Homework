package Models.Enums;

// Definimos el enum 'Status' que representa el estado de un personaje.
public enum Status {
    Alive,   // El personaje está vivo.
    Dead,    // El personaje está muerto.
    unknown, // Estado desconocido en minúsculas (podría ser un error de la API).
    Unknown  // Estado desconocido en mayúsculas (para compatibilidad con la API, aunque parece duplicado).
}
