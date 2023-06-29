package repository.interface_repo;

import model.booking.Voucher;
import model.person.Customer;

import java.util.List;
import java.util.Set;

public interface IPromotionRepository {
    Set<Customer> showInYear();

    Set<Customer> inMonth();

    void addVoucher(List<Voucher> list);
}
