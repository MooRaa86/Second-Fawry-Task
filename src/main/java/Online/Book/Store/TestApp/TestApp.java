package Online.Book.Store.TestApp;

import Online.Book.Store.Models.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(
                new PaperBook("111-222", "Java Core", 2021, 500, 7),
                new EBook("OD12-89", "Hibernate FrameWork", 2024, 300, "pdf"),
                new DemoBook("D112-5", "Spring Ai", 2025, 0),

                new PaperBook("PB101", "Effective Java", 2020, 450, 5),
                new PaperBook("PB102", "Clean Code", 2019, 400, 4),
                new PaperBook("PB103", "Design Patterns", 2018, 350, 6),

                new EBook("EB201", "Docker Deep Dive", 2023, 200, "wps"),
                new EBook("EB202", "Kubernetes in Action", 2024, 250, "pdf"),

                new DemoBook("DB301", "AI Overview", 2022, 0),
                new DemoBook("DB302", "Intro to DevOps", 2020, 0)
        ));

        for (Book book : books) {
            if(book instanceof PaperBook) {
                inventory.addBook(book,((PaperBook) book).getNumberInStock());
            }else{
                inventory.addBook(book,0);
            }
        }

        System.out.println("Books in Inventory : ");
        inventory.show();

        System.out.println("Outdated books : ");
        inventory.printOutDatedBooks();

        inventory.removeOutDatedBooks();
        System.out.println("Inventory after removing outdated books : ");
        inventory.show();

        System.out.println("Buying 2 Effective Java Books");
        inventory.buySingleBook("PB101", 2, "hazem@gmail.com", "Alexandria-Miami");

        System.out.println("Buying Docker Deep Dive Book");
        inventory.buySingleBook("EB201", 1, "omar123@gmail.com", "Cairo-ElTahrir");

        System.out.println("Attempting to buy a demo book ");
        inventory.buySingleBook("DB301", 1, "omar123@gmail.com", "Tanta");

        System.out.println("Trying to buy a book not in inventory");
        try {
            inventory.buySingleBook("651-615", 1, "ahmed@gmail.com", "Aswan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try {
            System.out.println("Trying to buy over copies of book");
            inventory.buySingleBook("PB101", 10, "hazem@gmail.com", "Alexandria-Miami");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        System.out.println("Inventory after buying books\n");
        inventory.show();

    }
}
