package controller;

import service.class_service.*;
import utils.CheckValueInput;
import utils.ColorInConsole;

public class FuramaController {
    EmployeeService employeeService = new EmployeeService();
    CustomerService customerService = new CustomerService();
    FacilityService facilityService = new FacilityService();
    BookingService bookingService = new BookingService();
    ContactService contactService = new ContactService();
    PromotionService promotionService = new PromotionService();

    public void displayMainMenu() {
        do {
            System.out.println(
                    ColorInConsole.ANSI_RED
                            + "\n---------------------------------------------------"
                            + ColorInConsole.ANSI_RESET
            );
            System.out.println(
                    "----- WELCOME TO FURAMA RESORT MANAGER PROGRAM -----"
                            + ColorInConsole.ANSI_RED
            );
            System.out.println("---------------------------------------------------");
            System.out.print(ColorInConsole.ANSI_RESET);
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit\n");

            actionChoice();
            int choice = CheckValueInput.inputInt();

            switch (choice) {
                case 1 -> displayEmployeeMenu();
                case 2 -> displayCustomerMenu();
                case 3 -> displayFacilityMenu();
                case 4 -> displayBookingMenu();
                case 5 -> displayPromotionMenu();
                case 6 -> System.exit(0);
            }
        } while (true);

    }

    public void displayEmployeeMenu() {
        int choice;
        do {
            System.out.print(ColorInConsole.ANSI_GREEN);
            System.out.println("\n - 1. Display list employees");
            System.out.println(" - 2. Add new employee");
            System.out.println(" - 3. Edit employee");
            System.out.println(" - 4. Return main menu\n");
            System.out.print(ColorInConsole.ANSI_RESET);

            actionChoice();
            choice = CheckValueInput.inputInt();

            switch (choice) {
                case 1 -> employeeService.display();
                case 2 -> employeeService.addNew();
                case 3 -> employeeService.edit();
            }
        } while (choice != 4);
    }

    public void displayCustomerMenu() {
        int choice;
        do {
            System.out.print(ColorInConsole.ANSI_CYAN);
            System.out.println("\n - 1. Display list customers");
            System.out.println(" - 2. Add new customer");
            System.out.println(" - 3. Edit customer");
            System.out.println(" - 4. Return main menu\n");
            System.out.print(ColorInConsole.ANSI_RESET);

            actionChoice();
            choice = CheckValueInput.inputInt();

            switch (choice) {
                case 1 -> customerService.display();
                case 2 -> customerService.addNew();
                case 3 -> customerService.edit();
            }
        } while (choice != 4);
    }

    public void displayFacilityMenu() {
        int choice;
        do {
            System.out.print(ColorInConsole.ANSI_PURPLE);
            System.out.println("\n - 1. Display list facility");
            System.out.println(" - 2. Add new facility");
            System.out.println(" - 3. Display list facility maintenance");
            System.out.println(" - 4. Return main menu\n");
            System.out.print(ColorInConsole.ANSI_RESET);

            actionChoice();
            choice = CheckValueInput.inputInt();

            switch (choice) {
                case 1 -> facilityService.display();
                case 2 -> facilityService.addNew();
                case 3 -> facilityService.showMaintenance();
            }
        } while (choice != 4);
    }

    public void displayBookingMenu() {
        int choice;
        do {
            System.out.print(ColorInConsole.ANSI_YELLOW);
            System.out.println("\n - 1. Add new booking");
            System.out.println(" - 2. Display list booking");
            System.out.println(" - 3. Create new contracts");
            System.out.println(" - 4. Display list contracts");
            System.out.println(" - 5. Edit contracts");
            System.out.println(" - 6. Return main menu\n");
            System.out.print(ColorInConsole.ANSI_RESET);

            actionChoice();
            choice = CheckValueInput.inputInt();

            switch (choice) {
                case 1 -> bookingService.addNew();
                case 2 -> bookingService.display();
                case 3 -> contactService.addNew();
                case 4 -> contactService.display();
                case 5 -> contactService.edit();
            }
        } while (choice != 6);
    }

    public void displayPromotionMenu() {
        int choice;
        do {
            System.out.print(ColorInConsole.ANSI_BLUE);
            System.out.println("\n - 1. Display list customers use service");
            System.out.println(" - 2. Display list customers get voucher");
            System.out.println(" - 3. Display list voucher");
            System.out.println(" - 4. Return main menu\n");
            System.out.print(ColorInConsole.ANSI_RESET);

            actionChoice();
            choice = CheckValueInput.inputInt();

            switch (choice) {
                case 1 -> promotionService.customerUsed();
                case 2 -> promotionService.customerGet();
                case 3 -> promotionService.showVoucher();
            }
        } while (choice != 4);
    }

    public void actionChoice() {
        System.out.print(
                ColorInConsole.ANSI_RED
                        + " - Enter your action: "
                        + ColorInConsole.ANSI_RESET
        );
    }
}



























