package model.booking;

import model.person.Customer;

public class Voucher {
    private String code;
    private int sale;
    private Customer customer;

    static int countVoucher = 0;

    public Voucher() {
        code = "FU_VOUCHER_" + countVoucher++;
    }

    public Voucher(int sale, Customer customer) {
        this.code = "FU_VOUCHER_" + countVoucher++;
        this.sale = sale;
        this.customer = customer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "code='" + code + '\'' +
                ", sale=" + sale +
                ", customerId='" + customer.getId() + '\'' +
                '}';
    }
}
