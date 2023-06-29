package repository.interface_repo;

import model.booking.Booking;

public interface IBookingRepository extends IRepository<Booking> {
    void bookingHead();

    Booking getElementQueue();

    void pollBooking();
}
