import Models.Customer;  // Importa la clase Customer desde el paquete Models.
import Models.Employee;  // Importa la clase Employee desde el paquete Models.
import ui.Form;  // Importa la clase Form desde el paquete ui para la interfaz gráfica.

public class Main {
    public static void main(String[] args) {
        new Form();  // Crea una nueva instancia de la clase Form, lo que abre la interfaz gráfica.

        // Crea un nuevo objeto Employee (Empleado) con los valores especificados.
        Employee newEmployee = new Employee("028", "Laura", "Alpizar", 1000000);

        // Crea un nuevo objeto Customer (Cliente) con los valores especificados.
        Customer newCustomer = new Customer("208", "Juan", "Alpizar", "2");

        // Imprime el nombre y el salario del empleado creado.
        System.out.println(newEmployee.getFirstname() + " " + newEmployee.getSalary());

        // Imprime el nombre y el número de cuenta del cliente creado.
        System.out.println(newCustomer.getFirstname() + " " + newCustomer.getAccountNumber());
    }
}
