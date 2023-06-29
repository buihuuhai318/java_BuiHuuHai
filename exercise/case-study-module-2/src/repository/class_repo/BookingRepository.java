package repository.class_repo;

import model.booking.Booking;
import repository.interface_repo.IBookingRepository;

import java.util.*;

public class BookingRepository implements IBookingRepository {

    static Set<Booking> bookingSet = new TreeSet<>();
    static Queue<Booking> bookingQueue = new PriorityQueue<>();

    static {
        bookingSet.add(new Booking("16-06-2022", "2022-05-23", "2022-06-12", "KH-0003", "SVRO-0001"));
        bookingSet.add(new Booking("16-06-2022", "2022-05-23", "2022-06-12", "KH-0004", "SVRO-0000"));
        bookingSet.add(new Booking("16-06-2022", "2022-05-23", "2022-06-12", "KH-0002", "SVHO-0001"));

        bookingSet.add(new Booking("16-05-2023", "2023-05-23", "2023-06-12", "KH-0004", "SVVL-0001"));
        bookingSet.add(new Booking("16-05-2023", "2023-05-23", "2023-06-12", "KH-0001", "SVHO-0000"));
        bookingSet.add(new Booking("16-05-2023", "2023-05-23", "2023-06-12", "KH-0003", "SVRO-0001"));
        bookingSet.add(new Booking("16-05-2023", "2023-05-23", "2023-06-12", "KH-0000", "SVRO-0000"));

        bookingSet.add(new Booking("10-06-2023", "2023-06-19", "2023-06-25", "KH-0000", "SVVL-0000"));
        bookingSet.add(new Booking("11-06-2023", "2023-06-20", "2023-06-25", "KH-0001", "SVVL-0000"));
        bookingSet.add(new Booking("12-06-2023", "2023-06-21", "2023-06-25", "KH-0002", "SVVL-0000"));

        bookingSet.add(new Booking("20-06-2023", "2023-06-22", "2023-06-25", "KH-0000", "SVVL-0000"));
        bookingSet.add(new Booking("20-06-2023", "2023-06-22", "2023-06-24", "KH-0001", "SVVL-0001"));
        bookingSet.add(new Booking("20-06-2023", "2023-06-23", "2023-06-26", "KH-0002", "SVHO-0001"));
        bookingSet.add(new Booking("16-06-2023", "2023-05-23", "2023-06-27", "KH-0003", "SVHO-0001"));

        bookingQueue.addAll(bookingSet);
        bookingQueue.poll();
        bookingQueue.poll();
        bookingQueue.poll();
        bookingQueue.poll();
        bookingQueue.poll();
        bookingQueue.poll();
        bookingQueue.poll();
    }

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
