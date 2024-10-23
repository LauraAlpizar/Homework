package Factory;

public class Book {
    private String title;
    private String author;
    private Boolean sold;
    private String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.sold = false;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean isSold() {
        return sold;
    }

    public void sell() {
        this.sold = true;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", sold=" + sold + ", genre='" + genre + '\'' + '}';
    }
}
