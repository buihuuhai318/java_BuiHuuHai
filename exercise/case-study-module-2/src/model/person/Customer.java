package model.person;

import utils.ColorInConsole;

import java.util.HashMap;
import java.util.Map;

public class Customer extends Person {
    private int typeOfCustomer;
    private String address;

    static Map<Integer, String> typeOfCustomerMap = new HashMap<>();

    static {
//        typeOfCustomerMap.put(1, ColorInConsole.ANSI_RED + "Diamond" + ColorInConsole.ANSI_RESET);
//        typeOfCustomerMap.put(2, ColorInConsole.ANSI_PURPLE + "Platinum" + ColorInConsole.ANSI_RESET);
//        typeOfCustomerMap.put(3, ColorInConsole.ANSI_YELLOW + "Gold" + ColorInConsole.ANSI_RESET);
//        typeOfCustomerMap.put(4, ColorInConsole.ANSI_BLUE + "Silver" + ColorInConsole.ANSI_RESET);
//        typeOfCustomerMap.put(5, "Member");
        typeOfCustomerMap.put(1, "Diamond");
        typeOfCustomerMap.put(2, "Platinum");
        typeOfCustomerMap.put(3, "Gold");
        typeOfCustomerMap.put(4, "Silver");
        typeOfCustomerMap.put(5, "Member");
    }

    public Customer() {
    }

    public Customer(String id, String name, String dateOfBirth, boolean gender, String identityId, String telephone, String email, int typeOfCustomer, String address) {
        super(id, name, dateOfBirth, gender, identityId, telephone, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public int getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(int typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String sex;
        if (gender) {
            sex = "nam";
        } else {
            sex = "nữ";
        }
        return String.format(
                "| %8s | %20s | %8s | %13s | %10s | %11s | %12s | %20s | %25s |",
                id, name, sex, identityId, dateOfBirth, telephone, typeOfCustomerMap.get(typeOfCustomer), email, address);
    }
}
