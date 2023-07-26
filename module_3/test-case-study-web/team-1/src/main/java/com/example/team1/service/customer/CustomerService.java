package com.example.team1.service.customer;

import com.example.team1.model.customers.Customers;
import com.example.team1.repository.customer.CustomerRepository;
import com.example.team1.repository.customer.ICustomerRepository;

import java.util.Map;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void insertCustomer(Customers customers) {
        customerRepository.insertCustomer(customers);
    }

    @Override
    public Customers selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public Map<Integer, Customers> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public Map<String, Customers> selectAllCustomerByEmail() {
        return customerRepository.selectAllCustomerByEmail();
    }

    @Override
    public void deleteCustomer(int id, boolean available) {
        customerRepository.deleteCustomer(id, available);
    }

    @Override
    public void updateCustomer(int id, Customers customers) {
        customerRepository.updateCustomer(id, customers);
    }
}
