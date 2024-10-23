package ui;

import Models.Customer;  // Importa la clase Customer desde el paquete Models.
import Models.Employee;  // Importa la clase Employee desde el paquete Models.

import javax.swing.*;  // Importa todas las clases necesarias para la interfaz gráfica.
import javax.swing.table.DefaultTableModel;  // Para crear modelos de tabla.
import java.awt.event.ActionEvent;  // Para manejar eventos de botones.
import java.awt.event.ActionListener;  // Para la escucha de eventos de acciones.
import java.util.ArrayList;  // Para manejar listas dinámicas.

public class Form extends JFrame {  // La clase 'Form' extiende JFrame para representar una ventana gráfica.
    // Componentes de la interfaz gráfica.
    private JPanel homePanel;  // Panel principal que contiene los elementos de la ventana.
    private JTable employeesTbl;  // Tabla para mostrar los empleados.
    private JTextField salary;  // Campo de texto para ingresar el salario.
    private JTextField firstname;  // Campo de texto para ingresar el nombre del empleado.
    private JTextField lastname;  // Campo de texto para ingresar el apellido del empleado.
    private JButton createButton;  // Botón para crear un nuevo empleado.
    private JTabbedPane tabbedPane1;  // Panel con pestañas para cambiar entre vistas.
    private JTable table1;  // Tabla para mostrar los clientes.
    private JTextField textField1;  // Campo de texto para ingresar el nombre del cliente.
    private JTextField textField2;  // Campo de texto para ingresar el apellido del cliente.
    private JTextField textField3;  // Campo de texto para ingresar el número de cuenta del cliente.
    private JButton createButton1;  // Botón para crear un nuevo cliente.

    // Listas dinámicas para almacenar empleados y clientes.
    private ArrayList<Employee> employees = new ArrayList<>();  // Lista de empleados.
    private ArrayList<Customer> customers = new ArrayList<>();  // Lista de clientes.

    // Constructor de la clase 'Form'.
    public Form() {
        loadEmployeesTable();  // Carga los empleados en la tabla al inicio.
        loadCustomers();  // Carga los clientes en la tabla al inicio.
        setContentPane(homePanel);  // Establece el panel principal como el contenido de la ventana.
        setLocationRelativeTo(null);  // Centra la ventana en la pantalla.
        setSize(800, 600);  // Establece el tamaño de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configura la acción de cierre.
        setTitle("Bank POO");  // Título de la ventana.
        setVisible(true);  // Hace visible la ventana.

        // Acción del botón para crear un nuevo empleado.
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agrega un nuevo empleado a la lista usando los datos de los campos de texto.
                employees.add(new Employee(
                        "",  // El ID se genera por defecto.
                        firstname.getText(),  // Obtiene el nombre del campo de texto.
                        lastname.getText(),  // Obtiene el apellido del campo de texto.
                        Integer.parseInt(salary.getText())  // Convierte el salario a entero.
                ));
                // Limpia los campos de texto después de crear el empleado.
                firstname.setText("");
                lastname.setText("");
                salary.setText("");
                // Actualiza la tabla de empleados.
                loadEmployeesTable();
            }
        });

        // Acción del botón para crear un nuevo cliente.
        createButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agrega un nuevo cliente a la lista usando los datos de los campos de texto.
                customers.add(new Customer(
                        "",  // El ID se genera por defecto.
                        textField1.getText(),  // Obtiene el nombre del cliente.
                        textField2.getText(),  // Obtiene el apellido del cliente.
                        textField3.getText()  // Obtiene el número de cuenta.
                ));
                // Limpia los campos de texto después de crear el cliente.
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                // Actualiza la tabla de clientes.
                loadCustomers();
            }
        });
    }

    // Método para cargar los clientes en la tabla.
    public void loadCustomers() {
        String[] columns = {"ID", "First Name", "Last Name", "Account number"};  // Define las columnas de la tabla.
        Object[][] data = new Object[customers.size()][columns.length];  // Crea una matriz de datos para la tabla.
        for (int i = 0; i < customers.size(); i++) {  // Llena la matriz con los datos de los clientes.
            data[i][0] = customers.get(i).getId();  // ID del cliente.
            data[i][1] = customers.get(i).getFirstname();  // Nombre del cliente.
            data[i][2] = customers.get(i).getLastname();  // Apellido del cliente.
            data[i][3] = customers.get(i).getAccountNumber();  // Número de cuenta.
        }
        // Actualiza la tabla con los nuevos datos.
        table1.setModel(
                new DefaultTableModel(
                        data,  // Datos de la tabla.
                        columns  // Columnas de la tabla.
                ));
    }

    // Método para cargar los empleados en la tabla.
    public void loadEmployeesTable() {
        String[] columns = {"ID", "First Name", "Last Name", "Salary"};  // Define las columnas de la tabla.
        Object[][] data = new Object[employees.size()][columns.length];  // Crea una matriz de datos para la tabla.
        for (int i = 0; i < employees.size(); i++) {  // Llena la matriz con los datos de los empleados.
            data[i][0] = employees.get(i).getId();  // ID del empleado.
            data[i][1] = employees.get(i).getFirstname();  // Nombre del empleado.
            data[i][2] = employees.get(i).getLastname();  // Apellido del empleado.
            data[i][3] = employees.get(i).getSalary();  // Salario del empleado.
        }
        // Actualiza la tabla con los nuevos datos.
        employeesTbl.setModel(
                new DefaultTableModel(
                        data,  // Datos de la tabla.
                        columns  // Columnas de la tabla.
                ));
    }
}
