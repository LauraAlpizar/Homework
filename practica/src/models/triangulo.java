package models;

public class triangulo implements Ishape {
    private int l1, l2, base, altura;  // Lados y altura del triángulo

    // Constructor para inicializar los lados y la altura
    public triangulo(int l1, int l2, int base, int altura) {
        this.l1 = l1;
        this.l2 = l2;
        this.base = base;
        this.altura = altura;
    }

    @Override
    public float calcularPerimetro() {
        return l1 + l2 + base;  // Fórmula del perímetro de un triángulo
    }

    @Override
    public float calcularArea() {
        return (float) (base * altura) / 2;  // Fórmula del área de un triángulo
    }
}
