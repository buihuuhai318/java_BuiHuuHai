package service.class_service;

import model.person.Customer;
import repository.class_repo.CustomerRepository;
import service.interface_service.ICustomerService;
import service.interface_service.IService;
import utils.CheckValueInput;

import static view.Main.input;

public class CustomerService implements ICustomerService, IService {
    CustomerRepository customerRepository = new CustomerRepository();
    CheckValueInput checkValueInput = new CheckValueInput();

    @Override
    public void display() {
        customerRepository.formHead();
        customerRepository.display();
    }

    @Override
    public void addNew() {
        try {
            System.out.println("---------- Add New Customer ----------");
            System.out.print("Enter ID ");
            String id = checkValueInput.checkIdCustomer();
            System.out.print("Enter Name ");
            String name = checkValueInput.checkName();
            System.out.print("Enter Brithday ");
            String date = checkValueInput.checkBirthday();
            System.out.print("Enter Gender:  ");
            boolean gender = checkValueInput.checkGender();
            System.out.print("Enter Identity Id ");
            String identityId = checkValueInput.checkIdentityId();
            System.out.print("Enter Telephone Number ");
            String phone = checkValueInput.checkPhoneNumber();
            System.out.print("Enter Type Of Member ");
            int member = checkValueInput.checkMember();
            System.out.print("Enter Email ");
            String email = checkValueInput.checkEmail();
            System.out.print("Enter Address: ");
            String address = input.nextLine();

            Customer customer = new Customer(id, name, date, gender, identityId, phone, email, member, address);
            customerRepository.addNew(customer);
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
        }
    }

    @Override
    public void edit() {
        try {
            System.out.print("Enter ID: ");
            String idEdit = input.nextLine().toUpperCase().trim();
            int index = customerRepository.checkID(idEdit);


            if (index != -1) {
                Customer customer = customerRepository.getElement(index);

                customerRepository.formHead();
                System.out.println(customer);

                System.out.printf("\n| %-13s | %-14s | %-17s | %-22s | %-12s |\n", "1. Edit ID", "2. Edit Name", "3. Edit Birthday", "4. Edit Identity Id", " 5. Edit Gender");
                System.out.printf("| %-13s | %-14s | %-17s | %-22s |\n", "6. Edit Email", "7. Edit Member", "8. Edit Address", "9. Edit Phone Number");

                customer = changeValueEdit(customer);

                customerRepository.edit(index, customer);
            } else {
                System.out.println("Invalid ID !!");
            }
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
        }
    }

    @Override
    public Customer changeValueEdit(Customer customer) {
        try {
            String id = customer.getId();
            String name = customer.getName();
            String date = customer.getDateOfBirth();
            boolean gender = customer.isGender();
            String identityId = customer.getIdentityId();
            String phone = customer.getTelephone();
            String email = customer.getEmail();
            String address = customer.getAddress();
            int member = customer.getTypeOfCustomer();

            boolean flag = true;
            do {
                int choice;
                String choiceStr;
                do {
                    System.out.print("\n - Enter your property want to edit (0 : exit): ");
                    choiceStr = input.nextLine();
                } while (!choiceStr.matches("^[1-9]$"));
                choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID ");
                        id = checkValueInput.checkIdCustomer();
                    }
                    case 2 -> {
                        System.out.print("Enter Name ");
                        name = checkValueInput.checkName();
                    }
                    case 3 -> {
                        System.out.print("Enter Brithday ");
                        date = checkValueInput.checkBirthday();
                    }
                    case 4 -> {
                        System.out.print("Enter Identity Id ");
                        identityId = checkValueInput.checkIdentityId();
                    }
                    case 5 -> {
                        System.out.print("Enter Gender:  ");
                        gender = checkValueInput.checkGender();
                    }
                    case 6 -> {
                        System.out.print("Enter Email: ");
                        email = checkValueInput.checkEmail();
                    }
                    case 7 -> {
                        System.out.print("Enter Member ");
                        member = checkValueInput.checkMember();
                    }
                    case 8 -> {
                        System.out.print("Enter address ");
                        address = input.nextLine();
                    }
                    case 9 -> {
                        System.out.print("Enter Telephone Number ");
                        phone = checkValueInput.checkPhoneNumber();
                    }
                    case 0 -> flag = false;
                }

                Customer customerHolder = new Customer(id, name, date, gender, identityId, phone, email, member, address);
                customerRepository.formHead();
                System.out.println(customerHolder);
                System.out.print("\n - continue ? (yes / no) : ");
                String anwser = input.nextLine().toLowerCase().trim();
                if (anwser.equals("no")) {
                    System.out.print(" - Do you want to Save ? (yes / no) : ");
                    String save = input.nextLine().trim().toLowerCase();
                    if (save.equals("no")) {
                        flag = false;
                    } else if (save.equals("yes")) {
                        System.out.println("---------------DONE---------------");
                        return customerHolder;
                    }
                } else if (anwser.equals("yes")) {
                    flag = true;
                }
            } while (flag);
            System.out.println("---------------cancel---------------");
            return customer;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return customer;
        }
    }
}
