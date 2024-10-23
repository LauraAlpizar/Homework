package Builder;

import Factory.Book;
import Factory.FictionBook;

public class ConcreteBookBuilder implements BookBuilder {
    private String title;
    private String author;
    private double price;
    private String genre;

    public void buildTitle(String title) {
        this.title = title;
    }

    public void buildAuthor(String author) {
        this.author = author;
    }

    public void buildPrice(double price) {
        this.price = price;
    }

    public void buildGenre(String genre) {
        this.genre = genre;
    }

    public Book getResult() {
        return new FictionBook(title, author, price, genre); // Aquí creamos un nuevo libro
    }
}
