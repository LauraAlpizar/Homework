package Models;

import java.util.UUID; // Importa la clase UUID para generar identificadores únicos.

// La clase 'Person' representa una persona con un identificador único, nombre y apellido.
public class Person {
    // Atributos privados de la clase 'Person'.
    private String id;        // Identificador único para cada persona.
    private String Firstname; // Nombre de la persona.
    private String Lastname;  // Apellido de la persona.

    // Constructor de la clase 'Person'.
    // Recibe como parámetros el nombre y apellido de la persona.
    public Person(String Firstname, String Lastname) {
        // Genera un ID único aleatorio usando UUID.
        this.id = UUID.randomUUID().toString();
        // Inicializa el nombre y apellido de la persona.
        this.Firstname = Firstname;
        this.Lastname = Lastname;
    }

    // Getter para obtener el ID de la persona.
    public String getId() {
        return id; // Devuelve el identificador único de la persona.
    }

    // Setter para modificar el ID de la persona (aunque en la mayoría de casos no es necesario modificar el ID).
    public void setId(String id) {
        this.id = id; // Asigna un nuevo ID a la persona.
    }

    // Getter para obtener el nombre de la persona.
    public String getFirstname() {
        return Firstname; // Devuelve el nombre de la persona.
    }

    // Setter para modificar el nombre de la persona.
    public void setFirstname(String firstname) {
        Firstname = firstname; // Modifica el nombre de la persona.
    }

    // Getter para obtener el apellido de la persona.
    public String getLastname() {
        return Lastname; // Devuelve el apellido de la persona.
    }

    // Setter para modificar el apellido de la persona.
    public void setLastname(String lastname) {
        Lastname = lastname; // Modifica el apellido de la persona.
    }
}
