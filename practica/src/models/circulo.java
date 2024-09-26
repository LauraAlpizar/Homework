package models;

public class circulo implements Ishape {
    private int rad;  // Radio del círculo

    // Constructor para inicializar el radio
    public circulo(int rad) {
        this.rad = rad;
    }

    @Override
    public float calcularPerimetro() {
        return (float) (2 * Math.PI * rad);  // Fórmula del perímetro del círculo
    }

    @Override
    public float calcularArea() {
        return (float) (Math.PI * rad * rad);  // Fórmula del área del círculo
    }
}
