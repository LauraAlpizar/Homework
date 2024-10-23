package Factory;

public class FictionBook extends Book {
    private double price;

    public FictionBook(String title, String author, double price, String genre) {
        super(title, author, genre);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FictionBook{" + "title='" + getTitle() + '\'' + ", author='" + getAuthor() + '\'' + ", price=" + price + ", sold=" + isSold() + ", genre='" + getGenre() + '\'' + '}';
    }
}
