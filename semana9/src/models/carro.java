package models;

public class carro implements Ivehiculo {
    private String id;
    private String marca;

    // Constructor para inicializar el carro con id y marca
    public carro(String id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    // Metodo para encender el vehículo, implementado desde la interfaz Ivehiculo
    @Override
    public void encendervehiculo() {
        System.out.println("El carro " + marca + " con ID " + id + " ha sido encendido.");
    }

    // Metodo adicional para mostrar información del carro
    public void mostrarInfo() {
        System.out.println("Carro ID: " + id + ", Marca: " + marca);
    }
}
