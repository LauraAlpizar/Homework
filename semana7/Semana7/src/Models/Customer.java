package Models;

// La clase 'Customer' extiende a la clase 'Person', lo que significa que hereda sus atributos y métodos.
public class Customer extends Person {
    // Atributo privado que guarda el número de cuenta del cliente.
    private String accountNumber;

    // Constructor de la clase 'Customer'.
    // Recibe el ID, nombre, apellido y número de cuenta como parámetros.
    public Customer(String id, String Firstname, String Lastname, String accountNumber) {
        // Llama al constructor de la clase base 'Person' para inicializar el nombre y apellido.
        super(Firstname, Lastname);
        // Inicializa el número de cuenta del cliente.
        this.accountNumber = accountNumber;
    }

    // Getter para obtener el número de cuenta.
    public String getAccountNumber() {
        return accountNumber; // Devuelve el número de cuenta del cliente.
    }

    // Setter para modificar el número de cuenta.
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber; // Asigna un nuevo número de cuenta al cliente.
    }
}
