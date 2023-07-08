package repository.class_repo;

import model.booking.Booking;
import repository.interface_repo.IBookingRepository;

import java.util.*;

public class BookingRepository implements IBookingRepository {

    static Set<Booking> bookingSet = new TreeSet<>();
    static Queue<Booking> bookingQueue = new PriorityQueue<>();

    @Override
    public void addNew(Booking booking) {
        bookingSet.add(booking);
        bookingQueue.add(booking);
    }

    @Override
    public void display() {
        bookingHead();
        for (Booking book : bookingQueue) {
            System.out.println(book);
        }
    }

    @Override
    public void bookingHead() {
        System.out.printf("\n|%8s|%9s|%11s|%11s|%10s|%11s|\n",
                "-- Code --", "--ID_KH--", "--Service--", "--Date Book--", "-Start Rent-", "--Stop Rent--");
    }

    @Override
    public Booking getElement(int index) {
        List<Booking> bookings = new ArrayList<>(bookingSet);
        return bookings.get(index);
    }

    @Override
    public Booking getElementQueue() {
        return bookingQueue.peek();
    }

    public void pollBooking() {
        bookingQueue.poll();
    }

    @Override
    public int checkID(String id) {
        List<Booking> bookings = new ArrayList<>(bookingSet);
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingCode().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
