package Online.Book.Store.Models;

import Online.Book.Store.Customs.PurchasableBook;
import Online.Book.Store.Services.MailService;

public class EBook extends Book implements Online.Book.Store.Customs.EBook, PurchasableBook {
    private String fileType;

    public EBook() {
    }

    public EBook(String ISBN, String title, int publishedYear, double price, String fileType) {
        super(ISBN, title, publishedYear, price);
        this.fileType = fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public String fileType() {
        return fileType;
    }

    @Override
    public void SentViaEmail(String email) {
        MailService.OnlineBookDelivery(this, email);
        // send to the email
    }

    @Override
    public void purchase(String email, String address, int quantity) {
        this.SentViaEmail(email);
//        System.out.println("Sending EBook " + getTitle() + " to " + email);
//        System.out.println("your Paid " + getPrice() * quantity);
    }
}
