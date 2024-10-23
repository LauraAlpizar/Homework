package Models;

// La clase 'Employee' extiende a la clase 'Person', heredando sus atributos y métodos.
public class Employee extends Person {
    // Atributo privado que guarda el salario del empleado.
    private int salary;

    // Constructor de la clase 'Employee'.
    // Recibe el ID, nombre, apellido y salario como parámetros.
    public Employee(String id, String Firstname, String Lastname, int salary) {
        // Llama al constructor de la clase base 'Person' para inicializar el nombre y apellido.
        super(Firstname, Lastname);
        // Inicializa el salario del empleado.
        this.salary = salary;
    }

    // Getter para obtener el salario.
    public int getSalary() {
        return salary; // Devuelve el salario del empleado.
    }

    // Setter para modificar el salario.
    public void setSalary(int salary) {
        this.salary = salary; // Asigna un nuevo salario al empleado.
    }
}
