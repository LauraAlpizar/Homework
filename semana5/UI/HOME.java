package UI; // Define el paquete en el que se encuentra la clase, en este caso, "UI".

import javax.swing.*; // Importa todas las clases del paquete javax.swing, necesarias para crear interfaces gráficas en Java.
import java.awt.event.ActionEvent; // Importa la clase ActionEvent, que representa eventos de acción generados por componentes como botones.
import java.awt.event.ActionListener; // Importa la interfaz ActionListener, que se usa para recibir eventos de acción.

public class HOME extends JFrame {
    // Declaración de todos los componentes GUI que están presentes en el archivo .form.
    // Estos deben coincidir con los componentes definidos en el archivo .form para que funcione correctamente la vinculación.

    private JPanel panel1; // JPanel principal que contiene otros componentes. Es el contentPane del JFrame.
    private JTextField textField1; // Campo de texto para entrada de datos. Permite al usuario ingresar información.
    private JButton Button; // Botón para realizar alguna acción cuando se hace clic.
    private JTextField textField; // Otro campo de texto, posiblemente para una segunda entrada de datos.
    private JLabel label1; // Etiqueta para mostrar texto o mensajes en la interfaz.
    private JButton botton; // Otro botón adicional, aunque el nombre parece un error tipográfico (debería ser "button").
    private JPanel mainPanel; // Panel principal que contiene todos los componentes. Puede no ser necesario si panel1 se usa como contentPane.
    private JLabel label2; // Otra etiqueta para mostrar mensajes en la interfaz.

    // Constructor de la clase HOME. Se ejecuta cuando se crea una nueva instancia de HOME.
    public HOME() {
        // El metodo setContentPane establece el panel principal del JFrame, que contendrá todos los demás componentes.
        setContentPane(panel1); // Asigna el panel1 como el contentPane del JFrame. Esto asegura que panel1 se muestre en la ventana.

        setTitle("Clase POO 1"); // Establece el título de la ventana.
        setSize(500, 500); // Define el tamaño de la ventana a 500x500 píxeles.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establece la acción predeterminada al cerrar la ventana, que es salir de la aplicación.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        setVisible(true); // Hace que la ventana sea visible.

        // Llama al metodo reasignarLabel para agregar funcionalidad a los componentes.
        reasignarLabel();
    }

    // Metodo para configurar la acción de un botón.
    public void reasignarLabel() {
        // Agrega un ActionListener (escuchador de acciones) al botón "Button".
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a ejecutar cuando se hace clic en el botón.
                // Obtiene el texto ingresado en el campo de texto "textField".
                String texto = textField.getText();

                // Establece el texto ingresado en la etiqueta "label1".
                label1.setText(texto);

                // Cambia el texto de "label2" para incluir el texto ingresado.
                label2.setText("Se reasignó el label con el texto: " + texto);
            }
        });
    }

    // Metodo principal que inicia la aplicación.
    public static void main(String[] args) {
        // Crea una nueva instancia de la clase HOME, mostrando la ventana.
        new HOME();
    }
}
