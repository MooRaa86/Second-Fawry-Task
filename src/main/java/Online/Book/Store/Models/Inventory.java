package Online.Book.Store.Models;

import Online.Book.Store.Customs.PurchasableBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private HashMap<Book, Integer> Stock;

    private final int outdated = 5;
    private int currentYear = 2025;

    public Inventory() {
        this.Stock = new HashMap<>();
    }

    public void printOutDatedBooks() {
        HashMap<Book, Integer> outdatedBooks = new HashMap<>();
        for(Map.Entry<Book, Integer> entry : Stock.entrySet()) {
            if(currentYear - entry.getKey().getPublishedYear() > outdated) {
                outdatedBooks.put(entry.getKey(), entry.getValue());
            }
        }
        for(Map.Entry<Book, Integer> entry : outdatedBooks.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " published in " + entry.getKey().getPublishedYear());
        }
        System.out.println();
    }

    public void removeOutDatedBooks() {
        List<Book> toRemove = new ArrayList<>();
        for(Map.Entry<Book, Integer> entry : Stock.entrySet()) {
            if(currentYear - entry.getKey().getPublishedYear() > outdated) {
                toRemove.add(entry.getKey());
            }
        }
        for(Book book : toRemove) {
            Stock.remove(book);
        }
        System.out.println("Outdated Books removed\n");
    }

    public void addBook(Book book,int quantity) {
        if(book instanceof EBook || book instanceof DemoBook){
            // ebook & DemoBook doesn't need quantity
            Stock.put(book,0);
            return;
        }
        /* here I pass the quantity equal to the quantity parameter in the book class
           and the books that is not take place like (EBook & Demo Book) I set their
           quantity = 0 in the inventory to handle all types of books
         */
        Stock.put(book, Stock.getOrDefault(book, 0) +  quantity);
    }

    public void removeBookByIsbn(String isbn) {
        for(Map.Entry<Book, Integer> entry : Stock.entrySet()) {
            if(entry.getKey().getISBN().equals(isbn)) {
                Stock.remove(entry.getKey());
                return;
            }
        }
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void show(){
        for(Map.Entry<Book, Integer> entry : Stock.entrySet()) {
            if(entry.getKey() instanceof DemoBook) {
                System.out.println(entry.getKey().getTitle() + " - (DemoBook)");
            }else if(entry.getKey() instanceof EBook) {
                System.out.println(entry.getKey().getTitle() + " - (EBook)");
            }else{
                System.out.println(entry.getKey().getTitle() + " - " + entry.getValue() + " books");
            }
        }
        System.out.println();
    }
    public void buySingleBook(String isbn, int quantity,
                                     String email, String address) {
        for (Map.Entry<Book, Integer> entry : Stock.entrySet()) {
            Book book = entry.getKey();
            if (book.getISBN().equals(isbn)) {
                if ( book instanceof PaperBook  ) {
                    ((PaperBook) book).purchase(email, address, quantity);
                    int updatedQuantity = entry.getValue() - quantity;
                    ((PaperBook) book).setNumberInStock(updatedQuantity);
                    entry.setValue(updatedQuantity);
                    return;
                }else if(book instanceof EBook){
                    ((EBook) book).purchase(email, address, quantity);
                    return;
                } else {
                    System.out.println(book.getTitle()+" is not for sale\n");
                    return;
                }
            }
        }
        throw new RuntimeException("Book not found in the inventory");
    }

    public HashMap<Book, Integer> getStock() {
        return Stock;
    }
}
