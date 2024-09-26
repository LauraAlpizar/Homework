import java.util.Scanner;

public class Exercises {

    public void  scanear(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        String s = sc.nextLine();
        int num = Integer.parseInt(s);  // Lee el número ingresado por el usuario
        System.out.print("El usuario ingreso: ");
        System.out.print(num);
        sc.nextLine(); // Limpia el buffer de entrada

    }

    //Solicitar numeros e imprimir con esa profundidad
    // i = 3
    //   *
    //  ***
    // *****

    public void buildPyramaid() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int num = sc.nextInt(); // Lee el número ingresado por el usuario
        sc.nextLine(); // Limpia el buffer de entrada

        System.out.println("El usuario ingresó: " + num);

        // formar piramide
        for (int i = 1; i <= num; i++) { // Iterar desde 1 hasta el número ingresado
            // Imprime los espacios en blanco antes de los asteriscos
            for (int j = 0; j < num - i; j++) {
                System.out.print(" "); // Espacios para alinear la pirámide
            }
            // Imprime los asteriscos para la fila actual
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*"); // Asteriscos que forman la pirámide
            }
            System.out.println(); // Salta a la siguiente línea después de cada fila
        }
    }


    // solisita un string
    // true or false si el string contiene al menos
    // 1 letra del abecedario

    public void checkifPangram() {
        Scanner l = new Scanner(System.in);
        System.out.print("Ingrese un string: ");
        String pal = l.nextLine();  //lee la linea completa

        boolean contieneLetra = false;
        // Se recorre el string y verifica si hay al menos una letra
        for (char c : pal.toCharArray()) {
            if (Character.isLetter(c)) { // Verifica si el carácter es una letra
                contieneLetra = true;
                break;
            }
        }

        // Imprime el resultado
        if (contieneLetra) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
