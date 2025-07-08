package Online.Book.Store.Services;

import Online.Book.Store.Models.Book;

public class ShippingService {
    public static void BookDelivery(Book book ,String address,int quantity) {
        System.out.println( book.getTitle() + " Book purchased successfully and will be sent to: " + address);
        System.out.println("The Price: " + book.getPrice() * quantity);
        System.out.println();
    }
}
