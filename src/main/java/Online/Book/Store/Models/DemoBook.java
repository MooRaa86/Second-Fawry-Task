package Online.Book.Store.Models;

public class DemoBook extends Book {
    public DemoBook() {
    }

    public DemoBook(String ISBN, String title, int publishedYear, double price) {
        super(ISBN, title, publishedYear, price);
    }

    @Override
    public boolean isForSale() {
        return false;
    }
}
