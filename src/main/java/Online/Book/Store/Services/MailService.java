package Online.Book.Store.Services;

import Online.Book.Store.Models.EBook;

public class MailService {
    public static void OnlineBookDelivery(EBook book, String email) {
        System.out.println( book.getTitle()+ "." +book.fileType() + " Book will be sent to " +email);
        System.out.println("The Price : " + book.getPrice());
        System.out.println();
    }
}
