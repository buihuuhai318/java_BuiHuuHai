package service.class_service;

import model.booking.Contract;
import repository.class_repo.BookingRepository;
import repository.class_repo.ContactRepository;
import service.interface_service.IContactService;
import utils.CheckValueInput;

import static view.Main.input;

public class ContactService extends Service implements IContactService {

    ContactRepository contactRepository = new ContactRepository();
    BookingRepository bookingRepository = new BookingRepository();
    CheckValueInput checkValueInput = new CheckValueInput();

    @Override
    public void display() {
        contactRepository.head();
        contactRepository.display();
    }

    @Override
    public void addNew() {
        contactRepository.peekBooking();
        String idBooking = contactRepository.getPeekBooking().getBookingCode();
        System.out.print("\n - Enter deposit ");
        int depositForRent = checkValueInput.checkPrice();
        System.out.print(" - Enter total ");
        int totalForRent = checkValueInput.checkPrice();
        Contract contract = new Contract(idBooking, depositForRent, totalForRent);
        contactRepository.head();
        System.out.println(contract);
        contactRepository.addNew(contract);
    }

    public void edit() {
        display();
        System.out.print("\n - Enter ID: ");
        String idEdit = input.nextLine().toUpperCase().trim();
        int index = contactRepository.checkID(idEdit);


        if (index != -1) {
            Contract contract = contactRepository.getElement(index);

            contactRepository.head();
            System.out.println(contract);

            System.out.printf("\n| %s | %s |\n", "1. Edit Deposit", "2. Edit Total Price");


            contract = changeValueEdit(contract);

            contactRepository.edit(contract, index);
        } else {
            System.out.println("Invalid ID !!");
        }
    }

    public Contract changeValueEdit(Contract contract) {
        String idBo = contract.getBookingCode();
        int deposit = contract.getDepositForRent();
        int total = contract.getTotalForRent();

        boolean flag = true;
        do {
            int choice;
            String choiceStr;
            do {
                System.out.print("\n - Enter your property want to edit (0 : exit): ");
                choiceStr = input.nextLine();
            } while (!choiceStr.matches("^[1-2]$"));
            choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1 -> {
                    System.out.print(" - Enter Deposit ");
                    deposit = checkValueInput.checkPrice();
                }
                case 2 -> {
                    System.out.print(" - Enter Total ");
                    total = checkValueInput.checkPrice();
                }
                case 0 -> flag = false;
            }

            Contract contractHolder = new Contract(idBo, deposit, total);
            contactRepository.head();
            System.out.println(contractHolder);
            System.out.print("\n - Continue ? (yes / no) : ");
            String anwser = input.nextLine().toLowerCase().trim();
            if (anwser.equals("no")) {
                System.out.print(" - Do you want to Save ? (yes / no) : ");
                String save = input.nextLine().trim().toLowerCase();
                if (save.equals("no")) {
                    flag = false;
                } else if (save.equals("yes")) {
                    System.out.println("---------------DONE---------------");
                    return contractHolder;
                }
            } else if (anwser.equals("yes")) {
                flag = true;
            }
        } while (flag);
        System.out.println("---------------Cancel---------------");
        return contract;
    }
}
