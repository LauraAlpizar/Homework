import Factory.BookFactory;
import Factory.Book;
import Builder.ConcreteBookBuilder;

import java.util.ArrayList;
import java.util.List;

//Laura Alpizar and Josias Fernandez

public class Main {
    public static void main(String[] args) {
        // Crear una lista de libros
        List<Book> bookList = new ArrayList<>();

        // Uso de Factory para crear libros
        bookList.add(BookFactory.createBook("Fiction", "The Great Gatsby", "F. Scott Fitzgerald", 10.99));
        bookList.add(BookFactory.createBook("Fiction", "Sapiens", "Yuval Noah Harari", 14.99));

        // Uso de Builder para crear libros automáticamente
        createBookAutomatically(bookList, "1984", "George Orwell", 12.99, "Horror");
        createBookAutomatically(bookList, "Pride and Prejudice", "Jane Austen", 8.99, "Romantic");
        createBookAutomatically(bookList, "The Shining", "Stephen King", 15.50, "Horror");

        // Mostrar libros disponibles
        System.out.println("Available books:");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + 1 + ". " + bookList.get(i));
        }

        // Simulación de selección de libros para comprar
        for (int i = 0; i < bookList.size(); i++) {
            simulateBookPurchase(bookList, i + 1); // Comprar cada libro automáticamente
        }
    }

    private static void createBookAutomatically(List<Book> bookList, String title, String author, double price, String genre) {
        ConcreteBookBuilder builder = new ConcreteBookBuilder();
        builder.buildTitle(title);
        builder.buildAuthor(author);
        builder.buildPrice(price);
        builder.buildGenre(genre);
        Book builtBook = builder.getResult();
        bookList.add(builtBook);
    }

    private static void simulateBookPurchase(List<Book> bookList, int choice) {
        if (choice >= 1 && choice <= bookList.size()) {
            Book selectedBook = bookList.get(choice - 1);
            if (!selectedBook.isSold()) {
                selectedBook.sell(); // Marcar como vendido
                System.out.println("You purchased: " + selectedBook);
            } else {
                System.out.println("Sorry, this book is already sold.");
            }
        } else {
            System.out.println("Invalid selection.");
        }
    }
}
