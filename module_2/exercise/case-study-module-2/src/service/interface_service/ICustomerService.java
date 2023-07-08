package service.interface_service;

import model.person.Customer;

public interface ICustomerService {
    void edit();

    Customer changeValueEdit(Customer customer);
}
