package com.example.team1.service.customer;

import com.example.team1.model.customers.Customers;

import java.util.Map;

public interface ICustomerService {
    void insertCustomer(Customers customers);

    Customers selectCustomer(int id);

    Map<Integer, Customers> selectAllCustomer();
    public Map<String, Customers> selectAllCustomerByEmail();

    void deleteCustomer(int id, boolean available);

    void updateCustomer(int id, Customers customers);
}
