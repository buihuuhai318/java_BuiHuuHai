package repository.class_repo;

import data.ReadAnhWriteFile;
import model.person.Customer;
import repository.interface_repo.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;


public class CustomerRepository implements ICustomerRepository {

    static ReadAnhWriteFile readAnhWriteFile = new ReadAnhWriteFile();

    static List<Customer> customerList = new ArrayList<>();

    static {
//        customerList.add(new Customer("KH-0000", "Bùi Hữu Hải", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 1, "asd"));
//        customerList.add(new Customer("KH-0001", "Nguyễn Hoàng Nguyên", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 2, "asd"));
//        customerList.add(new Customer("KH-0002", "Lê Công Hoàn Thiện", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 3, "asd"));
//        customerList.add(new Customer("KH-0003", "David Nộp", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 3, "asd"));
//        customerList.add(new Customer("KH-0004", "Tôm Đú", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 3, "asd"));
//        String line;
//        for (Customer customer : customerList) {
//            line = customer.getId() + "," +
//                    customer.getName() + "," +
//                    customer.getDateOfBirth() + "," +
//                    customer.isGender() + "," +
//                    customer.getIdentityId() + "," +
//                    customer.getTelephone() + "," +
//                    customer.getEmail() + "," +
//                    customer.getTypeOfCustomer() + "," +
//                   customer.getAddress();
//            readAnhWriteFile.writeFile(readAnhWriteFile.CUSTOMER_FILE, line);
//        }
        List<String> customerArrList = readAnhWriteFile.readFile(readAnhWriteFile.CUSTOMER_FILE);
        String[] line;
        for (String s : customerArrList) {
            line = s.split(",");
            customerList.add(new Customer(line[0], line[1], line[2], Boolean.parseBoolean(line[3]), line[4], line[5], line[6], Integer.parseInt(line[7]), line[8]));
        }
    }

    @Override
    public void addNew(Customer customer) {
        String line = customer.getId() + "," +
                    customer.getName() + "," +
                    customer.getDateOfBirth() + "," +
                    customer.isGender() + "," +
                    customer.getIdentityId() + "," +
                    customer.getTelephone() + "," +
                    customer.getEmail() + "," +
                    customer.getTypeOfCustomer() + "," +
                   customer.getAddress();
        customerList.add(customer);
        readAnhWriteFile.writeFile(readAnhWriteFile.CUSTOMER_FILE, line);
    }

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit(int index, Customer customer) {
        customerList.set(index, customer);
        updateFile();
    }
    public void updateFile() {
        String line;
        List<String> list = new ArrayList<>();
        for (Customer customer : customerList) {
            line = customer.getId() + "," +
                    customer.getName() + "," +
                    customer.getDateOfBirth() + "," +
                    customer.isGender() + "," +
                    customer.getIdentityId() + "," +
                    customer.getTelephone() + "," +
                    customer.getEmail() + "," +
                    customer.getTypeOfCustomer() + "," +
                    customer.getAddress();
            list.add(line);
        }
        readAnhWriteFile.updateFile(readAnhWriteFile.CUSTOMER_FILE, list);
    }


    @Override
    public int checkID(String id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Customer getElement(int index) {
        return customerList.get(index);
    }

    public void formHead() {
        System.out.printf(
                "\n| %8s | %20s | %8s | %13s | %10s | %11s | %12s | %20s | %25s |\n",
                "---ID---", "--------Name--------", "-Gender-", "-Identity Id-", "-Birthday-", "---Phone---", "---Member---", "-------Email-------", "---------Address---------");
    }
}
