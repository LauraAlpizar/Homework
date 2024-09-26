package models;

public class cuadrado implements Ishape {
    private int lado;  // Un solo lado del cuadrado

    // Constructor para inicializar el lado
    public cuadrado(int lado) {
        this.lado = lado;
    }

    @Override
    public float calcularPerimetro() {
        return 4 * lado;  // El perímetro de un cuadrado es 4 veces el lado
    }

    @Override
    public float calcularArea() {
        return lado * lado;  // El área de un cuadrado es lado * lado
    }
}
