public class Main {  // Definición de la clase principal donde se ejecuta el programa

    public static void main(String[] args) {  // Metodo principal, el punto de entrada del programa

        // Crear una instancia de la clase Carro (un objeto llamado miCarro)
        // Se le pasan los valores iniciales: marca, modelo, año y color
        Carro miCarro = new Carro("Toyota", "Corolla", 2022, "Rojo");

        // Llamar a los métodos de la clase Carro sobre el objeto miCarro

        miCarro.arrancar();  // Llama al metodo arrancar, que imprime que el carro ha arrancado
        miCarro.acelerar(80);  // Llama al metodo acelerar con una velocidad de 80 km/h
        miCarro.frenar();  // Llama al metodo frenar, que imprime que el carro está frenando
        miCarro.detener();  // Llama al metodo detener, que imprime que el carro se ha detenido
        miCarro.mostrarInfo();  // Llama al metodo mostrarInfo, que imprime toda la información del carro
    }
}
