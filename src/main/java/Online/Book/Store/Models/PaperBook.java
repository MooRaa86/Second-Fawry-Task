package Online.Book.Store.Models;

import Online.Book.Store.Customs.PurchasableBook;
import Online.Book.Store.Services.ShippingService;

public class PaperBook extends Book implements Online.Book.Store.Customs.PaperBook, PurchasableBook {
    private int NumberInStock;

    public PaperBook() {
    }

    public PaperBook(String ISBN, String title, int publishedYear, double price, int numberInStock) {
        super(ISBN, title, publishedYear, price);
        NumberInStock = numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        NumberInStock = numberInStock;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public int getNumberInStock() {
        return NumberInStock;
    }

    @Override
    public void Shipping(String Address,int quantity) {
        //Shipping process
        ShippingService.BookDelivery(this,Address,quantity);
    }

    @Override
    public void purchase(String email, String address, int quantity) {
        if (NumberInStock < quantity) {
            throw new RuntimeException(this.getTitle() + " is Not enough in the stock");
        }
        this.Shipping(address, quantity);
        NumberInStock -= quantity;

//        System.out.println("Shipping " + getTitle()+" Book to " + address);
//        System.out.println("your Paid : " + getPrice() * quantity);
    }
}
