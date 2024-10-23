package Builder;

import Factory.Book;

public interface BookBuilder {
    void buildTitle(String title);
    void buildAuthor(String author);
    void buildPrice(double price);
    void buildGenre(String genre); // Modificado para incluir género
    Book getResult();
}
