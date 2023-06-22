package service.class_service;

import model.person.Employee;
import repository.class_repo.EmployeeRepository;
import service.interface_service.IEmployeeService;
import service.interface_service.IService;
import utils.CheckValueInput;

import static view.Main.input;

public class EmployeeService implements IEmployeeService, IService {

    EmployeeRepository repository = new EmployeeRepository();
    CheckValueInput checkValueInput = new CheckValueInput();

    @Override
    public void display() {
        formHead();
        repository.display();
        System.out.println();
    }

    public void formHead() {
        System.out.printf(
                "\n| %8s | %20s | %8s | %13s | %10s | %11s | %14s | %8s | %11s | %20s |\n",
                "---ID---", "--------Name--------", "-Gender-", "-Identity Id-", "-Birthday-", "---Phone---", "---Position---", "-Salary-", "---Level---", "-------Email-------");
    }

    @Override
    public void addNew() {
        try {
            System.out.println("---------- Add New Employee ----------");
            System.out.print("Enter ID ");
            String id = checkValueInput.checkIdEmployee();
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
            System.out.print("Enter Email: ");
            String email = checkValueInput.checkEmail();
            System.out.print("Enter Level: ");
            int level = checkValueInput.checkLevel();
            System.out.print("Enter Position: ");
            int position = checkValueInput.checkPosition();
            System.out.print("Enter Salary ");
            int salary = checkValueInput.checkSalary();
            Employee employee = new Employee(id, name, date, gender, identityId, phone, email, level, position, salary);
            repository.addNew(employee);
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
        }
    }

    @Override
    public void edit() {
        try {
            System.out.print("Enter ID: ");
            String idEdit = input.nextLine().toUpperCase().trim();
            int index = repository.checkID(idEdit);

            if (index != -1) {
                Employee employee = repository.getElement(index);

                formHead();
                System.out.println(employee);

                System.out.printf("\n| %-13s | %-14s | %-17s | %-15s | %-22s |\n", "1. Edit ID", "2. Edit Name", "3. Edit Birthday", "4. Edit Gender", " 5. Edit Identity Id");
                System.out.printf("| %-13s | %-14s | %-17s | %-15s | %-22s |\n", "6. Edit Email", "7. Edit Level", "8. Edit Position", "9. Edit Salary", "10. Edit Phone Number");

                employee = changeValueEdit(employee);

                repository.edit(index, employee);
            } else {
                System.out.println("Invalid ID !!");
            }
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
        }
    }

    public Employee changeValueEdit(Employee employee) {
        try {
            String id = employee.getId();
            String name = employee.getName();
            String date = employee.getDateOfBirth();
            boolean gender = employee.isGender();
            String identityId = employee.getIdentityId();
            String phone = employee.getTelephone();
            String email = employee.getEmail();
            int level = employee.getLevel();
            int position = employee.getPosition();
            int salary = employee.getSalary();

            boolean flag = true;

            do {
                int choice;
                String choiceStr;
                do {
                    System.out.print("\n - Enter your property want to edit (0 : exit): ");
                    choiceStr = input.nextLine();
                } while (!choiceStr.matches("^[0-9]{1,2}$"));
                choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID ");
                        id = checkValueInput.checkIdEmployee();
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
                        System.out.print("Enter Gender:  ");
                        gender = checkValueInput.checkGender();
                    }
                    case 5 -> {
                        System.out.print("Enter Identity Id ");
                        identityId = checkValueInput.checkIdentityId();
                    }
                    case 6 -> {
                        System.out.print("Enter Email: ");
                        email = checkValueInput.checkEmail();
                    }
                    case 7 -> {
                        System.out.print("Enter Level ");
                        level = checkValueInput.checkLevel();
                    }
                    case 8 -> {
                        System.out.print("Enter Position ");
                        position = checkValueInput.checkPosition();
                    }
                    case 9 -> {
                        System.out.print("Enter Salary ");
                        salary = checkValueInput.checkSalary();
                    }
                    case 10 -> {
                        System.out.print("Enter Telephone Number ");
                        phone = checkValueInput.checkPhoneNumber();
                    }
                    case 0 -> flag = false;
                }

                Employee employeeHolder = new Employee(id, name, date, gender, identityId, phone, email, level, position, salary);
                formHead();
                System.out.println(employeeHolder);
                System.out.print("\n - continue ? (yes / no) : ");
                String anwser = input.nextLine().toLowerCase().trim();
                if (anwser.equals("no")) {
                    System.out.print(" - Do you want to Save ? (yes / no) : ");
                    String save = input.nextLine().trim().toLowerCase();
                    if (save.equals("no")) {
                        flag = false;
                    } else if (save.equals("yes")) {
                        System.out.println("---------------DONE---------------");
                        return employeeHolder;
                    }
                } else if (anwser.equals("yes")) {
                    flag = true;
                }
            } while (flag);
            System.out.println("---------------cancel---------------");
            return employee;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return employee;
        }
    }
}
