package Online.Book.Store.Customs;

public interface PurchasableBook {
    void purchase(String email, String address, int quantity);
}
