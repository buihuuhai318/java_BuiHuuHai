package controller;

import service.BookService;
import service.IBookService;
import util.CheckInput;

import static view.Main.input;

public class BookController {

    IBookService bookService = new BookService();
    public void displayMenu() {
        do {
            System.out.println("1. danh sach \n" +
                    "2. them moi \n" +
                    "3. sap xep tang dan \n" +
                    "4. sap xep giam dan \n" +
                    "5. thoat \n ");
            int choice = CheckInput.takeChoice();
            switch (choice) {
                case 1 -> bookService.display();
                case 2 -> bookService.addNew();
                case 3 -> bookService.sortByPriceFromCheap();
                case 4 -> bookService.sortByPriceFromExpensive();
                case 5 -> System.exit(0);
                default -> System.out.println("nhap sai chuc nang");
            }
        } while (true);
    }


}
