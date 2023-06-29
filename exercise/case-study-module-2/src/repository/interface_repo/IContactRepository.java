package repository.interface_repo;

import model.booking.Booking;
import model.booking.Contract;

public interface IContactRepository extends IRepository<Contract> {
    void peekBooking();

    Booking getPeekBooking();

    void head();

    void edit(Contract contract, int index);
}
