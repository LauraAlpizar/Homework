public class Carro {  // Definición de la clase Carro
    // Atributos privados de la clase (características del carro)
    private String marca;  // Almacena la marca del carro (Toyota)
    private String modelo;  // Almacena el modelo del carro (Corolla)
    private int año;  // Almacena el año de fabricación del carro (2022)
    private String color;  // Almacena el color del carro (Rojo)

    // Constructor de la clase. Se llama al crear un objeto de tipo Carro.
    // Inicializa los atributos del carro con valores específicos.
    public Carro(String marca, String modelo, int año, String color) {
        this.marca = marca;  // "this" se refiere al atributo de la clase
        this.modelo = modelo;
        this.año = año;
        this.color = color;
    }

    // Métodos públicos de la clase Carro (acciones que el carro puede realizar)

    // Método para arrancar el carro
    public void arrancar() {
        System.out.println("El carro ha arrancado.");  // Imprime en consola que el carro ha arrancado
    }

    // Metodo para detener el carro
    public void detener() {
        System.out.println("El carro se ha detenido.");  // Imprime en consola que el carro se ha detenido
    }

    // Metodo para acelerar el carro a una cierta velocidad
    public void acelerar(int velocidad) {
        System.out.println("El carro está acelerando a " + velocidad + " km/h.");  // Muestra la velocidad a la que acelera
    }

    // Metodo para frenar el carro
    public void frenar() {
        System.out.println("El carro está frenando.");  // Imprime que el carro está frenando
    }

    // Metodo para mostrar la información del carro (marca, modelo, año, color)
    public void mostrarInfo() {
        System.out.println("Información del carro:");  // Muestra el título de la información del carro
        System.out.println("Marca: " + marca);  // Muestra la marca
        System.out.println("Modelo: " + modelo);  // Muestra el modelo
        System.out.println("Año: " + año);  // Muestra el año de fabricación
        System.out.println("Color: " + color);  // Muestra el color
    }
}

