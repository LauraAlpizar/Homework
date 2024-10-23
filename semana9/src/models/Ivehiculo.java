package models;

public interface Ivehiculo {
    // Metodo para apagar el vehículo
    default void apagarvehiculo() {
        System.out.println("El vehículo se ha apagado.");
    }

    // Metodo para encender el vehículo (obligatorio de implementar)
    void encendervehiculo();
}
