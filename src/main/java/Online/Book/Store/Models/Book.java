package Online.Book.Store.Models;

public abstract class Book {
    private String ISBN;
    private String title;
    private int PublishedYear;
    private double price;

    public Book() {
    }

    public Book(String ISBN, String title, int publishedYear, double price) {
        this.ISBN = ISBN;
        this.title = title;
        PublishedYear = publishedYear;
        this.price = price;
    }

    public abstract boolean isForSale();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        PublishedYear = publishedYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
