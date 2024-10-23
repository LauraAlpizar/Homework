import models.carro;
import models.camion;

public class Main {
    public static void main(String[] args) {
        // Creación de un objeto Carro
        carro carro1 = new carro("1", "Toyota");
        carro1.encendervehiculo();  // Encender el carro
        carro1.mostrarInfo();       // Mostrar información del carro

        // Creación de un objeto Camion
        camion camion1 = new camion();
        camion1.encendervehiculo();  // Encender el camión
    }
}
