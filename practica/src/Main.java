import models.circulo;
import models.cuadrado;
import models.triangulo;

//semana 9 

public class Main {
    public static void main(String[] args) {
        // Creación de objetos con constructores correctos
        cuadrado cuadrado1 = new cuadrado(2);  // Un cuadrado con lado 2
        triangulo triangulo1 = new triangulo(5, 5, 3, 3);  // Un triángulo con lados 5, base 3 y altura 3
        circulo circulo1 = new circulo(2);  // Un círculo con radio 2

        // Mostrar resultados de perímetro y área de cada figura
        System.out.println("Cuadrado - Perímetro: " + cuadrado1.calcularPerimetro());
        System.out.println("Cuadrado - Área: " + cuadrado1.calcularArea());

        System.out.println("Triángulo - Perímetro: " + triangulo1.calcularPerimetro());
        System.out.println("Triángulo - Área: " + triangulo1.calcularArea());

        System.out.println("Círculo - Perímetro: " + circulo1.calcularPerimetro());
        System.out.println("Círculo - Área: " + circulo1.calcularArea());
    }
}
