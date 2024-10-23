import Models.Animal;
import Models.Person;
import Models.Vehicle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario un comando
        System.out.println("Introduce un comando (ejemplo: Animal.makeSound, Vehicle.showBrand Ford, Animal.get species):");
        String command = scanner.nextLine().trim();

        // Separar la clase, el metodo y los posibles parametros
        String[] commandParts = command.split("\\.");
        if (commandParts.length < 2) {
            System.out.println("Comando inválido. Asegúrate de seguir el formato: Clase.Metodo [parametros]");
            return;
        }

        String className = commandParts[0]; // Nombre de la clase
        String methodOrFieldName = commandParts[1].split(" ")[0]; // Nombre del metodo o campo
        String[] parameters = commandParts[1].contains(" ") ? commandParts[1].split(" ")[1].split(",") : new String[0];

        try {
            // Obtener la clase
            Class<?> clazz = Class.forName("Models." + className);
            Object instance = null;

            // Crear instancias de las clases correspondientes
            if (className.equals("Person")) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
                instance = constructor.newInstance("Laura", 18);
            } else if (className.equals("Animal")) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
                instance = constructor.newInstance("Lion", 5); // Especie y edad
            } else if (className.equals("Vehicle")) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, String.class);
                instance = constructor.newInstance("Car", "Toyota"); // Tipo y marca
            } else {
                System.out.println("Clase no soportada.");
                return;
            }

            // Comprobación si el comando es para obtener el valor de un atributo
            if (methodOrFieldName.equals("get")) {
                if (parameters.length == 1) {
                    String fieldName = parameters[0]; // Nombre del campo
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Permitir el acceso a campos privados
                    Object value = field.get(instance);
                    System.out.println("Valor de " + fieldName + ": " + value);
                } else {
                    System.out.println("Comando inválido para obtener campo.");
                }
            } else {

                Method method = clazz.getDeclaredMethod(methodOrFieldName, getParameterTypes(parameters));
                method.setAccessible(true); // Permitir el acceso a métodos privados


                if (method.getParameterCount() == 0) {
                    method.invoke(instance); // Sin parámetros
                } else {
                    method.invoke(instance, (Object[]) parameters); // Con parámetros
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener tipos de parámetros de una cadena
    private static Class<?>[] getParameterTypes(String[] parameters) {
        Class<?>[] paramTypes = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            paramTypes[i] = String.class; // Asumimos que todos los parametros son de tipo String
        }
        return paramTypes;
    }
}



/*public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> PersonClass = Class.forName("Models.Person");
        Constructor<?> constructor = PersonClass.getDeclaredConstructor(String.class).newInstance("Laura", 18);

        Object person = constructor.newInstance();



        Person myPerson = new Person("Laura", 18);
         Field[] myPersonFields = myPerson.getClass().getDeclaredFields();
         //System.out.println(myPersonFields);
         for (Field myPersonField : myPersonFields) {
         System.out.println(myPersonField.getName());
         if (myPersonField.getName().equals("age")){
         myPersonField.setAccessible(true);
         System.out.println(myPersonField.get(myPerson));
         }
         }
         Method[] myPersonMethods = myPerson.getClass().getDeclaredMethods();
         for (Method myPersonMethod : myPersonMethods){
         System.out.println(myPersonMethod.getName());
         myPersonMethod.setAccessible(true);
         myPersonMethod.invoke(myPerson);
         }
         Method greetOtherPersonMethod = myPerson.getClass().getDeclaredMethod( "greetOtherPerson", String.class );
         greetOtherPersonMethod.setAccessible(true);
         greetOtherPersonMethod.invoke(null, "Laura");
         }
 }**/