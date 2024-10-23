package Factory;

public class BookFactory {
    public static Book createBook(String type, String title, String author, double price) {
        if (type.equalsIgnoreCase("Fiction")) {
            return new FictionBook(title, author, price, "Fiction"); // Asumiendo que todos los libros son de ficción por ahora
        }
        // Puedes añadir más condiciones para otros tipos de libros si es necesario
        throw new IllegalArgumentException("Unknown book type");
    }
}