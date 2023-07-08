package util;

import repository.BookRepository;
import repository.IBookRepository;

import static view.Main.input;

public class CheckInput {

    static IBookRepository bookRepository = new BookRepository();
    static public int checkId() {
        try {
            System.out.print("nhap id: ");
            int id = Integer.parseInt(input.nextLine());
            if (bookRepository.searchId(id) != -1) {
                System.out.println("id da ton tai");
                return checkId();
            } else {
                return id;
            }
        } catch (Exception e) {
            System.out.println("nhap sai du lieu");
            return checkId();
        }
    }

    static public int takeChoice() {
        try {
            System.out.print("nhap chuc nang: ");
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("nhap sai du lieu");
            return takeChoice();
        }
    }

    static public String checkName() {
        final String REGEX_NAME = "^([A-Z][a-z]+ )+([A-Z][a-z]+)$";
        try {
            System.out.print("nhap ten: ");
            String name = input.nextLine();
            if (name.matches(REGEX_NAME)) {
                return name;
            } else {
                System.out.println("nhap sai ten");
                return checkName();
            }
        } catch (Exception e) {
            System.out.println("nhap sai ten");
            return checkName();
        }
    }

    static public String checkAuthor() {
        final String REGEX_NAME = "^([A-Z][a-z]+ )+([A-Z][a-z]+)$";
        try {
            System.out.print("nhap tac gia: ");
            String name = input.nextLine();
            if (name.matches(REGEX_NAME)) {
                return name;
            } else {
                System.out.println("nhap sai ten");
                return checkAuthor();
            }
        } catch (Exception e) {
            System.out.println("nhap sai ten");
            return checkAuthor();
        }
    }

    static public int checkPrice() {
        try {
            System.out.print("nhap tien: ");
            int price = Integer.parseInt(input.nextLine());
            if (price <= 0) {
                System.out.println("gia tien > 0");
                return checkPrice();
            } else {
                return price;
            }
        } catch (Exception e) {
            System.out.println("nhap sai du lieu");
            return checkPrice();
        }
    }
}
