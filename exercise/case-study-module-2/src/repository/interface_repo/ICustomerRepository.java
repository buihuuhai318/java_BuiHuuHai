package repository.interface_repo;

import model.person.Customer;

public interface ICustomerRepository extends IRepository<Customer> {
    void edit(int index, Customer customer);

    void updateFile();

    void formHead();
}
